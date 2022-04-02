package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.RgstrRqscnMtrlUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgRgstrRqscnMtrlUsrDao extends JpaRepository<RgstrRqscnMtrlUsuario, Integer >{
    
}
