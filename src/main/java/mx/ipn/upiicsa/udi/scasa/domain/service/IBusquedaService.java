package mx.ipn.upiicsa.udi.scasa.domain.service;

import java.util.List;

public interface IBusquedaService {

    public List<Object> listartodo ();
    
    public Object datosSeleccionado (Object objet);
    
    public Object datosSeleccionadoInt (Integer idEntero);
}
