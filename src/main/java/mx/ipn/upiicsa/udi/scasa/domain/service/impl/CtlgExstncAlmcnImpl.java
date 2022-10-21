package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlExisAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgExstncAlmcnService;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgExstncAlmcnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CtlgExstncAlmcnImpl implements ICtlgExstncAlmcnService {

    @Autowired
    private ICtlgExstncAlmcnDao iCtlgExstncAlmcnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CtrlExisAlmacen> listarExstncAlmcn() {
        return (List<CtrlExisAlmacen>) iCtlgExstncAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarExstncAlmcn(CtrlExisAlmacen ctrlExisAlmacen) {
        iCtlgExstncAlmcnDao.save(ctrlExisAlmacen);
    }

    @Override
    @Transactional
    public void eliminarExstncAlmcn(CtrlExisAlmacen ctrlExisAlmacen) {
        iCtlgExstncAlmcnDao.delete(ctrlExisAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlExisAlmacen exstncAlmcnSeleccionado(CtrlExisAlmacen ctrlExisAlmacen) {
        return iCtlgExstncAlmcnDao.findById(ctrlExisAlmacen.getId()).orElse(null);
    }

}
