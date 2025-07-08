package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.dto.SuprimentoDTO;
import com.vidaplus.sghss.service.SuprimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/suprimentos")
@RequiredArgsConstructor
public class SuprimentoController {

    private final SuprimentoService suprimentoService;

    @GetMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<List<SuprimentoDTO>> listarTodos() {
        return ResponseEntity.ok(suprimentoService.listarTodos());
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<SuprimentoDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(suprimentoService.buscarPorId(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<SuprimentoDTO> salvar(@RequestBody SuprimentoDTO suprimentoDTO) {
        return ResponseEntity.ok(suprimentoService.salvar(suprimentoDTO));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('MEDICO')")
    public ResponseEntity<SuprimentoDTO> atualizar(@PathVariable Long id, @RequestBody SuprimentoDTO suprimentoDTO) {
        return ResponseEntity.ok(suprimentoService.atualizar(id, suprimentoDTO));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        suprimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
