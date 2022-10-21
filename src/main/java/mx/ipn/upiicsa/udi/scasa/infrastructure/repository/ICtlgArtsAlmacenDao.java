package mx.ipn.upiicsa.udi.scasa.infrastructure.repository;

import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoArtAlmacen;
import mx.ipn.upiicsa.udi.scasa.domain.model.CatalogoArtAlmacenPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICtlgArtsAlmacenDao extends JpaRepository<CatalogoArtAlmacen, CatalogoArtAlmacenPK> {

    Optional<CatalogoArtAlmacen> findByIdCcvartl(String ccvartl);
    void deleteByIdCcvartl(String ccvartl);
}
