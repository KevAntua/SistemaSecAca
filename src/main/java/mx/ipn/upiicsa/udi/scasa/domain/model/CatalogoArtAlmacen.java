package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cartcls")
public class CatalogoArtAlmacen {

    @EmbeddedId
    private CatalogoArtAlmacenPK id;

    @Column(name = "CDESCRIP", length = 70)
    private String cdescrip;

    @Column(name = "NMAXIMO")
    private Integer nmaximo;

    @Column(name = "NMINIMO")
    private Integer nminimo;

    @Column(name = "CVIGENT", length = 1)
    private String cvigent;
}
