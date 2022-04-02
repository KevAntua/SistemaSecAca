package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlDetllRqscn;

public interface ICtlgDtllRqscnService {

    public List<CtrlDetllRqscn> listarDtllRqscn ();
    
    public void gurdarDetllRqscn (CtrlDetllRqscn detllRqscn);
    
    public void eliminarDetllRqscn (CtrlDetllRqscn detllRqscn);
    
    public CtrlDetllRqscn detllRqscnSeleccionado (CtrlDetllRqscn detllRqscn);
    
}
