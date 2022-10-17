package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroDto {

    private String nombre;
    private List<CheckFiltroDto> items;

}
