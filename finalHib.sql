CREATE DATABASE  IF NOT EXISTS `finalHib` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `finalHib`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: localhost    Database: finalHib
-- ------------------------------------------------------
-- Server version	5.7.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Administrador`
--

DROP TABLE IF EXISTS `Administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrador` (
  `ModoDios` bit(1) DEFAULT NULL,
  `IdUsuario` int(11) NOT NULL,
  PRIMARY KEY (`IdUsuario`),
  CONSTRAINT `FKlk9ms9mn1bf27re88cnsu9612` FOREIGN KEY (`IdUsuario`) REFERENCES `Usuario` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrador`
--

LOCK TABLES `Administrador` WRITE;
/*!40000 ALTER TABLE `Administrador` DISABLE KEYS */;
INSERT INTO `Administrador` VALUES ('',1);
/*!40000 ALTER TABLE `Administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `fechaNacimiento` date DEFAULT NULL,
  `Genero` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `IdUsuario` int(11) NOT NULL,
  `ciclo_IdCiclo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`),
  KEY `FK3cdwum29yu0ymb66dqx9l1km3` (`ciclo_IdCiclo`),
  CONSTRAINT `FK3cdwum29yu0ymb66dqx9l1km3` FOREIGN KEY (`ciclo_IdCiclo`) REFERENCES `ciclos` (`IdCiclo`),
  CONSTRAINT `FKoq1si04nfj9v8w3y0tr0hu8mp` FOREIGN KEY (`IdUsuario`) REFERENCES `Usuario` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
INSERT INTO `Alumno` VALUES ('2019-02-06','HOMBRE',10,'ADG3-2');
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno_Nota`
--

DROP TABLE IF EXISTS `Alumno_Nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno_Nota` (
  `Alumno_IdUsuario` int(11) NOT NULL,
  `notas_idNotas` int(11) NOT NULL,
  UNIQUE KEY `UK_o78435d58ctoyntuiate41oq7` (`notas_idNotas`),
  KEY `FKrdqkphm106s118bxis1de4acu` (`Alumno_IdUsuario`),
  CONSTRAINT `FK74ijq3lu59u4i55w7xq9r4cg5` FOREIGN KEY (`notas_idNotas`) REFERENCES `Nota` (`idNotas`),
  CONSTRAINT `FKrdqkphm106s118bxis1de4acu` FOREIGN KEY (`Alumno_IdUsuario`) REFERENCES `Alumno` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno_Nota`
--

LOCK TABLES `Alumno_Nota` WRITE;
/*!40000 ALTER TABLE `Alumno_Nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alumno_Nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Nota`
--

DROP TABLE IF EXISTS `Nota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Nota` (
  `idNotas` int(11) NOT NULL AUTO_INCREMENT,
  `nota` int(11) NOT NULL,
  `alumno_IdUsuario` int(11) DEFAULT NULL,
  `modulo_IdModulo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idNotas`),
  KEY `FK7t819han75khl9udhm8xfcjkj` (`alumno_IdUsuario`),
  CONSTRAINT `FK7t819han75khl9udhm8xfcjkj` FOREIGN KEY (`alumno_IdUsuario`) REFERENCES `Alumno` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Nota`
--

LOCK TABLES `Nota` WRITE;
/*!40000 ALTER TABLE `Nota` DISABLE KEYS */;
/*!40000 ALTER TABLE `Nota` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tutor`
--

DROP TABLE IF EXISTS `Tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tutor` (
  `IdUsuario` int(11) NOT NULL,
  `ciclo_IdCiclo` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`),
  KEY `FK9n813pah92l6xlsmed7yjm6py` (`ciclo_IdCiclo`),
  CONSTRAINT `FK9n813pah92l6xlsmed7yjm6py` FOREIGN KEY (`ciclo_IdCiclo`) REFERENCES `ciclos` (`IdCiclo`),
  CONSTRAINT `FKru14puhueo5rguplxwecj3fca` FOREIGN KEY (`IdUsuario`) REFERENCES `Usuario` (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tutor`
--

LOCK TABLES `Tutor` WRITE;
/*!40000 ALTER TABLE `Tutor` DISABLE KEYS */;
INSERT INTO `Tutor` VALUES (2,'ADG3-2'),(8,'COM3-1');
/*!40000 ALTER TABLE `Tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `IdUsuario` int(11) NOT NULL,
  `UltimoAcceso` date DEFAULT NULL,
  `Apellidos` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `NIF` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Rol` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`),
  UNIQUE KEY `UK_rhs72iqjkdwaomorunwfom7ge` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'2019-02-27','Admin','finalhib@gmail.com','00001234S','Admin','123','ADMINISTRADOR'),(2,'2019-02-27','Gallardo Anguiano','edu@gmail.com','00001234S','Edu','123','TUTOR'),(8,'2019-02-27','Mathamel','katy@gmail.com','00001234S','Katy','123','TUTOR'),(10,'2019-02-28','Valdés','juanvaldes@gmail.com','00001234S','Juan','123','ALUMNO');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclos`
--

DROP TABLE IF EXISTS `ciclos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciclos` (
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci NOT NULL,
  `Abreviatura` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `HorasFCT` smallint(6) NOT NULL,
  `Ley` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Nombre` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdCiclo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclos`
--

LOCK TABLES `ciclos` WRITE;
/*!40000 ALTER TABLE `ciclos` DISABLE KEYS */;
INSERT INTO `ciclos` VALUES ('ADG1-10','SAD',130,NULL,'Servicios Administrativos'),('ADG2-1','GAD',400,'LOE','Gestión Administrativa'),('ADG3-1','AFI',400,'LOE','Administración y Finanzas'),('ADG3-2','ADI',400,'LOE','Asistencia a la Dirección'),('COM2-1','ACOM',400,'LOE','Actividades Comerciales'),('COM3-1','COI',400,'LOE','Comercio Internacional'),('IFC3-1','ASIR',400,'LOE','Administración de Sistemas Informáticos en Red'),('IFC3-3','DAW',400,'LOE','Desarrollo de Aplicaciones Web');
/*!40000 ALTER TABLE `ciclos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciclosmodulos`
--

DROP TABLE IF EXISTS `ciclosmodulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ciclosmodulos` (
  `IdCiclo` varchar(7) COLLATE utf8_spanish_ci DEFAULT NULL,
  `IdModulo` smallint(6) DEFAULT NULL,
  KEY `FKj82v8q3xp6mm3vcxxx9j8324q` (`IdModulo`),
  KEY `FK5a13ci2upja6wyjkl3jrwp84v` (`IdCiclo`),
  CONSTRAINT `FK5a13ci2upja6wyjkl3jrwp84v` FOREIGN KEY (`IdCiclo`) REFERENCES `ciclos` (`IdCiclo`),
  CONSTRAINT `FKj82v8q3xp6mm3vcxxx9j8324q` FOREIGN KEY (`IdModulo`) REFERENCES `modulos` (`IdModulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciclosmodulos`
--

LOCK TABLES `ciclosmodulos` WRITE;
/*!40000 ALTER TABLE `ciclosmodulos` DISABLE KEYS */;
INSERT INTO `ciclosmodulos` VALUES ('ADG1-10',1),('ADG1-10',2),('ADG1-10',3),('ADG1-10',4),('ADG1-10',5),('ADG1-10',6),('ADG1-10',7),('ADG1-10',8),('ADG1-10',9),('ADG1-10',10),('ADG1-10',11),('ADG1-10',12),('ADG1-10',13),('ADG2-1',14),('ADG2-1',15),('ADG2-1',16),('ADG2-1',17),('ADG2-1',18),('ADG2-1',19),('ADG2-1',20),('ADG2-1',21),('ADG2-1',22),('ADG2-1',23),('ADG2-1',24),('ADG2-1',25),('ADG2-1',26),('ADG3-1',15),('ADG3-1',26),('ADG3-1',27),('ADG3-1',28),('ADG3-1',29),('ADG3-1',30),('ADG3-1',31),('ADG3-1',32),('ADG3-1',33),('ADG3-1',34),('ADG3-1',35),('ADG3-1',36),('ADG3-1',37),('ADG3-1',38),('ADG3-2',15),('ADG3-2',26),('ADG3-2',27),('ADG3-2',28),('ADG3-2',29),('ADG3-2',30),('ADG3-2',31),('ADG3-2',32),('ADG3-2',37),('ADG3-2',39),('ADG3-2',40),('ADG3-2',41),('ADG3-2',42),('COM2-1',15),('COM2-1',26),('COM2-1',43),('COM2-1',44),('COM2-1',45),('COM2-1',46),('COM2-1',47),('COM2-1',48),('COM2-1',49),('COM2-1',50),('COM2-1',51),('COM2-1',52),('COM2-1',53),('COM2-1',54),('COM3-1',15),('COM3-1',26),('COM3-1',29),('COM3-1',37),('COM3-1',55),('COM3-1',56),('COM3-1',57),('COM3-1',58),('COM3-1',59),('COM3-1',60),('COM3-1',61),('COM3-1',62),('COM3-1',63),('COM3-1',64),('COM3-1',65),('IFC3-1',15),('IFC3-1',26),('IFC3-1',37),('IFC3-1',66),('IFC3-1',67),('IFC3-1',68),('IFC3-1',69),('IFC3-1',70),('IFC3-1',71),('IFC3-1',72),('IFC3-1',73),('IFC3-1',74),('IFC3-1',75),('IFC3-1',76),('IFC3-3',15),('IFC3-3',26),('IFC3-3',37),('IFC3-3',73),('IFC3-3',77),('IFC3-3',78),('IFC3-3',79),('IFC3-3',80),('IFC3-3',81),('IFC3-3',82),('IFC3-3',83),('IFC3-3',84),('IFC3-3',69);
/*!40000 ALTER TABLE `ciclosmodulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familias`
--

DROP TABLE IF EXISTS `familias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `familias` (
  `IdFamilia` char(3) COLLATE utf8_spanish_ci NOT NULL,
  `Denominacion` varchar(60) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdFamilia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familias`
--

LOCK TABLES `familias` WRITE;
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
INSERT INTO `familias` VALUES ('ADG','Administración y Gestión'),('COM','Comercio y Márketing'),('IFC','Informática y Comunicaciones');
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (11);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulos`
--

DROP TABLE IF EXISTS `modulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulos` (
  `IdModulo` smallint(6) NOT NULL AUTO_INCREMENT,
  `Curso` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `Abreviatura` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `Denominacion` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `NumeroHoras` smallint(6) NOT NULL,
  PRIMARY KEY (`IdModulo`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulos`
--

LOCK TABLES `modulos` WRITE;
/*!40000 ALTER TABLE `modulos` DISABLE KEYS */;
INSERT INTO `modulos` VALUES (1,'1','APLIC','Aplicaciones básicas de ofimática',204),(2,'1','TECNI','Técnicas administrativas básicas',238),(3,'1','ARCHI','Archivo y comunicación',136),(4,'1','CCAP1','Ciencias Aplicadas I',170),(5,'1','LCCS1','Lengua castellana y ciencias sociales I',170),(6,'1','IEX1','Idioma extranjero I',68),(7,'2','TRATA','Tratamiento informático de datos',270),(8,'2','ATENC','Atención al cliente',120),(9,'2','PREPA','Preparación de pedidos y venta de productos',120),(10,'2','CCAP2','Ciencias Aplicadas II',150),(11,'2','LCCS2','Lengua castellana y ciencias sociales II',150),(12,'2','IEX2','Idioma extranjero II',60),(13,'2','FCT','Formación en centros de trabajo',130),(14,'1','CEAC','Comunicación empresarial y atención al cliente',192),(15,'1','FOL','Formación y orientación laboral',96),(16,'1','INGI','Inglés I',64),(17,'1','OACV','Operaciones adminstrativas de compra-venta',192),(18,'1','TEC','Técnica contable',128),(19,'1','TII','Tratamiento informático de la información',288),(20,'2','EMEAU','Empresa en el aula',120),(21,'2','EMYAD','Empresa y adminstración',100),(22,'2','INGII','Inglés II',60),(23,'2','OADRH','Operaciones adminstrativas de recursos humanos',120),(24,'2','OADGT','Operaciones auxiliares de gestión de tesorería',140),(25,'2','TRDCO','Tratamiento de la documentación contable',80),(26,'2','FCT','Formación en centros de trabajo',400),(27,'1','CYAC','Comunicación y atención al cliente',128),(28,'1','GDJE','Gestión de la documentación jurídica y empresarial',96),(29,'1','ING','Inglés',128),(30,'1','OYPI','Ofimática y proceso de la información',256),(31,'1','PIAC','Proceso integral de la actividad comercial',192),(32,'1','RHRSC','Recursos humanos y responsabilidad social corporativa',64),(33,'2','CFI','Contabilidad y fiscalidad',160),(34,'2','GRH','Gestión de recursos humanos',60),(35,'2','GFI','Gestión financiera',160),(36,'2','GESTI','Gestión logística y comercial',100),(37,'2','PROFC','Proyecto',40),(38,'2','SIMUL','Simulación empresarial',120),(39,'2','GAI','Gestión avanzada de la información',140),(40,'2','OEE','Organización de eventos empresariales',180),(41,'2','PROTO','Protocolo empresarial',160),(42,'2','SLE','Segunda lengua extranjera',120),(43,'1','AIC','Aplicaciones informáticas para el comercio',160),(44,'1','DPV','Dinamización del punto de venta',192),(45,'1','GECO','Gestión de compras',96),(46,'1','ING','Inglés',96),(47,'1','MAC','Márqueting en la actividad comercial',160),(48,'1','PRV','Procesos de venta',160),(49,'2','COMER','Comercio electrónico',80),(50,'2','GESTI','Gestión de un pequeño comercio',160),(51,'2','ING','Inglés',40),(52,'2','SAC','Servicios de atención comercial',80),(53,'2','TECNI','Técnicas de almacén',120),(54,'2','VENTA','Venta técnica',120),(55,'1','GCI','Gestión administrativa del comercio internacional',224),(56,'1','GEFE','Gestión económica y financiera de la empresa',192),(57,'1','LOGIS','Logística de almacenamiento',128),(58,'1','TIM','Transporte internacional de mercancías',192),(59,'2','CDI','Comercio digital internacional',60),(60,'2','EII','Ex. Inglés I',40),(61,'2','FI','Financiación internacional',120),(62,'2','MI','Márketing internacional',140),(63,'2','MPI','Métodos de pago internacionales',80),(64,'2','NI','Negociación internacional',80),(65,'2','SIM','Sistema de información de mercados',80),(66,'1','FHW','Fundamentos del hardware',96),(67,'1','GBD','Gestión de bases de datos',192),(68,'1','ISO','Implementación de sistemas operativos',224),(69,'1','LMSGI','Lenguajes de marcas y sistemas de gestión de información',128),(70,'1','PARE','Planificación y administración de redes',224),(71,'2','ASGBD','Administración de sistemas gestores de bases de datos',80),(72,'2','ASSOO','Administración de sistemas operativos',160),(73,'2','EMINI','Empresa e iniciativa emprendedora',60),(74,'2','IAPLW','Implantación de aplicaciones web',100),(75,'2','SGALD','Seguridad y alta disponibilidad',80),(76,'2','SREIN','Servicios de red e Internet',120),(77,'1','BBDD','Bases de datos',192),(78,'1','ENTDL','Entornos de desarrollo',128),(79,'1','PGRMC','Programación',224),(80,'1','SSINF','Sistemas informáticos',192),(81,'2','DWENC','Desarrollo web en entorno cliente',140),(82,'2','DWESV','Desarrollo web en entorno servidor',160),(83,'2','DEAPW','Despliegue de aplicaciones web',100),(84,'2','DINW','Diseño de interfaces web',140);
/*!40000 ALTER TABLE `modulos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-11 20:55:18
