package com.vidaplus.sghss.service;

import com.vidaplus.sghss.dto.LeitoDTO;
import com.vidaplus.sghss.enums.StatusLeito;
import com.vidaplus.sghss.model.Leito;
import com.vidaplus.sghss.repository.LeitoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeitoService {

    private final LeitoRepository leitoRepository;
    private final ModelMapper modelMapper;

    public List<Leito> listarLeitosDisponiveis() {
        return leitoRepository.findByStatus(StatusLeito.DISPONIVEL);
    }

    public void criarLeito(LeitoDTO leitoDTO) {
        Leito leito = modelMapper.map(leitoDTO, Leito.class);
        leito.setStatus(StatusLeito.DISPONIVEL);
        leitoRepository.save(leito);
    }
}
