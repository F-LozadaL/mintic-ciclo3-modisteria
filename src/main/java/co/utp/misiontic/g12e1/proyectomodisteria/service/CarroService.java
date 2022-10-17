package co.utp.misiontic.g12e1.proyectomodisteria.service;

import java.util.List;
import java.util.Map;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.CarroDto;



public interface CarroService {

    public Map cargarCarro(Long idCliente);
    
    void addItem(Integer idCliente, Integer idProducto);

    void removeItem(Integer idCliente, Integer idProducto);
    
    void deleteItem(Integer idCliente, Integer idProducto);
}
