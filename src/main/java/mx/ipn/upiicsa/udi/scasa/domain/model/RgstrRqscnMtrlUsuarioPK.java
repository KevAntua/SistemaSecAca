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
public class RgstrRqscnMtrlUsuarioPK implements Serializable {

    @Column(name = "NFOLIO", nullable = false)
    private int nfolio;

    @Column(name = "NANIORQ", nullable = false)
    private int naniorq;
}
