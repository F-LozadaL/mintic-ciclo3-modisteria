package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.List;
/* import java.util.Optional;
import java.util.stream.Collector; */
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
// import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CatalogoService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CatalogoServiceImpl implements CatalogoService{

    private final ProductoRepository productoRepository;
    // private final CategoriaRepository categoriaRepository;

    

    @Override
    public List<ProductoDto> getProductosByCategoryId(Integer categoryId) {
        
        return null;
    }
    
}
