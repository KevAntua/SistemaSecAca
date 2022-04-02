package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoAreas;

public interface ICtlgAreasService {
    
    public List<CatalogoAreas> listarCatalogoAreas();
    
    public CatalogoAreas areaSeleccionada(CatalogoAreas ctlgAreas);
    
}
