package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoAreas;

import java.util.List;

public interface ICtlgAreasService {
    
    public List<CatalogoAreas> listarCatalogoAreas();
    
    public CatalogoAreas areaSeleccionada(CatalogoAreas catalogoAreas);
    
    public CatalogoAreas areaSeleccionada(Integer ctlgAreas);
    
}
