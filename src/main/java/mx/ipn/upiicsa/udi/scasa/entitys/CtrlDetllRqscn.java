package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "drequis")
public class CtrlDetllRqscn implements Serializable {   //Control del detalle de la requisición (Material Solicitado)

private static final long serialVersionUID = 1L;

//@Id
private int nfolio; // Número de folio de la requisición 
private int naniorq; // Año de la requisición de material
//@Id
private LocalDate dfecreq; // Fecha en que se genera la requisición
@Id
private int nnumdet; // Número consecutivo de detalle por requisición
@NotEmpty 
private char ctipart;  // Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
@NotEmpty 
private String ccvartl;  // Clave del artículo solicitado
private int ncvunmd;   // Clave unidad de medida solicitada
private float ncansol; // Cantidad solicitada del artículo
private float ncanent; // Cantidad entregada
@NotEmpty
private char cstatus; // A = Autorizado, R = Registrado, N = No autorizado, P=Procesado

//ALTER TABLE DREQUIS ADD CONSTRAINT PK_DREQUIS
//PRIMARY KEY(NFOLIO,DFECREQ,NNUMDET);    
}
