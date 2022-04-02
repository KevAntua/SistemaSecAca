package mx.ipn.upiicsa.udi.scasa.dao;

import mx.ipn.upiicsa.udi.scasa.entitys.CatalogoArtAlmacen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICtlgArtsAlmacenDao extends JpaRepository <CatalogoArtAlmacen, String>{
    
}
