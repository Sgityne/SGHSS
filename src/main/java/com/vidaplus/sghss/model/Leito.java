package com.vidaplus.sghss.model;

import com.vidaplus.sghss.enums.StatusLeito;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "leitos")
public class Leito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    @Enumerated(EnumType.STRING)
    private StatusLeito status;
}
