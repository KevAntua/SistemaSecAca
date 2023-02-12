package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tususis")
public class CtrlUsuarios {

    @Id
    @Column(name = "CCVEUSU", nullable = false, length = 10)
    private String ccveusu;

    @Column(name = "CPASSWR", length = 128)
    private String cpasswr;

    @Column(name = "USERNAME", length = 35)
    private String username;

    @Column(name = "CPRIAPE", length = 35)
    private String cpriape;

    @Column(name = "CSEGAPE", length = 35)
    private String csegape;

    @Column(name = "CVIGENT", length = 1)
    private String cvigent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NIDAREA")
    private CatalogoAreas nidarea;

    @OneToMany(mappedBy = "ccveusu", fetch = FetchType.LAZY)
    private Set<CatalogoNvlsRoles> authorities;
}
