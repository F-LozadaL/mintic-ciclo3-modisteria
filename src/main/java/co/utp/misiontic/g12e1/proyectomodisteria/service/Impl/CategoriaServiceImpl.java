package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CategoriaService;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService{
    
    private CategoriaRepository categoriaRepository;


}
