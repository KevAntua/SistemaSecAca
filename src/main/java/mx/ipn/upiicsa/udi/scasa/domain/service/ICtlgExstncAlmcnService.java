package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlExisAlmacen;

import java.util.List;

public interface ICtlgExstncAlmcnService {

    public List<CtrlExisAlmacen> listarExstncAlmcn();

    public void guardarExstncAlmcn(CtrlExisAlmacen ctrlExisAlmacen);

    public void eliminarExstncAlmcn(CtrlExisAlmacen ctrlExisAlmacen);

    public CtrlExisAlmacen exstncAlmcnSeleccionado(CtrlExisAlmacen ctrlExisAlmacen);
}
