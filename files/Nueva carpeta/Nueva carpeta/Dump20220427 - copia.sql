CREATE DATABASE  IF NOT EXISTS `almacen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `almacen`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: almacen
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `careasc`
--

DROP TABLE IF EXISTS `careasc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `careasc` (
  `NIDAREA` int NOT NULL,
  `CDESCRI` varchar(75) DEFAULT NULL,
  `CNOMRES` varchar(35) DEFAULT NULL,
  `CAPEPAT` varchar(35) DEFAULT NULL,
  `CAPEMAT` varchar(35) DEFAULT NULL,
  `CSIGLAS` varchar(10) DEFAULT NULL,
  `NIDARED` int DEFAULT NULL,
  `CVIGENT` char(1) DEFAULT NULL,
  PRIMARY KEY (`NIDAREA`),
  KEY `FK_AREASAREASD` (`NIDARED`),
  CONSTRAINT `FK_AREASAREASD` FOREIGN KEY (`NIDARED`) REFERENCES `careasc` (`NIDAREA`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `careasc`
--

LOCK TABLES `careasc` WRITE;
/*!40000 ALTER TABLE `careasc` DISABLE KEYS */;
INSERT INTO `careasc` VALUES (1,'Secretaría académica','David','Jaramillo','Vigueras','SEACASEACA',19,'S'),(2,'Departamento Servicios Administrativos','Antonio','Sánchez','Fragoso','DSA',19,'S'),(3,'Reconocimiento de Validez Oficial Equivalencia y Revalidacion de Estudios','Edith','Álvarez','Hernández','RVOE',19,'S'),(4,'Coordinación de Estimulos Docente','Claudio','Matamoros','Lara','CED',19,'S'),(5,'Programa Institucional deñ Año Sabatico','Jesus Martin','Ramirez','Munguia','PIAS',19,'S'),(6,'Programa de Estimulo al Desempeño Docente','Agustin','Vargas','Casas','EDD',19,'S'),(7,'Programa de Licencia con Goce de Sueldo','Leticia','Rodríguez','Jiménez','LCGS',19,'S'),(8,'Sistema de Administracion del Programa Institucional de Tutorias','Ismael','Jaidar','Monter','SADPIT',19,'S'),(9,'Oficialia de Partes','Francisco Javier','Cerda','Martínez','OP',19,'S'),(10,'Direccion de Educacion Superior','','','','DES',19,'S'),(11,'Direccion de Educacion Media Superior','','','','DEMS',19,'S'),(12,'Direccion de Formacion en Lenguas Extranjeras','','','','DFLE',19,'S'),(13,'Direccion de Formacion e Innovacion Educativa','','','','DFIE',19,'S'),(14,'Coordinació de Sistemas Académicos','Jorge','Pérez','','CSA',19,'S'),(15,'Coordinación de Sistemas Académicos Nivel Superior','Crisóforo','Ordoñes','López','CSANS',19,'S'),(16,'Coordinación de Gestión','Vidal','Salazar','Sánchez','CG',19,'S'),(17,'Estructura Académica','Patricia','Garcia','Garcia','ESAC',19,'S'),(18,'Coordinación de Proyectos','Francisco Javier','Cerda','Martínez','CP',19,'S'),(19,'Unidad de Informática','Javier Edgardo','Martínez','Váldez','UDI',19,'S'),(20,'Coordinación de Sistemas Académicos Nivel Medio Superior','Francisco Javier','Tagle','Contreras','CSANMS',19,'S');
/*!40000 ALTER TABLE `careasc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartcls`
--

DROP TABLE IF EXISTS `cartcls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cartcls` (
  `CTIPART` char(1) NOT NULL,
  `CCVARTL` varchar(13) NOT NULL,
  `CDESCRIP` varchar(70) DEFAULT NULL,
  `NMAXIMO` int DEFAULT NULL,
  `NMINIMO` int DEFAULT NULL,
  `CVIGENT` char(1) DEFAULT NULL,
  PRIMARY KEY (`CTIPART`,`CCVARTL`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartcls`
--

LOCK TABLES `cartcls` WRITE;
/*!40000 ALTER TABLE `cartcls` DISABLE KEYS */;
INSERT INTO `cartcls` VALUES ('C','CAz2','Azúkar 1K',100,20,'S'),('C','CLch3','Leche 1L',100,20,'S'),('C','CPn6','Pan Dulce ',15,10,'N'),('P','PHP4','Hojas de Papel 500pz',250,20,'S');
/*!40000 ALTER TABLE `cartcls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cnvlrolusu`
--

DROP TABLE IF EXISTS `cnvlrolusu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cnvlrolusu` (
  `NIDNVL` int NOT NULL AUTO_INCREMENT,
  `DESCTIPNVL` varchar(18) DEFAULT NULL,
  `CCVEUSU` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`NIDNVL`),
  KEY `FK_CCVEUSU` (`CCVEUSU`),
  CONSTRAINT `FK_CCVEUSU` FOREIGN KEY (`CCVEUSU`) REFERENCES `tususis` (`CCVEUSU`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cnvlrolusu`
--

LOCK TABLES `cnvlrolusu` WRITE;
/*!40000 ALTER TABLE `cnvlrolusu` DISABLE KEYS */;
INSERT INTO `cnvlrolusu` VALUES (1,'ROLE_Master','JMARTÍNEZV'),(2,'ROLE_APrincipal','JMARTÍNEZV'),(3,'ROLE_ASecundario','JMARTÍNEZV'),(4,'ROLE_Usuario','JMARTÍNEZV'),(5,'ROLE_APrincipal','DJARAMILLO'),(6,'ROLE_ASecundario','DJARAMILLO'),(7,'ROLE_Usuario','DJARAMILLO'),(8,'ROLE_ASecundario','EÁLVAREZH'),(9,'ROLE_Usuario','EÁLVAREZH'),(10,'ROLE_Usuario','HCASTILLOF'),(11,'ROLE_Pendiente','FTAGLEC');
/*!40000 ALTER TABLE `cnvlrolusu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cunimed`
--

DROP TABLE IF EXISTS `cunimed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cunimed` (
  `NCVUNMD` int NOT NULL,
  `CDESCRIP` varchar(15) DEFAULT NULL,
  `CVIGENT` char(1) DEFAULT NULL,
  PRIMARY KEY (`NCVUNMD`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cunimed`
--

LOCK TABLES `cunimed` WRITE;
/*!40000 ALTER TABLE `cunimed` DISABLE KEYS */;
/*!40000 ALTER TABLE `cunimed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drequis`
--

DROP TABLE IF EXISTS `drequis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drequis` (
  `NFOLIO` int NOT NULL,
  `NANIORQ` int DEFAULT NULL,
  `DFECREQ` date NOT NULL,
  `NNUMDET` int NOT NULL,
  `CTIPART` char(1) DEFAULT NULL,
  `CCVARTL` varchar(13) DEFAULT NULL,
  `NCVUNMD` int DEFAULT NULL,
  `NCANSOL` decimal(7,2) DEFAULT NULL,
  `NCANENT` decimal(7,2) DEFAULT NULL,
  `CSTATUS` char(1) DEFAULT NULL,
  PRIMARY KEY (`NFOLIO`,`DFECREQ`,`NNUMDET`),
  KEY `FK_DETMREQUIS` (`NFOLIO`,`NANIORQ`),
  KEY `FK_DETARTS` (`CTIPART`,`CCVARTL`),
  KEY `FK_DETUMED` (`NCVUNMD`),
  CONSTRAINT `FK_DETARTS` FOREIGN KEY (`CTIPART`, `CCVARTL`) REFERENCES `cartcls` (`CTIPART`, `CCVARTL`),
  CONSTRAINT `FK_DETMREQUIS` FOREIGN KEY (`NFOLIO`, `NANIORQ`) REFERENCES `mrequis` (`NFOLIO`, `NANIORQ`),
  CONSTRAINT `FK_DETUMED` FOREIGN KEY (`NCVUNMD`) REFERENCES `cunimed` (`NCVUNMD`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drequis`
--

LOCK TABLES `drequis` WRITE;
/*!40000 ALTER TABLE `drequis` DISABLE KEYS */;
/*!40000 ALTER TABLE `drequis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mrequis`
--

DROP TABLE IF EXISTS `mrequis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mrequis` (
  `NFOLIO` int NOT NULL,
  `NANIORQ` int NOT NULL,
  `DFECREQ` date DEFAULT NULL,
  `CTIPREQ` char(1) DEFAULT NULL,
  `CCVEUSU` varchar(10) DEFAULT NULL,
  `CUSUVAL` varchar(10) DEFAULT NULL,
  `DFECVAL` date DEFAULT NULL,
  `CSTATUS` char(1) DEFAULT NULL,
  `COBSERV` varchar(300) DEFAULT NULL,
  `COBSSUR` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`NFOLIO`,`NANIORQ`),
  KEY `FK_REQUISUSUSIS` (`CCVEUSU`),
  KEY `FK_REQUISUSUVAL` (`CUSUVAL`),
  CONSTRAINT `FK_REQUISUSUSIS` FOREIGN KEY (`CCVEUSU`) REFERENCES `tususis` (`CCVEUSU`),
  CONSTRAINT `FK_REQUISUSUVAL` FOREIGN KEY (`CUSUVAL`) REFERENCES `tususis` (`CCVEUSU`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mrequis`
--

LOCK TABLES `mrequis` WRITE;
/*!40000 ALTER TABLE `mrequis` DISABLE KEYS */;
/*!40000 ALTER TABLE `mrequis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palmacn`
--

DROP TABLE IF EXISTS `palmacn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `palmacn` (
  `CTIPART` char(1) NOT NULL,
  `CCVARTL` varchar(13) NOT NULL,
  `NCANTID` decimal(8,2) DEFAULT NULL,
  `NCVUNMD` int DEFAULT NULL,
  `CVIGENT` char(1) DEFAULT NULL,
  PRIMARY KEY (`CTIPART`,`CCVARTL`),
  KEY `FK_PALMCN_CUNIMED` (`NCVUNMD`),
  CONSTRAINT `FK_PALMCN_CARTCLS` FOREIGN KEY (`CTIPART`, `CCVARTL`) REFERENCES `cartcls` (`CTIPART`, `CCVARTL`),
  CONSTRAINT `FK_PALMCN_CUNIMED` FOREIGN KEY (`NCVUNMD`) REFERENCES `cunimed` (`NCVUNMD`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palmacn`
--

LOCK TABLES `palmacn` WRITE;
/*!40000 ALTER TABLE `palmacn` DISABLE KEYS */;
/*!40000 ALTER TABLE `palmacn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pdentra`
--

DROP TABLE IF EXISTS `pdentra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pdentra` (
  `NIDENTA` int NOT NULL,
  `NANIOEA` int NOT NULL,
  `NIDDENT` int NOT NULL,
  `CTIPART` char(1) DEFAULT NULL,
  `CCVARTL` varchar(13) DEFAULT NULL,
  `NCVUNMD` int DEFAULT NULL,
  `NCANTID` decimal(8,2) DEFAULT NULL,
  `NCOSTOU` decimal(13,5) DEFAULT NULL,
  `CSTATUS` char(1) DEFAULT NULL,
  PRIMARY KEY (`NIDENTA`,`NANIOEA`,`NIDDENT`),
  KEY `FK_PDENTRA_CARTCLS` (`CTIPART`,`CCVARTL`),
  KEY `FK_PDENTRA_CUNIMED1` (`NCVUNMD`),
  CONSTRAINT `FK_PDENTRA_CARTCLS` FOREIGN KEY (`CTIPART`, `CCVARTL`) REFERENCES `cartcls` (`CTIPART`, `CCVARTL`),
  CONSTRAINT `FK_PDENTRA_CUNIMED1` FOREIGN KEY (`NCVUNMD`) REFERENCES `cunimed` (`NCVUNMD`),
  CONSTRAINT `FK_PDENTRA_PENTALM` FOREIGN KEY (`NIDENTA`, `NANIOEA`) REFERENCES `pentalm` (`NIDENTA`, `NANIOEA`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pdentra`
--

LOCK TABLES `pdentra` WRITE;
/*!40000 ALTER TABLE `pdentra` DISABLE KEYS */;
/*!40000 ALTER TABLE `pdentra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pentalm`
--

DROP TABLE IF EXISTS `pentalm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pentalm` (
  `NIDENTA` int NOT NULL,
  `NANIOEA` int NOT NULL,
  `DFECENT` date DEFAULT NULL,
  `CSTATUS` char(1) DEFAULT NULL,
  PRIMARY KEY (`NIDENTA`,`NANIOEA`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pentalm`
--

LOCK TABLES `pentalm` WRITE;
/*!40000 ALTER TABLE `pentalm` DISABLE KEYS */;
/*!40000 ALTER TABLE `pentalm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tususis`
--

DROP TABLE IF EXISTS `tususis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tususis` (
  `CCVEUSU` varchar(10) NOT NULL,
  `CPASSWR` varchar(128) DEFAULT NULL,
  `USERNAME` varchar(35) DEFAULT NULL,
  `CPRIAPE` varchar(35) DEFAULT NULL,
  `CSEGAPE` varchar(35) DEFAULT NULL,
  `NIDAREA` int DEFAULT NULL,
  `CVIGENT` char(1) DEFAULT NULL,
  PRIMARY KEY (`CCVEUSU`),
  KEY `FK_TUSUSIS_CAREASC` (`NIDAREA`),
  CONSTRAINT `FK_TUSUSIS_CAREASC` FOREIGN KEY (`NIDAREA`) REFERENCES `careasc` (`NIDAREA`)
)  
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tususis`
--

LOCK TABLES `tususis` WRITE;
/*!40000 ALTER TABLE `tususis` DISABLE KEYS */;
INSERT INTO `tususis` VALUES ('ÁALVARADOH','SA09AHÁ2021','Álvaro','Alvarado','Hernández',6,'S'),('CMATAMOROS','SA04MLC2021','Claudio','Matamoros','Lara',4,'S'),('CORDOÑESL','SA06OLC2021','Crisóforo','Ordoñes','López',15,'S'),('DJARAMILLO','$2a$10$/2KyuVPOpjrZ20F8it/4kuUMtHizk19BcUGwdQS.7nYTV30q1WOSC','David','Jaramillo','Vigueras',1,'S'),('EÁLVAREZH','$2a$10$ch/9A4ar10JyfFe2btEcYuCfLHBZIHRNebJkGEnjlXf9L0mLkskqW','Edith','Álvarez','Hernández',3,'S'),('FCERDAM','SA05CMF2021','Francisco Javier','Cerda','Martínez',18,'S'),('FTAGLEC','$2a$10$3.AR/8hPaDeQ5Ntw6IJX7.DowHAMII8Am30Af0rNfwoynFJ./qp22','Francisco Javier','Tagle','Contreras',NULL,'S'),('HCASTILLOF','$2a$10$R1y8ylvPzEGhgvT1hbDvI.CnGIzksS0i9dWcw3FcGzCqjKxlK45SW','Hugo','Castillo','Fernández',1,'S'),('JALVARADOM','SA11AMJ2021','Jose Arturo','Alvarado','Mercado',NULL,'S'),('JMARTÍNEZV','$2a$10$KLGt11b7mjHtbyzdSo/8PearOzMQ516wDiuO4465oVpsMDqGXU3tG','Javier Edgrdo','Martínez','Váldez',19,'S'),('JPÉREZX','SA02PXJ2021','Jorge','Pérez',NULL,14,'S'),('VSALAZARS','SA08SSV2021','Vidal','Salazar','Sánchez',16,'S');
/*!40000 ALTER TABLE `tususis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-27 22:37:45
