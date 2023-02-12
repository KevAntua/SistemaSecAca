package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoUniMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgUndMedidaDao extends JpaRepository<CatalogoUniMedida, Integer> {

}
