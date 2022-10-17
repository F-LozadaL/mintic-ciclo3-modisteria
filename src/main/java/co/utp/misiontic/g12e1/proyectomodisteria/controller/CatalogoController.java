package co.utp.misiontic.g12e1.proyectomodisteria.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import org.springframework.web.bind.annotation.RequestMapping;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.CheckFiltroDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.FiltroDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.FiltroRequest;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class CatalogoController {

    private ProductoService productoSVC;

    public CatalogoController(ProductoService prodService) {
        this.productoSVC = prodService;
    }

    @GetMapping(value = { "/", "/index", "/index.html" })
    public String goToCatalog(Model modelo) {
        modelo.addAttribute("page", "index");
        return "index";
    }

    @GetMapping("/shop")
    public String goToShop(@ModelAttribute FiltroRequest filtroRequest, Model modelo) {
        var formFiltro = filtroRequest.getFiltro();

        List<ProductoDto> productos;
        productos = productoSVC.buscarProductosFiltrados(formFiltro);
        modelo.addAttribute("productos", productos);

        var filtros = Arrays.asList(
                new FiltroDto("Colegios", Arrays.asList(
                        new CheckFiltroDto("filtro", "Colegio A", "col-a"),
                        new CheckFiltroDto("filtro", "Colegio B", "col-b"))),
                new FiltroDto("Producto", Arrays.asList(
                        new CheckFiltroDto("filtro", "Pantalon", "pantalon"),
                        new CheckFiltroDto("filtro", "Camisa", "camisa"),
                        new CheckFiltroDto("filtro", "Otros", "otros"))),
                new FiltroDto("Tipo de Uniforme", Arrays.asList(
                        new CheckFiltroDto("filtro", "Diario", "diario"),
                        new CheckFiltroDto("filtro", "Fisica", "fisica"))));

        if (formFiltro != null) {
            for (FiltroDto fdto : filtros) {
                for (CheckFiltroDto chk : fdto.getItems()) {
                    if (formFiltro.contains(chk.getValue())) {
                        chk.setChecked(true);
                    }
                }
            }
        }
        modelo.addAttribute("filtros", filtros);

        modelo.addAttribute("page", "shop");

        return "shop";
    }

    
    // @PostMapping("/shop")
    // public String goToShopa(@RequestBody FiltroRequest filtroRequest, Model
    // modelo) {

    // System.out.println(filtroRequest.getFiltros().get(0));

    // List<ProductoDto> productos;
    // productos = catService.getProductos();
    // modelo.addAttribute("productos", productos);

    // var filtros = Arrays.asList(

    // new FiltroDto("Colegios", Arrays.asList(
    // new CheckFiltroDto("filtro", "Colegio A", "col-a"),
    // new CheckFiltroDto("filtro", "Colegio B", "col-b"))),
    // new FiltroDto("Producto", Arrays.asList(
    // new CheckFiltroDto("filtro", "Pantalon", "pantalon"),
    // new CheckFiltroDto("filtro", "Camisa", "camisa"),
    // new CheckFiltroDto("filtro", "Otros", "otros"))),
    // new FiltroDto("Tipo de Uniforme", Arrays.asList(
    // new CheckFiltroDto("filtro", "Diario", "diario"),
    // new CheckFiltroDto("filtro", "Fisica", "fisica"))));
    // modelo.addAttribute("filtros", filtros);

    // modelo.addAttribute("page", "shop");

    // return "shop";
    // }

    @RequestMapping("/detail")
    public String goToDetail(Model modelo) {
        modelo.addAttribute("page", "detail");
        return "detail";
    }

    @RequestMapping("/cart")
    public String goToCart(Model modelo) {
        modelo.addAttribute("page", "cart");
        return "cart";
    }

    @RequestMapping("/checkout")
    public String goToCheckout(Model modelo) {
        modelo.addAttribute("page", "checkout");
        return "checkout";
    }

    @RequestMapping("/contact")
    public String goToContact(Model modelo) {
        modelo.addAttribute("page", "contact");
        return "contact";
    }

    @RequestMapping("/login")
    public String goToLogin(Model modelo) {
        modelo.addAttribute("page", "login");
        return "login";
    }
}
