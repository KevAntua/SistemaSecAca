package mx.ipn.upiicsa.udi.scasa.domain.service;

import mx.ipn.upiicsa.udi.scasa.domain.model.RgstrRqscnMtrlUsuario;

import java.util.List;

public interface ICtlgRgstrRqscnMtrlUsrService {

    public List<RgstrRqscnMtrlUsuario> listarRgstrRqscnMtrlUsuario();

    public void guardarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario);

    public void eliminarRgstrRqscnMtrlUsuario(RgstrRqscnMtrlUsuario rgstrRqscnUsuario);

    public RgstrRqscnMtrlUsuario rgstrRqscnMtrlUsuarioSeleccionado(RgstrRqscnMtrlUsuario rgstrRqscnUsuario);

}
