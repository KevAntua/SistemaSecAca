package mx.ipn.upiicsa.udi.scasa.application.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoArtAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgArtsAlmcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class CtlgArtsAlmcnCtrller {

    @Autowired
    private ICtlgArtsAlmcnService iCtlgArtsAlmcnService;

    @GetMapping("/Articulos")
    public String ctlgArtsAlmacenModel(Model model) {
        var artsAlmacen = iCtlgArtsAlmcnService.listarArtsAlmacen();
        log.info("Ejecutando controlador para el catalogo de los articulos del almacen");
        model.addAttribute("artsAlmacen", artsAlmacen);
        return "articulos_almacen";
    }

    @GetMapping("/Articulos/{ccvartl}")
    public String artModelSeleccionado(@PathVariable("ccvartl") String ccvartl, Model model) {
        CatalogoArtAlmacen catalogoArtAlmacen = iCtlgArtsAlmcnService.artAlmcnSeleccionado(ccvartl);
        log.info("Ejecutando controlador para  la busqueda de un articulo seleccionado");
        model.addAttribute("artsAlmacen", catalogoArtAlmacen);
        return "articulos_almacen";
    }

    @GetMapping("/AgregarArticulo")
    public String agregarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen) {
        log.info("Ejecutando controlador para comenzar a agregar un nuevo articulo al almacen");
        return "alta_articulo";
    }

    @PostMapping("/GuardarArticulo")
    public String guardarArtAlmacen(@Valid CatalogoArtAlmacen catalogoArtAlmacen, Errors errores) {
        if (errores.hasErrors()) {
            return "alta_articulo";
        }
        iCtlgArtsAlmcnService.guardarArtAlmacen(catalogoArtAlmacen);
        return "redirect:/Articulos";
    }

    @GetMapping("/AgregarArticulo/{ccvartl}")
    public String actualizarArtAlmacen(@PathVariable String ccvartl, Model model) {
        CatalogoArtAlmacen catalogoArtAlmacen = iCtlgArtsAlmcnService.artAlmcnSeleccionado(ccvartl);
        model.addAttribute("catalogoArtAlmacen", catalogoArtAlmacen);
        log.info("Ejecutando controlador para la busqueda de un articulo seleccionado");
        return "alta_articulo";
    }

    @GetMapping("/EliminarArticulo/{ccvartl}")
    public String eliminarArtAlmacen(@PathVariable String ccvartl, Model model) {
        iCtlgArtsAlmcnService.eliminarArtAlmacen(ccvartl);
        return "redirect:/Articulos";
    }
}
