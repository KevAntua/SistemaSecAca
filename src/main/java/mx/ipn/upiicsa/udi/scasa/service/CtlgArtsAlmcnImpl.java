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
    private ICtlgArtsAlmacenDao iCtlgArtsAlmacenDao;

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoArtAlmacen> listarArtsAlmacen() {
        return (List<CatalogoArtAlmacen>) iCtlgArtsAlmacenDao.findAll();
    }

    @Override
    @Transactional
    public void guardarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen) {
        iCtlgArtsAlmacenDao.save(catalogoArtAlmacen);
    }

    @Override
    @Transactional
    public void eliminarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen) {
        iCtlgArtsAlmacenDao.delete(catalogoArtAlmacen);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoArtAlmacen artAlmcnSeleccionado(CatalogoArtAlmacen catalogoArtAlmacen) {
        return iCtlgArtsAlmacenDao.findById(catalogoArtAlmacen.getCcvartl()).orElse(null);
    }

}
