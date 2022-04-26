package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "tususis")
public class CtrlUsuarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotEmpty
    private String ccveusu;  // Clave de usuario
    @NotEmpty
    private String cpasswr; // Password
    @NotEmpty
    private String username; // Nombre(s) del usuario
    @NotEmpty
    private String cpriape; // Primer apellido
    private String csegape; // Segundo apellido
    private int nidarea;    // ID del área
    @NotEmpty
    private char cvigent;   // Indica si el registro se encuentra S=Vigente o N=No vigente
    
    @OneToMany
    @JoinColumn(name = "ccveusu")
    private List<CatalogoNvlsRoles> roles;

}
