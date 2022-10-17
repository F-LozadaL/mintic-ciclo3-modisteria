package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.UserResponse;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ClienteRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ClienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepo;

    private final CarroServiceImpl carrosvc;

    @Override
    public UserResponse validarUsuario(String user, String password) {

        var clienteOp = clienteRepo.findByUserAndPassword(user, password);
        if (clienteOp.isEmpty()) {
            throw new RuntimeException("Credenciales inválidas");
        }
        
        var cliente = clienteOp.get();
        return UserResponse.builder()
                .clienteid(cliente.getIdCliente().intValue())
                .name(cliente.getFirstName())
                .email(cliente.getEmail())
                .carro(carrosvc.cargarCarro(cliente.getIdCliente()))
                .build();
    }


    
    
}
