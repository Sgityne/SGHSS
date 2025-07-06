package com.vidaplus.sghss.controller;

import com.vidaplus.sghss.dto.AuthRequestDTO;
import com.vidaplus.sghss.dto.AuthResponseDTO;
import com.vidaplus.sghss.dto.RegisterDTO;
import com.vidaplus.sghss.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO request) {
            authenticationService.register(request);
            return ResponseEntity.ok().build();
    }
}
