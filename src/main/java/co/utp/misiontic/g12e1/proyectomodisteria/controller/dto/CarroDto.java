package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDto {
    private List<ItemDto> items;
}
