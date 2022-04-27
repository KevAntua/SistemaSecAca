package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlEntrAlmacen;

public interface ICtlgEntrdAlmcnService {
    
    public List<CtrlEntrAlmacen> listarEntrdAlmcn();
    
    public void guardarEntrdAlmcn (CtrlEntrAlmacen ctrlEntrAlmacen);
    
    public void eliminarEntrdAlmcn (CtrlEntrAlmacen ctrlEntrAlmacen);
    
    public CtrlEntrAlmacen entrdAlmcnSeleccionado (CtrlEntrAlmacen ctrlEntrAlmacen);
    
}
