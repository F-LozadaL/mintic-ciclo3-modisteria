package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.ItemPk;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ItemRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CarroService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ItemService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarroServiceImpl implements CarroService{

    private final ItemRepository itemRepo;
    private final ItemService itemsvc;

    @Override
    public Map cargarCarro(Long idCliente) {

        var saved_carro = itemRepo.verCarro(idCliente);
        if(saved_carro.isEmpty()){
            return new TreeMap();
        }

        return saved_carro.get().stream().collect(Collectors.toMap(Item::getProductoId,Item::getQuantity));
    }

    @Override
    public void addItem(Integer idCliente, Integer idProducto) {
        
        var itemopt = itemRepo.findParticular(idCliente.longValue(), idProducto.longValue());
        if(!itemopt.isEmpty()){
            var item = itemopt.get();
            item.setQuantity(item.getQuantity()+1);
            itemRepo.save(item);
        }else{
            itemsvc.insertItem(idCliente.longValue(), idProducto.longValue(), 1);
        }
    }

    @Override
    public void removeItem(Integer idCliente, Integer idProducto) {
        var itemopt = itemRepo.findParticular(idCliente.longValue(), idProducto.longValue());
        if(!itemopt.isEmpty()){
            var item = itemopt.get();
            if(item.getQuantity()==1){
                
            }else{
                item.setQuantity(item.getQuantity()-1);
                itemRepo.save(item);
            }
        }
    }

    @Override
    public void deleteItem(Integer idCliente, Integer idProducto) {
        itemRepo.deleteParticular(idCliente.longValue(), idProducto.longValue());
    }
}
