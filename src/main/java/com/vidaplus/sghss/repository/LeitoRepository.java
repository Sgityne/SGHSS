package com.vidaplus.sghss.repository;

import com.vidaplus.sghss.enums.StatusLeito;
import com.vidaplus.sghss.model.Leito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeitoRepository extends JpaRepository<Leito, Long> {
    List<Leito> findByStatus(StatusLeito status);
}
