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
@Table(name = "cunimed")
public class CatalogoUniMedida {

    @Id
    @Column(name = "NCVUNMD", nullable = false)
    private int ncvunmd;

    @Column(name = "CDESCRIP", length = 15)
    private String cdescrip;

    @Column(name = "CVIGENT", length = 1)
    private String cvigent;
}
