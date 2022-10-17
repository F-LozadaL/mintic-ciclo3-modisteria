package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import java.util.List;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    
    private Integer productoid;
    // private Double precio;
    // private String nombre;
    // private String imageUrl;

    
    private Integer quantity;
}
