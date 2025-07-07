package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.dto.LeitoDTO;
import com.vidaplus.sghss.model.Leito;
import com.vidaplus.sghss.service.LeitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leitos")
@RequiredArgsConstructor
public class LeitoController {

    private final LeitoService leitoService;

    @GetMapping("/disponiveis")
    @PreAuthorize("hasAnyRole('MEDICO', 'ADMIN')")
    public ResponseEntity<List<Leito>> listarLeitosDisponiveis() {
        return ResponseEntity.ok(leitoService.listarLeitosDisponiveis());
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('MEDICO', 'ADMIN')")
    public ResponseEntity<Void> criarLeito(@RequestBody LeitoDTO leitoDTO) {
        leitoService.criarLeito(leitoDTO);
        return ResponseEntity.ok().build();
    }
}
