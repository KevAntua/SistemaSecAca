package mx.ipn.upiicsa.udi.scasa.domain.service.impl;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoArtAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.service.ICtlgArtsAlmcnService;
import mx.ipn.upiicsa.udi.scasa.infrastructure.repository.ICtlgArtsAlmacenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CtlgArtsAlmcnImpl implements ICtlgArtsAlmcnService {

    @Autowired
    private ICtlgArtsAlmacenDao iCtlgArtsAlmacenDao;

    @Override
    @Transactional(readOnly = true)
    public List<CatalogoArtAlmacen> listarArtsAlmacen() {
        return iCtlgArtsAlmacenDao.findAll();
    }

    @Override
    @Transactional
    public void guardarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen) {
        iCtlgArtsAlmacenDao.save(catalogoArtAlmacen);
    }

    @Override
    @Transactional
    public void eliminarArtAlmacen(String ccvartl) {
        iCtlgArtsAlmacenDao.deleteByIdCcvartl(ccvartl);
    }

    @Override
    @Transactional(readOnly = true)
    public CatalogoArtAlmacen artAlmcnSeleccionado(String ccvartl) {
        return iCtlgArtsAlmacenDao.findByIdCcvartl(ccvartl).orElse(null);
    }

}
