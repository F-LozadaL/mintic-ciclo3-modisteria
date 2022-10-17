package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
/* import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; */
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Talla {

    @Id
    // @Column(name = "ID_Talla")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTalla;

    @Column(name = "Nombre" , nullable = false , length = 10)
    private String talla;

    //-------RELACIONES
    @ManyToMany(mappedBy="sizes", fetch = FetchType.EAGER)
    private List<Producto> products;
}
