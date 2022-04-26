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
    public void guardarDtlLEntrdAlmcn(CtrlDetalEntrAlmacen dtlLEntrdAlmcn) {
        iCtlgDtllEntrdAlmcnDao.save(dtlLEntrdAlmcn);
    }

    @Override
    @Transactional
    public void eliminarDtlLEntrdAlmcn(CtrlDetalEntrAlmacen dtlLEntrdAlmcn) {
        iCtlgDtllEntrdAlmcnDao.delete(dtlLEntrdAlmcn);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlDetalEntrAlmacen dtlLEntrdAlmcnSeleccionado(CtrlDetalEntrAlmacen dtlLEntrdAlmcn) {
        return iCtlgDtllEntrdAlmcnDao.findById(dtlLEntrdAlmcn.getNiddent()).orElse(null);
    }
    
}
