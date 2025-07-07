package com.vidaplus.sghss.service;

import com.vidaplus.sghss.dto.PacienteDTO;
import com.vidaplus.sghss.model.Paciente;
import com.vidaplus.sghss.repository.ConsultaRepository;
import com.vidaplus.sghss.repository.ExameRepository;
import com.vidaplus.sghss.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;
    private final ConsultaRepository consultaRepository;
    private final ExameRepository exameRepository;
    private final ModelMapper modelMapper;

    public List<PacienteDTO> listarTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        return pacientes.stream()
                .map(paciente -> modelMapper.map(paciente, PacienteDTO.class))
                .toList();
    }

    public PacienteDTO buscarPorId(Long id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Transactional
    public PacienteDTO salvar(PacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
        paciente = pacienteRepository.save(paciente);
        return modelMapper.map(paciente, PacienteDTO.class);
    }

    @Transactional
    public PacienteDTO atualizar(Long id, PacienteDTO pacienteDTO) {
        Optional<Paciente> pacienteOld = pacienteRepository.findById(id);
        if(pacienteOld.isEmpty()) {
            throw new RuntimeException("Paciente não encontrado");
        }
        Paciente pacienteNew = modelMapper.map(pacienteDTO, Paciente.class);
        pacienteNew.setId(id);
        pacienteRepository.save(pacienteNew);
        return modelMapper.map(pacienteNew, PacienteDTO.class);
    }

    @Transactional
    public void deletar (Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new RuntimeException("Paciente não encontrado");
        }
        consultaRepository.deleteByPacienteId(id);
        exameRepository.deleteByPacienteId(id);
        pacienteRepository.deleteById(id);
    }
}
