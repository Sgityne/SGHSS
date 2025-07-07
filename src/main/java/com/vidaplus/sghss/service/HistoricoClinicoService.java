package com.vidaplus.sghss.service;

import com.vidaplus.sghss.model.HistoricoClinico;
import com.vidaplus.sghss.repository.HistoricoClinicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HistoricoClinicoService {

    private final HistoricoClinicoRepository historicoClinicoRepository;

    public void registrar(Long id, String descricao) {
        HistoricoClinico historicoClinico = historicoClinicoRepository.findByPaciente_id(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        historicoClinico.setDescricao(historicoClinico.getDescricao() + "\n " + descricao);
        historicoClinicoRepository.save(historicoClinico);
    }
}
