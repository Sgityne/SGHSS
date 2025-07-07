package com.vidaplus.sghss.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "historico_clinico")
public class HistoricoClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    private String descricao;
}
