package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "careasc")
public class CatalogoAreas {

    @Id
    @Column(name = "NIDAREA", nullable = false)
    private int nidarea;

    @Column(name = "CDESCRI", length = 75)
    private String cdescri;

    @Column(name = "CNOMRES", length = 35)
    private String cnomres;

    @Column(name = "CAPEPAT", length = 35)
    private String capepat;

    @Column(name = "CAPEMAT", length = 35)
    private String capemat;

    @Column(name = "CSIGLAS", length = 10)
    private String csiglas;

    @Column(name = "NIDARED")
    private Integer nidared;

    @Column(name = "CVIGENT", length = 1)
    private String cvigent;
}
