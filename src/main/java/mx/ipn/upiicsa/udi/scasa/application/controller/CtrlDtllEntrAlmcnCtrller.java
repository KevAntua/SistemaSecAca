package mx.ipn.upiicsa.udi.scasa.application.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetalEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgDtllEntrdAlmcnService;
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
public class CtrlDtllEntrAlmcnCtrller {

    @Autowired
    private ICtlgDtllEntrdAlmcnService iCtlgDtllEntrdAlmcnService;

    @GetMapping("/DetallesEntradas")
    public String dtllEntrAlmcnCtrllerModel(Model model) {
        var dtllEntrAlmcn = iCtlgDtllEntrdAlmcnService.listarDtlLEntrdAlmcn();
        log.info("Ejecutando controlador para el listado de detalles de las entradas del almacen");
        model.addAttribute("dtllEntrAlmcn", dtllEntrAlmcn);
        return "detalles_entrada";
    }

    @GetMapping("/DetallesEntradas/{niddent}")
    public String dtllEntrModelSeleccionado(@PathVariable("niddent") CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen, Model model) {
        ctrlDetalEntrAlmacen = iCtlgDtllEntrdAlmcnService.dtlLEntrdAlmcnSeleccionado(ctrlDetalEntrAlmacen);
        log.info("Ejecutando controlador para la busqueda de los detalles de una entrada seleccionada");
        model.addAttribute("dtllEntrAlmcn", ctrlDetalEntrAlmacen);
        return "detalles_entrada";
    }

    @GetMapping("/AgregarDtllsEntrd")
    public String agregarDtllEntr(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen) {
        log.info("Ejecutando controlador para comenzar a agregar detalles de una entrada");
        return "alta_detalles";
    }

    @PostMapping("/GuardarDtllsEntrd")
    public String guardarDtllEntr(@Valid CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen, Errors errores) {
        if (errores.hasErrors()) {
            return "alta_detalles";
        }
        iCtlgDtllEntrdAlmcnService.guardarDtlLEntrdAlmcn(ctrlDetalEntrAlmacen);
        return "redirect:/DetallesEntradas";
    }

    @GetMapping("/AgregarDtllsEntrd/{niddent}")
    public String actualizarDtllEntr(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen, Model model) {
        ctrlDetalEntrAlmacen = iCtlgDtllEntrdAlmcnService.dtlLEntrdAlmcnSeleccionado(ctrlDetalEntrAlmacen);
        model.addAttribute("catalogoArtAlmacen", ctrlDetalEntrAlmacen);
        log.info("Ejecutando controlador para la busqueda de un articulo seleccionado");
        return "alta_detalles";
    }

    @GetMapping("/EliminarDtllsEntrd")
    public String eliminarDtllEntr(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen, Model model) {
        iCtlgDtllEntrdAlmcnService.eliminarDtlLEntrdAlmcn(ctrlDetalEntrAlmacen);
        return "redirect:/DetallesEntradas";
    }
}
