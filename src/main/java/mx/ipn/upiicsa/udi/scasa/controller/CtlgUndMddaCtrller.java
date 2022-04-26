package mx.ipn.upiicsa.udi.scasa.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoUniMedida;
import mx.ipn.upiicsa.udi.scasa.service.ICtlgUndMedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CtlgUndMddaCtrller {
    
    @Autowired
    private ICtlgUndMedService ctlgUndMedService;
    
    @GetMapping("/Medidas")
    public String ctlgUndMedidaModel(Model model){
        var unidadesMedida = ctlgUndMedService.listarUndMedida();
        log.info("Ejecutando controlador para el catalogo de las unidades de medida");
        model.addAttribute("unidadesMedida", unidadesMedida);
        return "unidades_medida";
    }
    
    @GetMapping("/AgregarMedida")
    public String agregarUniMedida(CatalogoUniMedida unimedida){
        log.info("Ejecutando controlador para comenzar a agregar una nueva unidad de medida");
        return "alta_medida";
    }
    
    @PostMapping("/guardarMedida")
    public String guardarUniMedida(@Valid CatalogoUniMedida unimedida, Errors errores){
        if(errores.hasErrors())
        {
        return "unidades_medida";
        }
        ctlgUndMedService.guardarUniMedida(unimedida);
        return "redirect:/Medidas";
    }
    
    @GetMapping("/AgregarMedida/{ncvunmd}")
    public String actualizarArtAlmacen(CatalogoUniMedida unimedida, Model model){
        unimedida = ctlgUndMedService.uniMedidaSeleccionado(unimedida);
        model.addAttribute("unimedida",unimedida);
        log.info("Ejecutando controlador para la busqueda de una unidad de medida seleccionada");
        return "alta_medida";
    }
    
    @GetMapping("/EliminarMedida")
    public String eliminarrArtAlmacen(CatalogoUniMedida unimedida, Model model){
        ctlgUndMedService.eliminarUniMedida(unimedida);
        return "redirect:/Medidas";
    }
    
}
