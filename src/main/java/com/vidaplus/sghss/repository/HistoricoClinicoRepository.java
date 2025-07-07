package com.vidaplus.sghss.repository;

import com.vidaplus.sghss.model.HistoricoClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoricoClinicoRepository extends JpaRepository<HistoricoClinico, Long> {

    Optional<HistoricoClinico> findByPaciente_id(Long paciente_id);
}
