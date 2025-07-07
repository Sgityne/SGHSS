package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.dto.ExameDTO;
import com.vidaplus.sghss.service.ExameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/exames")
@RequiredArgsConstructor
public class ExameController {

    private final ExameService exameService;

    @PostMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<ExameDTO> registrarExame(@RequestBody ExameDTO exameDTO) {
        return ResponseEntity.ok(exameService.registrarExame(exameDTO));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<List<ExameDTO>> listarExames(@PathVariable Long id) {
        return ResponseEntity.ok(exameService.listarExamesPorPaciente(id));
    }
}
