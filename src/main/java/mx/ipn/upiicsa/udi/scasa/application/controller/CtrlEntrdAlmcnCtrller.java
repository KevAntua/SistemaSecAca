package mx.ipn.upiicsa.udi.scasa.application.controller;

import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgEntrdAlmcnService;
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
public class CtrlEntrdAlmcnCtrller {

    @Autowired
    private ICtlgEntrdAlmcnService iCtlgEntrdAlmcnService;

    @GetMapping("/Entradas")
    public String ctrlEntradasAlmacen(Model model) {
        var entradas = iCtlgEntrdAlmcnService.listarEntrdAlmcn();
        log.info("Lista devuelta por las entradas: " + entradas);
        log.info("Ejecutando controlador para listar las entradas al almacen");
        model.addAttribute("entradasAlmacen", entradas);
        return "entradas_almacen";
    }

    @GetMapping("/Entradas/{nidenta}")
    public String entradaSeleccionada(@PathVariable("nidenta") CtrlEntrAlmacen ctrlEntrAlmacen, Model model) {
        ctrlEntrAlmacen = iCtlgEntrdAlmcnService.entrdAlmcnSeleccionado(ctrlEntrAlmacen);
        log.info("Ejecutando controlador para la busqueda de una entrada seleccionada");
        model.addAttribute("entradasAlmacen", ctrlEntrAlmacen);
        return "entradas_almacen";
    }

    @GetMapping("/AgregarEntradaAlmacen")
    public String agregarEntrada(CtrlEntrAlmacen ctrlEntrAlmacen) {
        log.info("Ejecutando controlador para comenzar a agregar una entrada al almacen");
        return "alta_entradaAlmacen";
    }

    @PostMapping("/GuardarEntrada")
    public String guardarEntrada(@Valid CtrlEntrAlmacen ctrlEntrAlmacen, Errors errores) {
        //LocalDate esDateFormat = LocalDate.parse(ctrlEntrAlmacen.getDfecent().toString(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //ctrlEntrAlmacen.setDfecent(esDateFormat);
        if (errores.hasErrors()) {
            return "alta_entradaAlmacen";
        }
        iCtlgEntrdAlmcnService.guardarEntrdAlmcn(ctrlEntrAlmacen);
        return "redirect:/Entradas";
    }

    @GetMapping("/AgregarEntradaAlmacen/{nidenta}")
    public String actualizarEntrada(CtrlEntrAlmacen ctrlEntrAlmacen, Model model) {
        ctrlEntrAlmacen = iCtlgEntrdAlmcnService.entrdAlmcnSeleccionado(ctrlEntrAlmacen);
        model.addAttribute("ctrlEntrAlmacen", ctrlEntrAlmacen);
        log.info("Ejecutando controlador para la busqueda de una entrada seleccionada para su actualizacion");
        return "alta_entradaAlmacen";
    }

    @GetMapping("/EliminarEntrada")
    public String eliminarEntrada(CtrlEntrAlmacen ctrlEntrAlmacen, Model model) {
        iCtlgEntrdAlmcnService.eliminarEntrdAlmcn(ctrlEntrAlmacen);
        return "redirect:/Entradas";
    }
}
