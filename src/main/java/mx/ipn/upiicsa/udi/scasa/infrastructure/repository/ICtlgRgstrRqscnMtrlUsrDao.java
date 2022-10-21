package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.RgstrRqscnMtrlUsuario;
import mx.ipn.upiicsa.udi.scasa.domain.model.RgstrRqscnMtrlUsuarioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgRgstrRqscnMtrlUsrDao extends JpaRepository<RgstrRqscnMtrlUsuario, RgstrRqscnMtrlUsuarioPK> {

}
