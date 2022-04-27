package mx.ipn.upiicsa.udi.scasa.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlExisAlmacen;
import mx.ipn.upiicsa.udi.scasa.service.ICtlgExstncAlmcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CtrlExisAlmacenCtrller {
    
    @Autowired
    private ICtlgExstncAlmcnService iCtlgExstncAlmcnService;

    @GetMapping("/ExistenciasAlmacen")
    public String existenciasAlmacenModel(Model model) {
        var existenciaAlmacen = iCtlgExstncAlmcnService.listarExstncAlmcn();
        log.info("Ejecutando controlador para las existencias de los articulos del almacen");
        model.addAttribute("existenciaAlmacen", existenciaAlmacen);
        return "existencias_almacen";
    }

    @GetMapping("/ExistenciasAlmacen/{ccvartl}")
    public String existenciaModelSeleccionado(@PathVariable("ccvartl") CtrlExisAlmacen ctrlExisAlmacen, Model model) {
        ctrlExisAlmacen = iCtlgExstncAlmcnService.exstncAlmcnSeleccionado(ctrlExisAlmacen);
        log.info("Ejecutando controlador para la busqueda de las existencias de un articulo seleccionado");
        model.addAttribute("existenciaAlmacen", ctrlExisAlmacen);
        return "existencias_almacen";
    }

    @GetMapping("/AgregarExistencia")
    public String agregarExistenciaAlmacen(CtrlExisAlmacen ctrlExisAlmacen) {
        log.info("Ejecutando controlador para comenzar a agregar una nueva existencia");
        return "alta_existencias";
    }

    @PostMapping("/GuardarExistencia")
    public String guardarExistenciaAlmacen(@Valid CtrlExisAlmacen ctrlExisAlmacen, Errors errores) {
        if (errores.hasErrors()) {
            return "alta_existencias";
        }
        iCtlgExstncAlmcnService.guardarExstncAlmcn(ctrlExisAlmacen);
        return "redirect:/Articulos";
    }

    @GetMapping("/AgregarExistencia/{ccvartl}")
    public String actualizarExistenciaAlmacen(CtrlExisAlmacen ctrlExisAlmacen, Model model) {
        ctrlExisAlmacen = iCtlgExstncAlmcnService.exstncAlmcnSeleccionado(ctrlExisAlmacen);
        model.addAttribute("ctrlExisAlmacen", ctrlExisAlmacen);
        log.info("Ejecutando controlador para la busqueda de una existencia seleccionada");
        return "alta_existencias";
    }

    @GetMapping("/EliminarExistencia")
    public String eliminarArtAlmacen(CtrlExisAlmacen ctrlExisAlmacen, Model model) {
        iCtlgExstncAlmcnService.eliminarExstncAlmcn(ctrlExisAlmacen);
        return "redirect:/Articulos";
    }
}
