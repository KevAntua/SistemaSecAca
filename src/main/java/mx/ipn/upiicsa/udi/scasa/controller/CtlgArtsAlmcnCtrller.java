package mx.ipn.upiicsa.udi.scasa.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoArtAlmacen;

import mx.ipn.upiicsa.udi.scasa.service.ICtlgArtsAlmcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CtlgArtsAlmcnCtrller {

    @Autowired
    private ICtlgArtsAlmcnService ictlgArtsAlmcnService;
    
    @GetMapping("/Articulos")
    public String ctlgArtsAlmacenModel(Model model){
    
        var artsAlmacen = ictlgArtsAlmcnService.listarArtsAlmacen();
        log.info("Ejecutando controlador para el catalogo de los articulos del almacen");
        model.addAttribute("artsAlmacen", artsAlmacen);
        return "articulos_almacen";
    }
    
    @GetMapping("/Articulos/{ccvartl}")
    public String artModelSeleccionado(CatalogoArtAlmacen catalogoArtAlmacen, Model model) {
        catalogoArtAlmacen = ictlgArtsAlmcnService.artAlmcnSeleccionado(catalogoArtAlmacen);
        log.info("Ejecutando controlador para la prueba de solo la busqueda de un articulo seleccionado");
        model.addAttribute("artsAlmacen2", catalogoArtAlmacen);
        return "articulos_almacen";
    }
    
    @GetMapping("/AgregarArticulo")
    public String agregarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen){
        log.info("Ejecutando controlador para comenzar a agregar un nuevo articulo al almacen");
        return "alta_articulo";
    }
    
    @PostMapping("/guardar")
    public String guardarArtAlmacen(@Valid CatalogoArtAlmacen catalogoArtAlmacen, Errors errores){
        if(errores.hasErrors())
        {
        return "articulos_almacen";
        }
        ictlgArtsAlmcnService.guardarArtAlmacen(catalogoArtAlmacen);
        return "redirect:/Articulos";
    }
    
    @GetMapping("/AgregarArticulo/{ccvartl}")
    public String actualizarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen, Model model){
        catalogoArtAlmacen = ictlgArtsAlmcnService.artAlmcnSeleccionado(catalogoArtAlmacen);
        model.addAttribute("catalogoArtAlmacen",catalogoArtAlmacen);
        log.info("Ejecutando controlador para la busqueda de un articulo seleccionado");
        return "alta_articulo";
    }
    
    @GetMapping("/Eliminar")
    public String eliminarrArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen, Model model){
        ictlgArtsAlmcnService.eliminarArtAlmacen(catalogoArtAlmacen);
        return "redirect:/Articulos";
    }
}
