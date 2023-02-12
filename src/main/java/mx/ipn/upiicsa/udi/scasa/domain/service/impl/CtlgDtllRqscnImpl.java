package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetllRqscn;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgDtllRqscnService;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgDtllRqscnDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CtlgDtllRqscnImpl implements ICtlgDtllRqscnService {

    @Autowired
    private ICtlgDtllRqscnDao iCtlgDtllRqscnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CtrlDetllRqscn> listarDtllRqscn() {
        return (List<CtrlDetllRqscn>) iCtlgDtllRqscnDao.findAll();
    }

    @Override
    @Transactional
    public void gurdarDetllRqscn(CtrlDetllRqscn detllRqscn) {
        iCtlgDtllRqscnDao.save(detllRqscn);
    }

    @Override
    @Transactional
    public void eliminarDetllRqscn(CtrlDetllRqscn detllRqscn) {
        iCtlgDtllRqscnDao.delete(detllRqscn);
    }

    @Override
    @Transactional(readOnly = true)
    public CtrlDetllRqscn detllRqscnSeleccionado(CtrlDetllRqscn detllRqscn) {
        return iCtlgDtllRqscnDao.findById(detllRqscn.getId()).orElse(null);
    }
}
