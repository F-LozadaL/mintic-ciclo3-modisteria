package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPk implements Serializable {
    // -------RELACIONES
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto product;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente client;

}
