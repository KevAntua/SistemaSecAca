package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "pentalm")
public class CtrlEntrAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    
//    @Transient
//    private DateTimeFormatter esDateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    
//    public CtrlEntrAlmacen() {
//        if(dfecent != null){
//            this.dfecent.format(CtrlEntrAlmacen.esDateFormat);
//        }
//    }

    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dfecent;    // Fecha de la entrada 
    @Id
    @NotNull
    @NotNull
    private int nidenta;          // ID de entrada
    private int nanioea;          // Año de la entrada
    @NotNull
    // https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
    @NotNull
    private char cstatus;         // Indica si la entrada se encuentra (A=Activa, P=Procesada o C=Cancelada)

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "nidenta")
    private CtrlDetalEntrAlmacen detentrada;
//ALTER TABLE PENTALM ADD   CONSTRAINT PK_PENTALM
//  PRIMARY KEY  (NIDENTA, NANIOEA);

}
