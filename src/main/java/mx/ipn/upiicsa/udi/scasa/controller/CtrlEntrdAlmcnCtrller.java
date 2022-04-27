package mx.ipn.upiicsa.udi.scasa.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.service.ICtlgEntrdAlmcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CtrlEntrdAlmcnCtrller {

    @Autowired
    private ICtlgEntrdAlmcnService iCtlgEntrdAlmcnService;

    @GetMapping("/Entradas")
    public String ctrlEntradasAlmacen(Model model) {
        var entradas = iCtlgEntrdAlmcnService.listarEntrdAlmcn();
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
        log.info("Ejecutando controlador para comenzar a agregar un nuevo articulo al almacen");
        return "alta_entradaAlmacen";
    }
    
    @PostMapping("/GuardarEntrada")
    public String guardarEntrada(@Valid CtrlEntrAlmacen ctrlEntrAlmacen, Errors errores){
        if(errores.hasErrors())
        {
        return "alta_entradaAlmacen";
        }
        iCtlgEntrdAlmcnService.guardarEntrdAlmcn(ctrlEntrAlmacen);
        return "redirect:/Entradas";
    }
    
    @GetMapping("/AgregarEntradaAlmacen/{nidenta}")
    public String actualizarEntrada(CtrlEntrAlmacen ctrlEntrAlmacen, Model model){
        ctrlEntrAlmacen = iCtlgEntrdAlmcnService.entrdAlmcnSeleccionado(ctrlEntrAlmacen);
        model.addAttribute("entradaAlmacen",ctrlEntrAlmacen);
        log.info("Ejecutando controlador para la busqueda de una entrada seleccionada para su actualizacion");
        return "alta_entradaAlmacen";
    }
    
    @GetMapping("/EliminarEntrada")
    public String eliminarEntrada(CtrlEntrAlmacen ctrlEntrAlmacen, Model model){
        iCtlgEntrdAlmcnService.eliminarEntrdAlmcn(ctrlEntrAlmacen);
        return "redirect:/Entradas";
    }
}
