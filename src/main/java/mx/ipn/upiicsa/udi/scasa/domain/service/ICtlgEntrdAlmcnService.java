package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlEntrAlmacen;

import java.util.List;

public interface ICtlgEntrdAlmcnService {

    public List<CtrlEntrAlmacen> listarEntrdAlmcn();

    public void guardarEntrdAlmcn(CtrlEntrAlmacen ctrlEntrAlmacen);

    public void eliminarEntrdAlmcn(CtrlEntrAlmacen ctrlEntrAlmacen);

    public CtrlEntrAlmacen entrdAlmcnSeleccionado(CtrlEntrAlmacen ctrlEntrAlmacen);

}
