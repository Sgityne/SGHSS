package com.vidaplus.sghss.dto;

import com.vidaplus.sghss.enums.StatusConsulta;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {

    private Long id;

    private Long pacienteId;

    private Long medicoId;

    private LocalDateTime dataHora;

    private StatusConsulta status;
}
