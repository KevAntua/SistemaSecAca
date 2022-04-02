package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "cunimed")
public class CatalogoUniMedida implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int ncvunmd;      // Clave unidad de medida
    @NotEmpty 
    private String cdescrip;  // Descripción
    @NotEmpty 
    private char cvigent;   // Indica si se encuentra o no vigente (S=Vigente; N=No vigente)
}
