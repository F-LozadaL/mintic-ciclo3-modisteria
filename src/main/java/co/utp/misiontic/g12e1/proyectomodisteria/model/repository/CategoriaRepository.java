package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
// import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {

    Categoria findByidCategoria(Long categoriaId);
    // List<Producto> findAllByCategoriaId(Long categoriaId);

    // List<Producto> findAllProducto();
}
