package mx.ipn.upiicsa.udi.scasa.service;

import java.util.List;
import mx.ipn.upiicsa.udi.scasa.entitys.RgstrRqscnMtrlUsuario;

public interface ICtlgRgstrRqscnMtrlUsrService {
    
    public List <RgstrRqscnMtrlUsuario> listarRgstrRqscnMtrlUsuario();
    
    public void guardarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario);
    
    public void eliminarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario);
    
    public RgstrRqscnMtrlUsuario rgstrRqscnMtrlUsuarioSeleccionado (RgstrRqscnMtrlUsuario rgstrRqscnUsuario);
    
}
