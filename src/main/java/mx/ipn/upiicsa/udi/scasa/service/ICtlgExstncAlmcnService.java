package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlExisAlmacen;

public interface ICtlgExstncAlmcnService {

    public List<CtrlExisAlmacen> listarExstncAlmcn();
    
    public void guardarExstncAlmcn (CtrlExisAlmacen ctrlExisAlmacen);
    
    public void eliminarExstncAlmcn (CtrlExisAlmacen ctrlExisAlmacen);
    
    public CtrlExisAlmacen exstncAlmcnSeleccionado (CtrlExisAlmacen ctrlExisAlmacen);
}
