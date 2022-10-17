package co.utp.misiontic.g12e1.proyectomodisteria.service;


import java.util.List;
// import java.util.Optional;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
// import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;

public interface ProductoService {

    public Producto saveProducto(Producto producto);

    public Producto saveProductos(List<Producto> productos);

    public List<ProductoDto> buscarProductosFiltrados(List<String> filtros);

    public List<ProductoDto> getProductos();

    public ProductoDto getProductoDto(Integer productoId);
}
