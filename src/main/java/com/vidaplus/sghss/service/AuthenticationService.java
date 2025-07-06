package com.vidaplus.sghss.service;

import com.vidaplus.sghss.dto.AuthRequestDTO;
import com.vidaplus.sghss.dto.AuthResponseDTO;
import com.vidaplus.sghss.dto.RegisterDTO;
import com.vidaplus.sghss.model.User;
import com.vidaplus.sghss.repository.UserRepository;
import com.vidaplus.sghss.security.TokenService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthResponseDTO login(AuthRequestDTO request) {
        var auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        String token = tokenService.generateToken((User) auth.getPrincipal());
        return new AuthResponseDTO(token);
    }

    @Transactional
    public void register(RegisterDTO request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("E-mail já cadastrado");
        }

        User newUser = new User();
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setEmail(request.getEmail());
        newUser.setNome(request.getNome());
        newUser.setRole(request.getRole());

        userRepository.save(newUser);
    }
}
