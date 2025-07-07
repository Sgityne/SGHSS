package com.vidaplus.sghss.repository;

import com.vidaplus.sghss.model.HistoricoClinico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoricoClinicoRepository extends JpaRepository<HistoricoClinico, Long> {

    Optional<HistoricoClinico> findByPaciente_id(Long paciente_id);
}
