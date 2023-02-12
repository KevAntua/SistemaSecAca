package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoUniMedida;

import java.util.List;

public interface ICtlgUndMedService {

    public List <CatalogoUniMedida> listarUndMedida();
    
    public void guardarUniMedida(CatalogoUniMedida catalogoUniMedida);
    
    public void eliminarUniMedida(CatalogoUniMedida catalogoUniMedida);
    
    public CatalogoUniMedida uniMedidaSeleccionado (CatalogoUniMedida catalogoUniMedida);
}
