package com.vidaplus.sghss.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ExameDTO {

    private Long id;

    private Long pacienteId;

    private String descricao;

    private LocalDateTime dataHora;
}
