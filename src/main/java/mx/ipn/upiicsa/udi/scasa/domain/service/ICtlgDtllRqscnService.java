package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetllRqscn;

import java.util.List;

public interface ICtlgDtllRqscnService {

    public List<CtrlDetllRqscn> listarDtllRqscn ();
    
    public void gurdarDetllRqscn (CtrlDetllRqscn detllRqscn);
    
    public void eliminarDetllRqscn (CtrlDetllRqscn detllRqscn);
    
    public CtrlDetllRqscn detllRqscnSeleccionado (CtrlDetllRqscn detllRqscn);
    
}
