package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgExstncAlmcnDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlExisAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CtlgExstncAlmcnImpl implements ICtlgExstncAlmcnService{
    
    @Autowired
    private ICtlgExstncAlmcnDao iCtlgExstncAlmcnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CtrlExisAlmacen> listarExstncAlmcn() {
        return (List<CtrlExisAlmacen>) iCtlgExstncAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarExstncAlmcn(CtrlExisAlmacen exisAlmacen) {
        iCtlgExstncAlmcnDao.save(exisAlmacen);
    }

    @Override
    @Transactional
    public void eliminarExstncAlmcn(CtrlExisAlmacen exisAlmacen) {
        iCtlgExstncAlmcnDao.delete(exisAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlExisAlmacen exstncAlmcnSeleccionado(CtrlExisAlmacen exisAlmacen) {
        return iCtlgExstncAlmcnDao.findById(exisAlmacen.getCcvartl()).orElse(null);
    }
    
}
