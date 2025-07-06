package com.vidaplus.sghss.dto;

import com.vidaplus.sghss.enums.UserRole;
import lombok.Data;

@Data
public class RegisterDTO {

    private String nome;
    private String email;
    private String password;
    private UserRole role;
}
