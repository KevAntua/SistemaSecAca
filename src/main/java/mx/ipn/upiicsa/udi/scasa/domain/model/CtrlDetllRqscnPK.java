package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CtrlDetllRqscnPK implements Serializable {

    @Column(name = "NFOLIO", nullable = false)
    private int nfolio;

    @Column(name = "DFECREQ", nullable = false)
    private Date dfecreq;

    @Column(name = "NNUMDET", nullable = false)
    private int nnumdet;
}
