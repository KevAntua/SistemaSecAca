package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetalEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgDtllEntrdAlmcnService;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgDtllEntrdAlmcnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CtlgDtllEntrdAlmcnImp implements ICtlgDtllEntrdAlmcnService {

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
        return iCtlgDtllEntrdAlmcnDao.findById(ctrlDetalEntrAlmacen.getId()).orElse(null);
    }

}
