package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgDtllEntrdAlmcnDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlDetalEntrAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgDtllEntrdAlmcnImp implements ICtlgDtllEntrdAlmcnService{
    
    @Autowired
    private ICtlgDtllEntrdAlmcnDao iCtlgDtllEntrdAlmcnDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<CtrlDetalEntrAlmacen> listarDtlLEntrdAlmcn() {
        return (List<CtrlDetalEntrAlmacen>) iCtlgDtllEntrdAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarDtlLEntrdAlmcn(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen) {
        iCtlgDtllEntrdAlmcnDao.save(ctrlDetalEntrAlmacen);
    }

    @Override
    @Transactional
    public void eliminarDtlLEntrdAlmcn(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen) {
        iCtlgDtllEntrdAlmcnDao.delete(ctrlDetalEntrAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlDetalEntrAlmacen dtlLEntrdAlmcnSeleccionado(CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen) {
        return iCtlgDtllEntrdAlmcnDao.findById(ctrlDetalEntrAlmacen.getNiddent()).orElse(null);
    }
    
}
