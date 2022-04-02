package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.CtrlUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgUsuariosDao extends JpaRepository<CtrlUsuarios, String> {
    //CtrlUsuarios findByUsername(String username);
}
