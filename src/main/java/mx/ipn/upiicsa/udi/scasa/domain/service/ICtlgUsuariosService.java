package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlUsuarios;

import java.util.List;

public interface ICtlgUsuariosService {
    
    public List <CtrlUsuarios> listarusuarios();
    
    public void guardarusuario(CtrlUsuarios usuario);
    
    public void eliminarusuario(CtrlUsuarios usuario);
    
    public CtrlUsuarios usuarioSeleccionado (CtrlUsuarios usuario);
}
