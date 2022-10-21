package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICtlgUsuariosDao extends JpaRepository<CtrlUsuarios, String> {
    Optional<CtrlUsuarios> findByUsername(String username);
}
