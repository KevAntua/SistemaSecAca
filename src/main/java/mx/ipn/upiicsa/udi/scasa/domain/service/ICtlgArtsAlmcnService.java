package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoArtAlmacen;

import java.util.List;

public interface ICtlgArtsAlmcnService {

    List<CatalogoArtAlmacen> listarArtsAlmacen();

    void guardarArtAlmacen(CatalogoArtAlmacen catalogoArtAlmacen);

    void eliminarArtAlmacen(String ccvartl);

    CatalogoArtAlmacen artAlmcnSeleccionado(String ccvartl);
}
