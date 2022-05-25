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

    //@Autowired
    //private CatalogoAreas ctlgAreas;

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

    @Override
    @Transactional(readOnly = true)
    public CatalogoAreas areaSeleccionada(Integer ctlgAreas) {
    return ctlgAreasDao.findById(ctlgAreas).orElse(null);
    }
    
    /*@Override
    @Transactional(readOnly = true)
    public List<Object> listartodo() {

        List<Object> area = new ArrayList<>();
        
        for(Object datos : ctlgAreasDao.findAll())
        {
        area.add(datos);
        }
        
        return area;
        
    }

    @Override
    @Transactional(readOnly = true)
    public Object datosSeleccionado(Object objet) {
        return ctlgAreasDao.findById(ctlgAreas.getNidarea()).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Object datosSeleccionadoInt(Integer idEntero) {
        return ctlgAreasDao.findById(idEntero).orElse(null);
    }*/

}
