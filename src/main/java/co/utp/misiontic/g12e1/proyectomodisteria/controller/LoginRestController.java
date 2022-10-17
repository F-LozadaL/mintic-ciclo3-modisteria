package co.utp.misiontic.g12e1.proyectomodisteria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.LoginRequest;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ClienteService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/login")
public class LoginRestController {

    // POST -> Insertar (C)
    // GET -> Consultar / Listar (R)
    // PUT -> Actualizar (U)
    // PATCH -> Actualizar Campo
    // DELETE -> Borrar (D)

    private final ClienteService clientesvc;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest user) {
        try {
            var response = clientesvc.validarUsuario(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(response);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }
    }

    @PostMapping("/fake")
    public  ResponseEntity<?> fakeLogin() {
        return ResponseEntity.badRequest().build();
    }

}