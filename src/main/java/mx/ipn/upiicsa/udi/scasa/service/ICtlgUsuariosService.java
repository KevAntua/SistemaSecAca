package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.CtrlUsuarios;

public interface ICtlgUsuariosService {
    
    public List <CtrlUsuarios> listarusuarios();
    
    public void guardarusuario(CtrlUsuarios usuario);
    
    public void eliminarusuario(CtrlUsuarios usuario);
    
    public CtrlUsuarios usuarioSeleccionado (CtrlUsuarios usuario);
}
