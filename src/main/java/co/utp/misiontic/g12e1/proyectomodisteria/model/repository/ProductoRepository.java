package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // List<Producto> findAllByCategoriaIdIn(List<Long> tags);

    // Optional<Producto> findAllByCategoriaId(Long categoriaId);

    // JPQL -> Selects a objetos JPA
    // @Query("SELECT m FROM Movie m WHERE m.category.id = :categoryId"
    // + " AND (m.username like :name OR m.name like :name) ")

    // Nativo -> SQL
    // @Query(value = "SELECT m.* FROM movie m WHERE m.category_id = :categoryId"
    // + " AND (m.username like :name OR m.name like :name)", nativeQuery = true)
    // List<Movie> findParticular(Long categoryId, String name);

    List<Producto> findAllByPrice(Integer p);

    Producto findByidProducto(Long id);

    @Query(" SELECT DISTINCT p "
            + "FROM Producto p JOIN p.categories c "
            + "WHERE c.name IN :filtros "
            + "ORDER BY p.name ASC ")
    List<Producto> busquedaFiltrada(List<String> filtros);
}
