package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.ItemPk;

public interface ItemRepository extends JpaRepository<Item, ItemPk> {

        // @Query(" SELECT DISTINCT p "
        // + "FROM Producto p JOIN p.categories c "
        // + "WHERE c.name IN :filtros "
        // + "ORDER BY p.name ASC ")

        @Query(" SELECT DISTINCT i "
                        + "FROM Item i JOIN i.idItem.client c "
                        + "WHERE c.idCliente = :id ")
        Optional<List<Item>> verCarro(Long id);

        @Query(value = "SELECT i.* FROM item i WHERE i.id_cliente = :idCliente AND i.id_producto = :idProducto", nativeQuery = true)
        Optional<Item> findParticular(Long idCliente, Long idProducto);

        @Modifying
        @Transactional
        @Query(value = "DELETE FROM item i WHERE i.id_cliente = :idCliente AND i.id_producto = :idProducto", nativeQuery = true)
        void deleteParticular(Long idCliente, Long idProducto);

}
