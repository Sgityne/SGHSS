package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.model.Internacao;
import com.vidaplus.sghss.service.InternacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/internacoes")
@RequiredArgsConstructor
public class InternacaoController {

    private final InternacaoService internacaoService;

    @PostMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<Internacao> internarPaciente(@RequestParam Long pacienteId, @RequestParam Long leitoId) {
        return ResponseEntity.ok(internacaoService.internarPaciente(pacienteId, leitoId));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<Void> darAlta(@PathVariable Long id) {
        internacaoService.darAlta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<List<Internacao>> listarInternacoes() {
        return ResponseEntity.ok(internacaoService.listarInternacoes());
    }
}
