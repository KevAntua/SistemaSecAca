package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoUniMedida;

public interface ICtlgUndMedService {

    public List <CatalogoUniMedida> listarUndMedida();
    
    public void guardarUniMedida(CatalogoUniMedida catalogoUniMedida);
    
    public void eliminarUniMedida(CatalogoUniMedida catalogoUniMedida);
    
    public CatalogoUniMedida uniMedidaSeleccionado (CatalogoUniMedida catalogoUniMedida);
}
