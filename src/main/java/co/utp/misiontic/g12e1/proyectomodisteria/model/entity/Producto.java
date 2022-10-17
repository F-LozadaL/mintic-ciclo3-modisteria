package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

// import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "Name", nullable = false, length = 100)
    private String name;
    @Column(name = "Price", nullable = false, length = 100)
    private Double price;
    @Column(name = "Description", length = 255)
    private String description;
    @Column(name = "ImageUrl", length = 100)
    private String imageUrl;

    // -------RELACIONES
    @ManyToMany
    @JoinTable(name = "Tag", joinColumns = @JoinColumn(name = "ID_Producto"), inverseJoinColumns = @JoinColumn(name = "ID_Categoria"))
    private List<Categoria> categories;

    @ManyToMany
    @JoinTable(name = "Molde", joinColumns = @JoinColumn(name = "ID_Producto"), inverseJoinColumns = @JoinColumn(name = "ID_Talla"))
    private List<Talla> sizes;

    @OneToMany(mappedBy = "idItem.product")
    private List<Item> compras;

    // -------CONSTRUCTOR
    // public Producto(String name, Double price, String imageUrl ){
    // this.name = name;
    // this.price = price;
    // this.imageUrl= imageUrl;
    // }
    public Producto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Long id, String name, Double price, String imageUrl, List<Categoria> categories) {
        this.idProducto = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.categories = categories;
    }

}
