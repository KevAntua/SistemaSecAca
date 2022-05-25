package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Date;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "pentalm")
public class CtrlEntrAlmacen implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@NotNull
private int nidenta;          // ID de entrada
@NotNull
private int nanioea;          // Año de la entrada
@NotNull
private LocalDate dfecent;    // Fecha de la entrada 

// https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
@NotNull
private char cstatus;         // Indica si la entrada se encuentra (A=Activa, P=Procesada o C=Cancelada)
  
//ALTER TABLE PENTALM ADD   CONSTRAINT PK_PENTALM
//  PRIMARY KEY  (NIDENTA, NANIOEA);
    
}
