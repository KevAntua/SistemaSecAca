package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoAreas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgAreasDao extends JpaRepository <CatalogoAreas, Integer> {
    
}
