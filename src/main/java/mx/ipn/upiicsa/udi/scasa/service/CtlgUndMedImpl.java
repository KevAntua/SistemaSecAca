package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgUndMedidaDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoUniMedida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgUndMedImpl implements ICtlgUndMedService {

    @Autowired
    private ICtlgUndMedidaDao iCtlgUndMedidaDao; 
    
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoUniMedida> listarUndMedida() {
      return (List<CatalogoUniMedida>) iCtlgUndMedidaDao.findAll();
    }

    @Override
    @Transactional
    public void guardarUniMedida(CatalogoUniMedida catalogoUniMedida) {
        iCtlgUndMedidaDao.save(catalogoUniMedida);
    }

    @Override
    @Transactional
    public void eliminarUniMedida(CatalogoUniMedida catalogoUniMedida) {
        iCtlgUndMedidaDao.delete(catalogoUniMedida);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoUniMedida uniMedidaSeleccionado(CatalogoUniMedida catalogoUniMedida) {
    return iCtlgUndMedidaDao.findById(catalogoUniMedida.getNcvunmd()).orElse(null);
    }
    
}
