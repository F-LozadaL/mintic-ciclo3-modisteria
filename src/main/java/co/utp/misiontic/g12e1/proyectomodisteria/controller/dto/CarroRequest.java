package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroRequest {

    private String mode;
    private Integer idcliente;
    private Integer idproducto;
    
}
