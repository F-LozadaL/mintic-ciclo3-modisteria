package co.utp.misiontic.g12e1.proyectomodisteria.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ItemDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;

public interface ItemService {

    public void insertItem(Long cliente, Long producto, Integer cantidad);

    public ProductoDto getProductoDto(Item item);

    public ItemDto toItemDto(Item item);

    

    
}
