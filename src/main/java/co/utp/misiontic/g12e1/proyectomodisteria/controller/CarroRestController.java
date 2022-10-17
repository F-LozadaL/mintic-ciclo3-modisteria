package co.utp.misiontic.g12e1.proyectomodisteria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.CarroRequest;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CarroService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController

@RequestMapping("carro")
public class CarroRestController {

    private ProductoService productosvc;
    private CarroService carrosvc;

    @GetMapping("/{id}") // /api/movie/t12345
    public ResponseEntity<ProductoDto> getMovieById(@PathVariable("id") String productoid) {

        var producto = productosvc.getProductoDto(Integer.valueOf(productoid));
        return ResponseEntity.ok().body(producto);
    }

    @PostMapping
    public void login(@RequestBody CarroRequest operacion) {
        try {

            switch (operacion.getMode()) {
                case "add":
                    carrosvc.addItem(operacion.getIdcliente(),operacion.getIdproducto());
                    break;
                case "remove":
                    carrosvc.removeItem(operacion.getIdcliente(),operacion.getIdproducto());
                    break;
                case "delete":
                    carrosvc.deleteItem(operacion.getIdcliente(),operacion.getIdproducto());
                    break;
            }

            // var response = securityService.validateUser(user.getUsername(),
            // user.getPassword());
        //     return ResponseEntity.ok(response);
        // } catch (RuntimeException ex) {
        //     return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        //             .body(ex.getMessage());
        // }
        }finally{

        }
    }
}
