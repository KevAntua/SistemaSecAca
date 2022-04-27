package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlDetalEntrAlmacen;

public interface ICtlgDtllEntrdAlmcnService {
    
    public List<CtrlDetalEntrAlmacen> listarDtlLEntrdAlmcn(); 
    
    public void guardarDtlLEntrdAlmcn (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);

    public void eliminarDtlLEntrdAlmcn (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);

    public CtrlDetalEntrAlmacen dtlLEntrdAlmcnSeleccionado (CtrlDetalEntrAlmacen ctrlDetalEntrAlmacen);
    
}
