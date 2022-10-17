package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// @IdClass(ItemId.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
// @Builder
// @Table(uniqueConstraints={@UniqueConstraint(columnNames = {"pedido" ,
// "producto"})})
public class Item implements Serializable {

    
    

    @EmbeddedId
    private ItemPk idItem;

    @Column(nullable = false, columnDefinition = "INTEGER DEFAULT 1 CHECK (quantity>= 0)")
    private Integer quantity;

    public static Integer getProductoId(Item item){
        return item.getIdItem().getProduct().getIdProducto().intValue();
    }

}
