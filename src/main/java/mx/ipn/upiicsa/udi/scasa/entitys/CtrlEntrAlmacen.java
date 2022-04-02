package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "pentalm")
public class CtrlEntrAlmacen implements Serializable {

private static final long serialVersionUID = 1L;

@Id
private int nidenta;          // ID de entrada
//@Id
private int nanioea;          // Año de la entrada
private LocalDate dfecent;    // Fecha de la entrada 
// https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
@NotEmpty 
private char cstatus;         // Indica si la entrada se encuentra (A=Activa, P=Procesada o C=Cancelada)
  
//ALTER TABLE PENTALM ADD   CONSTRAINT PK_PENTALM
//  PRIMARY KEY  (NIDENTA, NANIOEA);
    
}
