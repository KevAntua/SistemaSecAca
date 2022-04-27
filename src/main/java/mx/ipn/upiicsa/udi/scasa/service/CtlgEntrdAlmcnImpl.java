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
    private ICtlgEntrdAlmcnDao iCtlgEntrdAlmcnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CtrlEntrAlmacen> listarEntrdAlmcn() {
        return (List<CtrlEntrAlmacen>) iCtlgEntrdAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarEntrdAlmcn(CtrlEntrAlmacen ctrlEntrAlmacen) {
        iCtlgEntrdAlmcnDao.save(ctrlEntrAlmacen);
    }

    @Override
    @Transactional
    public void eliminarEntrdAlmcn(CtrlEntrAlmacen ctrlEntrAlmacen) {
        iCtlgEntrdAlmcnDao.delete(ctrlEntrAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlEntrAlmacen entrdAlmcnSeleccionado(CtrlEntrAlmacen ctrlEntrAlmacen) {
        return iCtlgEntrdAlmcnDao.findById(ctrlEntrAlmacen.getNidenta()).orElse(null);
    }
    
}
