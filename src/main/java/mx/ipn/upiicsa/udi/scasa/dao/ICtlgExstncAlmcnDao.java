package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.CtrlExisAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgExstncAlmcnDao extends JpaRepository<CtrlExisAlmacen, String> {
    
}
