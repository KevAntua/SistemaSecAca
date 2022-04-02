package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlExisAlmacen;

public interface ICtlgExstncAlmcnService {

    public List<CtrlExisAlmacen> listarExstncAlmcn();
    
    public void guardarExstncAlmcn (CtrlExisAlmacen exisAlmacen);
    
    public void eliminarExstncAlmcn (CtrlExisAlmacen exisAlmacen);
    
    public CtrlExisAlmacen exstncAlmcnSeleccionado (CtrlExisAlmacen exisAlmacen);
}
