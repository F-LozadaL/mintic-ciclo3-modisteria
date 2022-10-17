package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

    // Cliente findAllByid(Long clienteId);
    Cliente findByidCliente(Long id);
    // void insertItem(Item item);

    Optional<Cliente> findByUserAndPassword (String user, String password);
}
