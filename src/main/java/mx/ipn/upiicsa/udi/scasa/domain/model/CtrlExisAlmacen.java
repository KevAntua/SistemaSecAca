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
@Table(name = "palmacn")
public class CtrlExisAlmacen {

    @EmbeddedId
    private CtrlExisAlmacenPK id;

    @Column(name = "NCANTID", precision = 2)
    private BigDecimal ncantid;

    @Column(name = "NCVUNMD")
    private Integer ncvunmd;

    @Column(name = "CVIGENT", length = 1)
    private String cvigent;
}
