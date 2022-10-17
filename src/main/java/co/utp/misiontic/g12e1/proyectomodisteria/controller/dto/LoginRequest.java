package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}