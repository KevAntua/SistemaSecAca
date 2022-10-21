package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CtrlExisAlmacenPK implements Serializable {

    @Column(name = "CTIPART", nullable = false, length = 1)
    private String ctipart;

    @Column(name = "CCVARTL", nullable = false, length = 13)
    private String ccvartl;
}
