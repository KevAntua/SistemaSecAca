package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgAreasDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoAreas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgAreasImpl implements ICtlgAreasService{

    @Autowired
    private ICtlgAreasDao ctlgAreasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoAreas> listarCatalogoAreas(){
    return (List<CatalogoAreas>) ctlgAreasDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoAreas areaSeleccionada(CatalogoAreas ctlgAreas){
    return ctlgAreasDao.findById(ctlgAreas.getNidarea()).orElse(null);
    }
    
}
