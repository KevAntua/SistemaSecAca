package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "mrequis")
public class RgstrRqscnMtrlUsuario implements Serializable {

private static final long serialVersionUID = 1L;

@Id
private int nfolio;   // Número de folio de la requisición 
//@Id
private int naniorq;  // Año de la requisición de material
private LocalDate dfecreq; // Fecha en que se genera la requisición
private char ctipreq; // Tipo de requisición (M = MENSUAL, E = EXTEMPORANEO)
@NotEmpty 
private String ccveusu; // Clave de usuario solicitante
@NotEmpty 
private String cusuval; // Clave del usuario que valida, (A=Autoriza o R=Rechaza)
private LocalDate dfecval; // Fecha de la validación
private char cstatus;   // A=Autorizada, R=Registrada, N=No autorizada, P=Procesada
@NotEmpty 
private String cobserv; // Obervaciones sobre la requisición
@NotEmpty 
private String cobssur; // Observaciones al momento de surtir
//ALTER TABLE MREQUIS ADD CONSTRAINT PK_MREQUIS
//PRIMARY KEY(NFOLIO,NANIORQ);    
}
