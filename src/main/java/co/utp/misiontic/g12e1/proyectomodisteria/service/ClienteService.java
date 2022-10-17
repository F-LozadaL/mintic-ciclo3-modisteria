package co.utp.misiontic.g12e1.proyectomodisteria.service;


import java.util.List;

import org.hibernate.annotations.SourceType;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.UserResponse;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;

public interface ClienteService {

    public UserResponse validarUsuario(String user, String password);
}
