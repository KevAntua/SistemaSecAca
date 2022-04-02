package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgRgstrRqscnMtrlUsrDao;
import mx.ipn.upiicsa.udi.scasa.entitys.RgstrRqscnMtrlUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CtlgRgstrRqscnMtrlUsrImpl implements ICtlgRgstrRqscnMtrlUsrService{

    @Autowired
    private ICtlgRgstrRqscnMtrlUsrDao iCtlgRgstrRqscnMtrlUsrDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<RgstrRqscnMtrlUsuario> listarRgstrRqscnMtrlUsuario() {
        return (List<RgstrRqscnMtrlUsuario>) iCtlgRgstrRqscnMtrlUsrDao.findAll();
    }

    @Override
    @Transactional
    public void guardarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario) {
        iCtlgRgstrRqscnMtrlUsrDao.save(rgstrRqscnUsuario);
    }

    @Override
    @Transactional
    public void eliminarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario) {
        iCtlgRgstrRqscnMtrlUsrDao.delete(rgstrRqscnUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public RgstrRqscnMtrlUsuario rgstrRqscnMtrlUsuarioSeleccionado(RgstrRqscnMtrlUsuario rgstrRqscnUsuario) {
        return iCtlgRgstrRqscnMtrlUsrDao.findById(rgstrRqscnUsuario.getNfolio()).orElse(null);
    }
    
}
