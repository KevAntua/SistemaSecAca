package mx.ipn.upiicsa.udi.scasa.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoAreas;
import mx.ipn.upiicsa.udi.scasa.service.ICtlgAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class CtlgAreasCtrller {

    @Autowired
    private ICtlgAreasService ictlgAreasService;

    @GetMapping("/Areas")
    public String ctlgAreasModel(Model model) {
        var ctlgAreas = ictlgAreasService.listarCatalogoAreas();
        log.info("Ejecutando controlador para catalogo de areas");
        model.addAttribute("catalogoAreas", ctlgAreas);
        return "areas";
    }
    
    @GetMapping("/Areas/{nidarea}")
    public String areaModelSeleccionado(CatalogoAreas catalogoAreas, Model model) {
        catalogoAreas = ictlgAreasService.areaSeleccionada(catalogoAreas);
        log.info("Ejecutando controlador para la busqueda de una area seleccionada");
        model.addAttribute("catalogoAreas", catalogoAreas);
        return "areas";
    }
}