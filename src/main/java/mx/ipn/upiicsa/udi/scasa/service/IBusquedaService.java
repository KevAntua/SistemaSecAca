package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoAreas;

public interface IBusquedaService {

    public List<Object> listartodo ();
    
    public Object datosSeleccionado (Object objet);
    
    public Object datosSeleccionadoInt (Integer idEntero);
}
