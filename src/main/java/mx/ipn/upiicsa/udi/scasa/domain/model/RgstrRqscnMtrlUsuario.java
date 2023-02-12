package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mrequis")
public class RgstrRqscnMtrlUsuario {

    @EmbeddedId
    private RgstrRqscnMtrlUsuarioPK id;

    @Column(name = "DFECREQ")
    private Date dfecreq;

    @Column(name = "CTIPREQ", length = 1)
    private String ctipreq;

    @Column(name = "CCVEUSU", length = 10)
    private String ccveusu;

    @Column(name = "CUSUVAL", length = 10)
    private String cusuval;

    @Column(name = "DFECVAL")
    private Date dfecval;

    @Column(name = "CSTATUS", length = 1)
    private String cstatus;

    @Column(name = "COBSERV", length = 300)
    private String cobserv;

    @Column(name = "COBSSUR", length = 200)
    private String cobssur;
}
