package com.vidaplus.sghss.repository;

import com.vidaplus.sghss.model.Suprimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuprimentoRepository extends JpaRepository<Suprimento, Long> {
}
