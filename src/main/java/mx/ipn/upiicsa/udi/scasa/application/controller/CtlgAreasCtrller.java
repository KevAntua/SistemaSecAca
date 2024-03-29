package mx.ipn.upiicsa.udi.scasa.application.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoAreas;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgAreasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@Slf4j
public class CtlgAreasCtrller {

    @Autowired
    //private IBusquedaService iBusquedaS; 
    private ICtlgAreasService ictlgAreasService;

    @GetMapping("/Areas")
    public String ctlgAreasModel(Model model) {
        var catalogoAreas = ictlgAreasService.listarCatalogoAreas();
        
        /*List<Object> catalogoAreas = Arrays.asList(iBusquedaS.listartodo(),CatalogoAreas[].class);
        var lista = catalogoAreas.stream().map(p -> new CatalogoAreas(p)).collect(Collectors.toList());*/
        
        log.info("Ejecutando controlador para catalogo de areas");
        model.addAttribute("catalogoAreas", catalogoAreas);
        return "areas";
    }

    @GetMapping(value = "/Areas/{nidarea}")//@DeleteMapping(value="{codigoRegistro}"), @PathVariable("codigoRegistro")
    public String areaModelSeleccionado(@PathVariable("nidarea") CatalogoAreas catalogoAreas, Model model) {
        catalogoAreas = ictlgAreasService.areaSeleccionada(catalogoAreas);
        model.addAttribute("catalogoAreas", catalogoAreas);
        log.info("Ejecutando controlador para la busqueda de una area seleccionada");
        return "areas";
    }

    /*@GetMapping(value = "/Areas/{nidarea}")//@DeleteMapping(value="{codigoRegistro}"), @PathVariable("codigoRegistro")
    public String areaSeleccionadaM2(@PathVariable("nidarea") Integer niderea, Model model) {
        List<CatalogoAreas> AreasSeleccionada = ictlgAreasService.listarCatalogoAreas();

        for (CatalogoAreas area : AreasSeleccionada) {
            int id = area.getNidarea();
            if (id == niderea) {
                model.addAttribute("catalogoAreas", area);
                log.info("Ejecutando controlador para la busqueda de una area seleccionada por el metodo 2");
                return "areas";
            }
        }
        return "areas";
    }*/

    /*@GetMapping(value="/Areas/{nidarea}")//@DeleteMapping(value="{codigoRegistro}"), @PathVariable("codigoRegistro")
    public String areaModelSeleccionado(@PathVariable("nidarea") Integer ctlgAreas, Model model) {
        var catalogoAreas = ictlgAreasService.areaSeleccionada(ctlgAreas);
        log.info("Ejecutando controlador para la busqueda de una area seleccionada");
        model.addAttribute("areaseleccionada", catalogoAreas);
        return "areas";
    }*/
}
