package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlEntrAlmacen;

public interface ICtlgEntrdAlmcnService {
    
    public List<CtrlEntrAlmacen> listarEntrdAlmcn();
    
    public void guardarEntrdAlmcn (CtrlEntrAlmacen entrAlmacen);
    
    public void eliminarEntrdAlmcn (CtrlEntrAlmacen entrAlmacen);
    
    public CtrlEntrAlmacen entrdAlmcnSeleccionado (CtrlEntrAlmacen entrAlmacen);
    
}
