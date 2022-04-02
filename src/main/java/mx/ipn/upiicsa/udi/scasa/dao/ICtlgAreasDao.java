package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoAreas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgAreasDao extends JpaRepository <CatalogoAreas, Integer> {
    
}
