package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import mx.ipn.upiicsa.udi.scasa.domain.model.RgstrRqscnMtrlUsuario;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgRgstrRqscnMtrlUsrService;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgRgstrRqscnMtrlUsrDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CtlgRgstrRqscnMtrlUsrImpl implements ICtlgRgstrRqscnMtrlUsrService {

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
        return iCtlgRgstrRqscnMtrlUsrDao.findById(rgstrRqscnUsuario.getId()).orElse(null);
    }

}
