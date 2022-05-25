package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "pdentra")
public class CtrlDetalEntrAlmacen implements Serializable {

private static final long serialVersionUID = 1L;

@NotNull
private int nidenta;     // ID de entrada
@NotNull
private int nanioea;     // Año de la entrada

@Id
@NotNull
private int niddent;     // ID detalle entrada
@NotNull 
private char ctipart;    // Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
@NotEmpty 
private String ccvartl;  // Clave del artículo
@NotNull
private int ncvunmd;     // Clave unidad de medida
@NotNull
private float ncantid;   // Cantidad 
@NotNull
private float ncostou;   // Costo unitario
@NotNull
private char cstatus;    // Indica si el detalle entrada se encuentra (A=Activo o C=Cancelado)

//ALTER TABLE PDENTRA ADD  CONSTRAINT PK_PDENTRA
//  PRIMARY KEY  (NIDENTA, NANIOEA, NIDDENT);
    
}
