package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlExisAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlExisAlmacenPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgExstncAlmcnDao extends JpaRepository<CtrlExisAlmacen, CtrlExisAlmacenPK> {

}
