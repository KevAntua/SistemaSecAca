package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cnvlrolusu")
public class CatalogoNvlsRoles {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "NIDNVL", nullable = false)
    private int nidnvl;

    @Column(name = "DESCTIPNVL", length = 18)
    private String desctipnvl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCVEUSU")
    private CtrlUsuarios ccveusu;
}
