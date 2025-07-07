package com.vidaplus.sghss.service;

import com.vidaplus.sghss.dto.ExameDTO;
import com.vidaplus.sghss.model.Exame;
import com.vidaplus.sghss.model.Paciente;
import com.vidaplus.sghss.repository.ExameRepository;
import com.vidaplus.sghss.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExameService {

    private final ExameRepository exameRepository;
    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;

    public ExameDTO registrarExame(ExameDTO exameDTO) {
        Paciente paciente = pacienteRepository.findById(exameDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Exame exame = modelMapper.map(exameDTO, Exame.class);
        exame.setPaciente(paciente);
        exame.setDataHora(LocalDateTime.now());
        exameRepository.save(exame);

        return modelMapper.map(exame, ExameDTO.class);
    }

    public List<ExameDTO> listarExamesPorPaciente(Long pacienteId) {
        List<Exame> exames = exameRepository.findByPacienteId(pacienteId);
        return exames.stream()
                .map(exame -> modelMapper.map(exame, ExameDTO.class))
                .toList();
    }
}
