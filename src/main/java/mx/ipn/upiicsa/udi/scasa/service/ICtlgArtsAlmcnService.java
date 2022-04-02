package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoArtAlmacen;

public interface ICtlgArtsAlmcnService {

    public List<CatalogoArtAlmacen> listarArtsAlmacen();

    public void guardarArtAlmacen(CatalogoArtAlmacen artalmacen);

    public void eliminarArtAlmacen(CatalogoArtAlmacen artalmacen);

    public CatalogoArtAlmacen artAlmcnSeleccionado(CatalogoArtAlmacen artalmacen);
}
