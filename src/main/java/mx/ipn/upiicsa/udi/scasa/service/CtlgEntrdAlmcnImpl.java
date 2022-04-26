package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgEntrdAlmcnDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlEntrAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgEntrdAlmcnImpl implements ICtlgEntrdAlmcnService{
    
    @Autowired
    private ICtlgEntrdAlmcnDao ctlgEntrdAlmcnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CtrlEntrAlmacen> listarEntrdAlmcn() {
        return (List<CtrlEntrAlmacen>) ctlgEntrdAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarEntrdAlmcn(CtrlEntrAlmacen entrAlmacen) {
        ctlgEntrdAlmcnDao.save(entrAlmacen);
    }

    @Override
    @Transactional
    public void eliminarEntrdAlmcn(CtrlEntrAlmacen entrAlmacen) {
        ctlgEntrdAlmcnDao.delete(entrAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlEntrAlmacen entrdAlmcnSeleccionado(CtrlEntrAlmacen entrAlmacen) {
        return ctlgEntrdAlmcnDao.findById(entrAlmacen.getNidenta()).orElse(null);
    }
    
}
