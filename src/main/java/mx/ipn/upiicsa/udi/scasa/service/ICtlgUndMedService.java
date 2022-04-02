package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoUniMedida;

public interface ICtlgUndMedService {

    public List <CatalogoUniMedida> listarUndMedida();
    
    public void guardarUniMedida(CatalogoUniMedida uniMedida);
    
    public void eliminarUniMedida(CatalogoUniMedida uniMedida);
    
    public CatalogoUniMedida uniMedidaSeleccionado (CatalogoUniMedida uniMedida);
}
