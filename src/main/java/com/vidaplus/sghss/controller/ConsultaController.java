package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.dto.ConsultaDTO;
import com.vidaplus.sghss.service.ConsultaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/consulta")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<ConsultaDTO> agendarConsulta(@RequestBody ConsultaDTO consultaDTO) {
        return ResponseEntity.ok(consultaService.agendarConsulta(consultaDTO));
    }

    @GetMapping("/paciente/{pacienteId}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<List<ConsultaDTO>> listarConsultasPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(consultaService.listarConsultasPorPaciente(pacienteId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<ConsultaDTO> buscarConsulta(@PathVariable Long id) {
        return ResponseEntity.ok(consultaService.buscarConsulta(id));
    }

}
