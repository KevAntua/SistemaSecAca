package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgDtllRqscnDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlDetllRqscn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgDtllRqscnImpl implements ICtlgDtllRqscnService{
    
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
       return iCtlgDtllRqscnDao.findById(detllRqscn.getNnumdet()).orElse(null);
    }
    
}
