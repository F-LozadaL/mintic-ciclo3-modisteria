package co.utp.misiontic.g12e1.proyectomodisteria;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Cliente;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ClienteRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ItemRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CarroService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ItemService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Data
	@Component
	@AllArgsConstructor
	private class DataLoader implements CommandLineRunner {

		
		private final ProductoService productosvc;
		private final ItemService itemsvc;
		private final CarroService carrosvc;

		private final ProductoRepository productoRepo;
		private final CategoriaRepository categoriaRepo;
		private final ClienteRepository clienteRepo;
		private final ItemRepository itemRepo;

		@Override
		public void run(String... args) throws Exception {


			System.out.println("---------------INIT--------------");

			// loadData();

			//test();

		}

		private void test() {

			
			carrosvc.addItem(1001, 1001);

			// var carro = carrosvc.cargarCarro(1002L);
		
			// System.out.println(carro.getItems().size());
		}

		private void loadData() {

			System.out.println("------------LOAD-DATA------------");
			loadCategories();
			loadProducto();
			loadUsers();
			loadItems();
		}
		private void loadItems(){
			itemsvc.insertItem(1001L, 1001L, 2);
			System.out.println("ITEMS GUARDADOS");
			

		}

		public void loadUsers() {
			clienteRepo.saveAll(Arrays.asList(
					new Cliente(1001L, "Lozada", "Francisco", "er@gmail.com", "33333", "admin", "123"),
					new Cliente(1002L, "Perez", "Pepito", "prz@hotmail.com", "545454", "per", "111"),
					new Cliente(1003L, "Lela", "Maria", "mll@outlook.com", "842985", "mar", "111")));
			System.out.println("CLIENTES GUARDADOS");
		}

		private void loadCategories() {
			categoriaRepo.saveAll(Arrays.asList(
					new Categoria(1001L, "pantalon"),
					new Categoria(1002L, "camisa"),
					new Categoria(1003L, "otros"),
					new Categoria(1004L, "col-a"),
					new Categoria(1005L, "col-b"),
					new Categoria(1006L, "fisica"),
					new Categoria(1007L, "diario"),
					new Categoria(1008L, "preescolar")));
			System.out.println("CATEGORIAS GUARDADAS");
		}

		private void loadProducto() {
			// var productos = Arrays.asList(
			// new Producto ("Pantalon Diario", 50.0, "img/product-4.jpg",
			// Arrays.asList(new Categoria(1001L), new Categoria(1007L))),
			// new Producto ("Camisa Fisica", 30.0, "img/product-5.jpg",
			// Arrays.asList(new Categoria(1002L), new Categoria(1006L)))
			// );
			var producto1 = new Producto(1001L, "Pantalon Diario", 50.0, "img/product-4.jpg",
					Arrays.asList(new Categoria(1001L), new Categoria(1007L)));
			var producto2 = new Producto(1002L, "Camisa Fisica", 30.0, "img/product-5.jpg",
					Arrays.asList(new Categoria(1002L), new Categoria(1006L)));
			productosvc.saveProducto(producto1);
			productosvc.saveProducto(producto2);
			System.out.println("PRODUCTOS GUARDADOS");
		}
	}

}
