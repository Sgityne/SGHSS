package com.vidaplus.sghss.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "suprimento")
public class Suprimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer quantidade;
}
