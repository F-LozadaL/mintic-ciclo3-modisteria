package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
/* import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; */
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column(name="ID_Cliente")
    private Long idCliente;

    @Column(name="last_name", nullable = false , length = 100)
    private String lastName;
    @Column(name="first_name", nullable = false , length = 100)
    private String firstName;
    @Column(name="email", nullable = false , length = 100, unique = true)
    private String email;
    @Column(name="phone", nullable = false , length = 100)
    private String phone;
    @Column(name="user", nullable = false , length = 100, unique = true)
    private String user;
    @Column(name="password", nullable = false , length = 100)
    private String password;
    //-------RELACIONES

    @OneToMany(mappedBy = "idItem.client")
    private List<Item> carrito;
    
    //-------CONSTRUCTOR
    public Cliente(Long id, String lastName, String firstName, String email, String phone, String user,
            String password) {
        this.idCliente = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.user = user;
        this.password = password;
    };
}
