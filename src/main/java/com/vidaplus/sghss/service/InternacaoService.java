package com.vidaplus.sghss.service;

import com.vidaplus.sghss.enums.StatusLeito;
import com.vidaplus.sghss.model.Internacao;
import com.vidaplus.sghss.model.Leito;
import com.vidaplus.sghss.model.Paciente;
import com.vidaplus.sghss.repository.InternacaoRepository;
import com.vidaplus.sghss.repository.LeitoRepository;
import com.vidaplus.sghss.repository.PacienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InternacaoService {

    private final InternacaoRepository internacaoRepository;
    private final PacienteRepository pacienteRepository;
    private final LeitoRepository leitoRepository;

    @Transactional
    public Internacao internarPaciente(Long pacienteId, Long leitoId) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        Leito leito = leitoRepository.findById(leitoId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        if (leito.getStatus() == StatusLeito.OCUPADO) {
            throw new RuntimeException("Leito já está ocupado");
        }

        leito.setStatus(StatusLeito.OCUPADO);
        leitoRepository.save(leito);

        Internacao internacao = new Internacao();
        internacao.setPaciente(paciente);
        internacao.setLeito(leito);
        internacao.setDataEntrada(LocalDateTime.now());

        return internacaoRepository.save(internacao);
    }

    @Transactional
    public void darAlta(Long id) {
        Internacao internacao = internacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Internação não encontrada"));

        Leito leito = internacao.getLeito();
        leito.setStatus(StatusLeito.DISPONIVEL);
        leitoRepository.save(leito);
        internacao.setDataSaida(LocalDateTime.now());
        internacaoRepository.save(internacao);
    }

    public List<Internacao> listarInternacoes() {
        return internacaoRepository.findAll();
    }
}
