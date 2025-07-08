package com.vidaplus.sghss.service;

import com.vidaplus.sghss.dto.SuprimentoDTO;
import com.vidaplus.sghss.model.Suprimento;
import com.vidaplus.sghss.repository.SuprimentoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SuprimentoService {

    private final SuprimentoRepository suprimentoRepository;
    private final ModelMapper modelMapper;

    public List<SuprimentoDTO> listarTodos() {
        List<Suprimento> suprimentos = suprimentoRepository.findAll();
        return suprimentos.stream()
                .map(suprimento -> modelMapper.map(suprimento, SuprimentoDTO.class))
                .toList();
    }

    public SuprimentoDTO buscarPorId(Long id) {
        Suprimento suprimento = suprimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suprimento não encontrado"));
        return modelMapper.map(suprimento, SuprimentoDTO.class);
    }

    @Transactional
    public SuprimentoDTO salvar(SuprimentoDTO suprimentoDTO) {
        Suprimento suprimento = modelMapper.map(suprimentoDTO, Suprimento.class);
        suprimento = suprimentoRepository.save(suprimento);
        return modelMapper.map(suprimento, SuprimentoDTO.class);
    }

    @Transactional
    public SuprimentoDTO atualizar(Long id, SuprimentoDTO suprimentoDTO) {
        Optional<Suprimento> suprimentoOptional = suprimentoRepository.findById(id);
        if(suprimentoOptional.isEmpty()) {
            throw new RuntimeException("Suprimento não encontrado");
        }
        Suprimento suprimentoNew = modelMapper.map(suprimentoDTO, Suprimento.class);
        suprimentoNew.setId(id);
        suprimentoRepository.save(suprimentoNew);
        return modelMapper.map(suprimentoNew, SuprimentoDTO.class);
    }

    @Transactional
    public void deletar (Long id) {
        if (!suprimentoRepository.existsById(id)) {
            throw new RuntimeException("Suprimento não encontrado");
        }
        suprimentoRepository.deleteById(id);
    }
}
