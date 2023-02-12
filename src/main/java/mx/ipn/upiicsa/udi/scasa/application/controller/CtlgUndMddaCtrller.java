package mx.ipn.upiicsa.udi.scasa.application.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoUniMedida;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgUndMedService;
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
public class CtlgUndMddaCtrller {

    @Autowired
    private ICtlgUndMedService iCtlgUndMedService;

    @GetMapping("/UnidadesMedida")
    public String ctlgUndMedidaModel(Model model) {
        var unidadesMedida = iCtlgUndMedService.listarUndMedida();
        log.info("Ejecutando controlador para el catalogo de las unidades de medida");
        model.addAttribute("unidadesMedida", unidadesMedida);
        return "unidades_medida";
    }

    @GetMapping("/UnidadesMedida/{ncvunmd}")
    public String medidaSeleccionada(@PathVariable("ncvunmd") CatalogoUniMedida catalogoUniMedida, Model model) {
        catalogoUniMedida = iCtlgUndMedService.uniMedidaSeleccionado(catalogoUniMedida);
        log.info("Ejecutando controlador para la busqueda de una medida seleccionada");
        model.addAttribute("unidadesMedida", catalogoUniMedida);
        return "unidades_medida";
    }

    @GetMapping("/AgregarMedida")
    public String agregarUniMedida(CatalogoUniMedida catalogoUniMedida) {
        log.info("Ejecutando controlador para comenzar a agregar una nueva unidad de medida");
        return "alta_medida";
    }

    @PostMapping("/GuardarMedida")
    public String guardarUniMedida(@Valid CatalogoUniMedida catalogoUniMedida, Errors errores) {
        if (errores.hasErrors()) {
            return "alta_medida";
        }
        iCtlgUndMedService.guardarUniMedida(catalogoUniMedida);
        return "redirect:/UnidadesMedida";
    }

    @GetMapping("/AgregarMedida/{ncvunmd}")
    public String actualizarUniMedida(CatalogoUniMedida catalogoUniMedida, Model model) {
        catalogoUniMedida = iCtlgUndMedService.uniMedidaSeleccionado(catalogoUniMedida);
        model.addAttribute("catalogoUniMedida", catalogoUniMedida);
        log.info("Ejecutando controlador para la busqueda de una unidad de medida seleccionada para actualizar");
        return "alta_medida";
    }

    @GetMapping("/EliminarMedida")
    public String eliminarUniMedida(CatalogoUniMedida catalogoUniMedida, Model model) {
        iCtlgUndMedService.eliminarUniMedida(catalogoUniMedida);
        return "redirect:/UnidadesMedida";
    }
}
