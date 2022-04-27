package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "palmacn")
public class CtrlExisAlmacen implements Serializable {

private static final long serialVersionUID = 1L;

@NotNull
private char ctipart;    // Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
@Id //Revisar si es correcto
@NotEmpty 
private String ccvartl;  // Clave del artículo
@NotNull
private float ncantid;   // Cantidad
@NotNull
private int ncvunmd;     // Clave de la unidad de medida
@NotNull
private char cvigent;    // Indica si se encuentra o no vigente

//ALTER TABLE PALMACN ADD  CONSTRAINT PK_PALMACN
//PRIMARY KEY  (CTIPART,CCVARTL);

}
