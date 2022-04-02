package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "cnvlrolusu")
public class CatalogoNvlsRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty
    private int nidnvl; //id del nivel de usuario

    @NotEmpty
    private String desctipnvl;

}
