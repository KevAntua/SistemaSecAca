package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetalEntrAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.model.CtrlDetalEntrAlmacenPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgDtllEntrdAlmcnDao extends JpaRepository <CtrlDetalEntrAlmacen, CtrlDetalEntrAlmacenPK>{
    
}
