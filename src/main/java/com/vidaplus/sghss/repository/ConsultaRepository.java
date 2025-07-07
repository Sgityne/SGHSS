package com.vidaplus.sghss.repository;

import com.vidaplus.sghss.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    List<Consulta> findByPacienteId(Long pacienteId);
    void deleteByPacienteId(Long pacienteId);
}
