package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetalEntrAlmacen;

import java.util.List;

public interface ICtlgDtllEntrdAlmcnService {
    
    public List<CtrlDetalEntrAlmacen> listarDtlLEntrdAlmcn();
    
    public void guardarDtlLEntrdAlmcn (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);

    public void eliminarDtlLEntrdAlmcn (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);

    public CtrlDetalEntrAlmacen dtlLEntrdAlmcnSeleccionado (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);
    
}
