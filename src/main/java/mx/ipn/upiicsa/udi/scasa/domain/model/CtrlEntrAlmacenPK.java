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
public class CtrlEntrAlmacenPK implements Serializable {

    @Column(name = "NIDENTA", nullable = false)
    private int nidenta;

    @Column(name = "NANIOEA", nullable = false)
    private int nanioea;
}
