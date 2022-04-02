package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.dao.ICtlgArtsAlmacenDao;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoArtAlmacen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CtlgArtsAlmcnImpl implements ICtlgArtsAlmcnService {

    @Autowired
    private ICtlgArtsAlmacenDao ctlgArtsAlmcnDao;

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoArtAlmacen> listarArtsAlmacen() {
        return (List<CatalogoArtAlmacen>) ctlgArtsAlmcnDao.findAll();
    }

    @Override
    @Transactional
    public void guardarArtAlmacen(CatalogoArtAlmacen artalmacen) {
        ctlgArtsAlmcnDao.save(artalmacen);
    }

    @Override
    @Transactional
    public void eliminarArtAlmacen(CatalogoArtAlmacen artalmacen) {
        ctlgArtsAlmcnDao.delete(artalmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoArtAlmacen artAlmcnSeleccionado(CatalogoArtAlmacen artalmacen) {
        return ctlgArtsAlmcnDao.findById(artalmacen.getCcvartl()).orElse(null);
    }

}
