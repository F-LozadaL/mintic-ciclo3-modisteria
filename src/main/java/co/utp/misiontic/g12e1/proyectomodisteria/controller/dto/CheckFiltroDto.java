package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CheckFiltroDto {

    // private String id;
    private String name;
    private String tag;
    private String value;
    private Boolean checked;

    public CheckFiltroDto(String name, String tag, String value){
        this.name = name;
        this.tag = tag;
        this.value = value;
    }
}
