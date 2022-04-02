package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "pdentra")
public class CtrlDetalEntrAlmacen implements Serializable {

private static final long serialVersionUID = 1L;

//@Id
private int nidenta;      // ID de entrada
//@Id
private int nanioea;     // Año de la entrada
@Id
private int niddent;     // ID detalle entrada
@NotEmpty 
private char ctipart;    // Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
@NotEmpty 
private String ccvartl;  // Clave del artículo
private int ncvunmd;     // Clave unidad de medida
private float ncantid;   // Cantidad 
private float ncostou;   // Costo unitario
@NotEmpty 
private char cstatus;    // Indica si el detalle entrada se encuentra (A=Activo o C=Cancelado)

//ALTER TABLE PDENTRA ADD  CONSTRAINT PK_PDENTRA
//  PRIMARY KEY  (NIDENTA, NANIOEA, NIDDENT);
    
}
