CREATE SCHEMA ALMACEN;
USE ALMACEN;
-- Catálogo de unidades de medida
CREATE TABLE CUNIMED(
  NCVUNMD   INTEGER(3),   -- Clave unidad de medida
  CDESCRIP  VARCHAR(15),  -- Descripción
  CVIGENT   CHAR(1));    -- Indica si se encuentra o no vigente (S=Vigente; N=No vigente)
  
ALTER TABLE CUNIMED ADD CONSTRAINT PK_CUNIMED
  PRIMARY KEY  (NCVUNMD);
-- *************************************************
-- Catálogo de áreas 
CREATE TABLE CAREASC(
NIDAREA   INTEGER(3),  -- ID del área
CDESCRI  VARCHAR(75), -- Descripción del nombre completo del área
CNOMRES VARCHAR(35), -- Nombre del responsable del área
CAPEPAT VARCHAR(35), -- Apellido paterno del responsable del área
CAPEMAT VARCHAR(35), -- Apellido materno del responsable del área
CSIGLAS    VARCHAR(10), -- Siglas que identifican al área
NIDARED   INTEGER(3),  -- ID del área de la cual depende, si es el área de más alta jerarquía, este campo se encontrará vacío.
CVIGENT   CHAR(1));    -- Indica si se encuentra o no vigente (S=Vigente; N=No vigente)

ALTER TABLE CAREASC ADD CONSTRAINT PK_CAREASC
PRIMARY KEY(NIDAREA);

ALTER TABLE CAREASC ADD CONSTRAINT FK_AREASAREASD
FOREIGN KEY(NIDARED) REFERENCES CAREASC(NIDAREA);
-- *************************************************
-- Tabla de catálogo de artículos en el almacén
CREATE TABLE CARTCLS(
  CTIPART  CHAR(1), -- Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
  CCVARTL   VARCHAR(13),  -- Clave del artículo
  CDESCRIP  VARCHAR(70),  -- Descripción
  NMAXIMO   INTEGER(5),  -- Cantidad máximo del artículo en existencia
  NMINIMO   INTEGER(5), -- -- Cantidad mínima del artículo en existencia
  CVIGENT   CHAR(1));  -- Indica si se encuentra o no vigente

ALTER TABLE CARTCLS ADD CONSTRAINT PK_ARTICLS
  PRIMARY KEY  (CTIPART,CCVARTL);
-- ***************************************************
-- Tabla para el control de las existencias de artículos en el almacen
CREATE TABLE PALMACN(
  CTIPART  CHAR(1), -- Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
  CCVARTL  VARCHAR(13),  -- Clave del artículo
  NCANTID  DECIMAL(8,2),  -- Cantidad
  NCVUNMD  INTEGER(3),  -- Clave de la unidad de medida
  CVIGENT   CHAR(1));  -- Indica si se encuentra o no vigente

ALTER TABLE PALMACN ADD  CONSTRAINT PK_PALMACN
  PRIMARY KEY  (CTIPART,CCVARTL);

ALTER TABLE PALMACN ADD   CONSTRAINT FK_PALMCN_CARTCLS 
  FOREIGN KEY (CTIPART,CCVARTL)   REFERENCES CARTCLS (CTIPART,CCVARTL);
  
ALTER TABLE PALMACN ADD   CONSTRAINT FK_PALMCN_CUNIMED
  FOREIGN KEY (NCVUNMD)   REFERENCES CUNIMED (NCVUNMD);
-- ********************************************
-- Tabla para el control de las entradas al almacen
CREATE TABLE PENTALM(
  NIDENTA  INTEGER(6),  -- ID de entrada
  NANIOEA  INTEGER(4), -- Año de la entrada
  DFECENT  DATE,  -- Fecha de la entrada
  CSTATUS  CHAR(1));  -- Indica si la entrada se encuentra (A=Activa, P=Procesada o C=Cancelada)
  
ALTER TABLE PENTALM ADD   CONSTRAINT PK_PENTALM
  PRIMARY KEY  (NIDENTA, NANIOEA);
-- ****************************************************
-- Tabla para el control del detalle de las entradas al almacen
CREATE TABLE PDENTRA(
  NIDENTA  INTEGER(6),  -- ID de entrada
  NANIOEA  INTEGER(4), -- Año de la entrada
  NIDDENT  INTEGER(5),  -- ID detalle entrada
  CTIPART  CHAR(1), -- Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
  CCVARTL  VARCHAR(13),  -- Clave del artículo
  NCVUNMD   INTEGER(3),   -- Clave unidad de medida
  NCANTID  DECIMAL(8,2),  -- Cantidad 
  NCOSTOU  DECIMAL(13,5),  -- Costo unitario
  CSTATUS  CHAR(1));   -- Indica si el detalle entrada se encuentra (A=Activo o C=Cancelado)

ALTER TABLE PDENTRA ADD  CONSTRAINT PK_PDENTRA
  PRIMARY KEY  (NIDENTA, NANIOEA, NIDDENT);

ALTER TABLE PDENTRA ADD   CONSTRAINT FK_PDENTRA_CARTCLS 
  FOREIGN KEY (CTIPART,CCVARTL)   REFERENCES CARTCLS (CTIPART,CCVARTL);
  
  ALTER TABLE PDENTRA ADD  CONSTRAINT FK_PDENTRA_CUNIMED1
  FOREIGN KEY (NCVUNMD) 
  REFERENCES CUNIMED (NCVUNMD);
  
  ALTER TABLE PDENTRA ADD  CONSTRAINT FK_PDENTRA_PENTALM 
  FOREIGN KEY (NIDENTA, NANIOEA) 
  REFERENCES PENTALM (NIDENTA,NANIOEA);

-- ***********************************************
-- Tabla para el control de usuarios
CREATE TABLE TUSUSIS(
  CCVEUSU  VARCHAR(10),  -- Clave de usuario
  CPASSWR  VARCHAR(20),   -- Password
  CNOMBRE VARCHAR(35), -- Nombre(s) del usuario
  CPRIAPE    VARCHAR(35),   -- Primer apellido
  CSEGAPE    VARCHAR(35),   -- Segundo apellido
  NIDAREA   INTEGER(3),  -- ID del área
  CVIGENT  CHAR(1));    -- Indica si el registro se encuentra S=Vigente o N=No vigente

ALTER TABLE TUSUSIS ADD CONSTRAINT PK_TUSUSIS
  PRIMARY KEY (CCVEUSU);

ALTER TABLE TUSUSIS ADD CONSTRAINT FK_TUSUSIS_CAREASC 
  FOREIGN KEY (NIDAREA) REFERENCES CAREASC (NIDAREA);
-- ***********************************************
-- Tabla para el registro de las requisiciones de material por parte de los usuarios
CREATE TABLE MREQUIS(
NFOLIO INTEGER(7),  -- Número de folio de la requisición 
NANIORQ INTEGER(4), -- Año de la requisición de material
DFECREQ DATE, -- Fecha en que se genera la requisición
CTIPREQ CHAR(1), -- Tipo de requisición (M = MENSUAL, E = EXTEMPORANEO)
CCVEUSU  VARCHAR(10),  -- Clave de usuario solicitante
CUSUVAL VARCHAR(10), -- Clave del usuario que valida, (A=Autoriza o R=Rechaza)
DFECVAL DATE, -- Fecha de la validación
CSTATUS CHAR(1), -- A=Autorizada, R=Registrada, N=No autorizada, P=Procesada
COBSERV  VARCHAR(300), -- Obervaciones sobre la requisición
COBSSUR VARCHAR(200));  -- Observaciones al momento de surtir

ALTER TABLE MREQUIS ADD CONSTRAINT PK_MREQUIS
PRIMARY KEY(NFOLIO,NANIORQ);

ALTER TABLE MREQUIS ADD CONSTRAINT FK_REQUISUSUSIS
FOREIGN KEY(CCVEUSU) REFERENCES TUSUSIS(CCVEUSU);

ALTER TABLE MREQUIS ADD CONSTRAINT FK_REQUISUSUVAL
FOREIGN KEY(CUSUVAL) REFERENCES TUSUSIS(CCVEUSU);
-- *********************************************
-- Tabla para el control del detalle de la requisición (material solicitado)
CREATE TABLE DREQUIS(
NFOLIO INTEGER(7),  -- Número de folio de la requisición 
NANIORQ INTEGER(4), -- Año de la requisición de material
DFECREQ DATE, -- Fecha en que se genera la requisición
NNUMDET INTEGER(3), -- Número consecutivo de detalle por requisición
CTIPART  CHAR(1), -- Tipo de artículo: P=Papelería, C=Cafetería, T=Computó
CCVARTL  VARCHAR(13),  -- Clave del artículo solicitado
NCVUNMD   INTEGER(3),   -- Clave unidad de medida solicitada
NCANSOL DECIMAL(7,2), -- Cantidad solicitada del artículo
NCANENT DECIMAL(7,2), -- Cantidad entregada
CSTATUS CHAR(1)); -- A = Autorizado, R = Registrado, N = No autorizado, P=Procesado

ALTER TABLE DREQUIS ADD CONSTRAINT PK_DREQUIS
PRIMARY KEY(NFOLIO,DFECREQ,NNUMDET);

ALTER TABLE DREQUIS ADD CONSTRAINT FK_DETMREQUIS
FOREIGN KEY(NFOLIO,NANIORQ) REFERENCES MREQUIS(NFOLIO,NANIORQ);

ALTER TABLE DREQUIS ADD CONSTRAINT FK_DETARTS
FOREIGN KEY(CTIPART,CCVARTL) REFERENCES CARTCLS(CTIPART,CCVARTL);

ALTER TABLE DREQUIS ADD CONSTRAINT FK_DETUMED
FOREIGN KEY(NCVUNMD) REFERENCES CUNIMED(NCVUNMD);
