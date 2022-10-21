package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pdentra")
public class CtrlDetalEntrAlmacen {

    @EmbeddedId
    private CtrlDetalEntrAlmacenPK id;

    @Column(name = "CTIPART", length = 1)
    private String ctipart;

    @Column(name = "CCVARTL", length = 13)
    private String ccvartl;

    @Column(name = "NCVUNMD")
    private Integer ncvunmd;

    @Column(name = "NCANTID", precision = 2)
    private BigDecimal ncantid;

    @Column(name = "NCOSTOU", precision = 5)
    private BigDecimal ncostou;

    @Column(name = "CSTATUS", length = 1)
    private String cstatus;
}
