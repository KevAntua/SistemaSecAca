package mx.ipn.upiicsa.udi.scasa.entitys;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
@Table(name = "cartcls")

public class CatalogoArtAlmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //@NotEmpty 
    private char ctipart;  // Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
    
    @Id
    
    @NotEmpty
    private String ccvartl;   // Clave del artículo
    
    @NotEmpty 
    private String cdescrip;  //Descripción
    
    //@NotEmpty 
    private int nmaximo;   // Cantidad máximo del artículo en existencia
    
    //@NotEmpty 
    private int nminimo;   // Cantidad mínima del artículo en existencia
    
    //@NotEmpty
    private char cvigent;   // Indica si se encuentra o no vigente

    //ALTER TABLE CARTCLS ADD CONSTRAINT PK_ARTICLS
    //  PRIMARY KEY  (CTIPART,CCVARTL);
}
