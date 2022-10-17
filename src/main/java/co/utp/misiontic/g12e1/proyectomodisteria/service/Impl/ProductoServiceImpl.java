package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;

import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepo;
    private CategoriaRepository categoriaRepo;

    @Override
    public Producto saveProducto(Producto producto) {

        Producto p_new = new Producto(producto.getIdProducto());

        p_new.setName(producto.getName());
        p_new.setImageUrl(producto.getImageUrl());
        p_new.setPrice(producto.getPrice());

        p_new.setCategories(producto
                .getCategories()
                .stream()
                .map(c -> {
                    Categoria cc = categoriaRepo.findByidCategoria(c.getIdCategoria());
                    cc.getProducts().add(p_new);
                    System.out.println("producto agregado a categoria");
                    return cc;
                }).collect(Collectors.toList()));

        System.out.println("productos guardados");
        return productoRepo.save(p_new);
    }

    @Override
    public Producto saveProductos(List<Producto> productos) {
        
        return null;
    }

    @Override
    public List<ProductoDto> buscarProductosFiltrados(List<String> filtros) {

        if (filtros == null) {
            return getProductos();
        } else {
            return productoRepo.busquedaFiltrada(filtros).stream()
                    .map(p -> new ProductoDto(
                            p.getIdProducto().intValue(),
                            p.getPrice(),
                            p.getName(),
                            p.getImageUrl()))
                    .collect(Collectors.toList());
        }

    }

    @Override
    public List<ProductoDto> getProductos() {
        var productos = productoRepo.findAll(Sort.by("name"));

        return productos.stream()
                .map(p -> new ProductoDto(p.getIdProducto().intValue(), p.getPrice(), p.getName(), p.getImageUrl()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDto getProductoDto(Integer productoId) {
        var popt = productoRepo.findById(productoId.longValue());
        if(popt.isEmpty()){
            return null;
        }else{
            var p= popt.get();
            return ProductoDto.builder()
            .id(p.getIdProducto().intValue())
            .precio(p.getPrice())
            .nombre(p.getName())
            .imageUrl(p.getImageUrl())
            .build();
        }
    }
}
