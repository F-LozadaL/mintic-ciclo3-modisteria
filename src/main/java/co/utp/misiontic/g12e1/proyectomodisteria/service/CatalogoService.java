package co.utp.misiontic.g12e1.proyectomodisteria.service;

import java.util.List;
// import java.util.Optional;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;

public interface CatalogoService {

    List<ProductoDto> getProductosByCategoryId(Integer categoryId);
}
