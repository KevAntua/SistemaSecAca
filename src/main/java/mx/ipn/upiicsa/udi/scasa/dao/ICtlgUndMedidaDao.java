package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoUniMedida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgUndMedidaDao extends JpaRepository <CatalogoUniMedida, Integer>{
    
}
