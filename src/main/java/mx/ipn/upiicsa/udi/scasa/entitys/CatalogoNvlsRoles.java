package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
@Table(name = "cnvlrolusu")
public class CatalogoNvlsRoles implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nidnvl; //id del nivel de usuario

    @NotEmpty
    private String desctipnvl;
    
}
