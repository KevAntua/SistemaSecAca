package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "careasc")
public class CatalogoAreas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    private int nidarea;     //Id del area
    @NotEmpty 
    private String cdescri;  //Descripción del nombre completo del área
    @NotEmpty 
    private String cnomres;  // Nombre del responsable del área
    @NotEmpty 
    private String capepat;  // Apellido paterno del responsable del área
    @NotEmpty 
    private String capemat;  // Apellido materno del responsable del área
    @NotEmpty 
    private String csiglas;  // Siglas que identifican al área
    @NotNull
    private int nidared;     // ID del área de la cual depende, si es el área de más alta jerarquía, este campo se encontrará vacío.
    @NotNull
    private char cvigent;    // Indica si se encuentra o no vigente (S=Vigente; N=No vigente)   
}
