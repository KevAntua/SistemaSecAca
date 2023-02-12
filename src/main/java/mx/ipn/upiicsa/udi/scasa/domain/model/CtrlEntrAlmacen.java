package mx.ipn.upiicsa.udi.scasa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
@Table(name = "pentalm")
public class CtrlEntrAlmacen {

    @EmbeddedId
    private CtrlEntrAlmacenPK id;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "DFECENT")
    private Date dfecent;

    @Column(name = "CSTATUS", length = 1)
    private String cstatus;
}
