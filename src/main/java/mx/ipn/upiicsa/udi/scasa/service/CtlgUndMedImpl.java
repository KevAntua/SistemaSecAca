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
    private ICtlgUndMedidaDao unidadMedida; 
    
    @Override
    @Transactional(readOnly = true)
    public List<CatalogoUniMedida> listarUndMedida() {
      return (List<CatalogoUniMedida>) unidadMedida.findAll();
    }

    @Override
    @Transactional
    public void guardarUniMedida(CatalogoUniMedida uniMedida) {
        unidadMedida.save(uniMedida);
    }

    @Override
    @Transactional
    public void eliminarUniMedida(CatalogoUniMedida uniMedida) {
        unidadMedida.delete(uniMedida);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoUniMedida uniMedidaSeleccionado(CatalogoUniMedida uniMedida) {
    return unidadMedida.findById(uniMedida.getNcvunmd()).orElse(null);
    }
    
}
