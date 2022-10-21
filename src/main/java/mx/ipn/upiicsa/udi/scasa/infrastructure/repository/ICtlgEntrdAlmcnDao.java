package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlEntrAlmacenPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgEntrdAlmcnDao extends JpaRepository<CtrlEntrAlmacen, CtrlEntrAlmacenPK> {

}
