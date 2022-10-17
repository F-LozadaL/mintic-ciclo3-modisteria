package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;


import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    private Integer clienteid;
    
    private String name;

    private String email;
    
    private Map carro;
    
}
