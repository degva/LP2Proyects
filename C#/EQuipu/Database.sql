-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: degvadb
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alumno` (
  `codigo` int(11) NOT NULL,
  `codigo_alumno` int(11) NOT NULL,
  `craest` float NOT NULL,
  KEY `codigo` (`codigo`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `miembro` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,20114297,60);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo`
--

DROP TABLE IF EXISTS `equipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `interes` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `fondo` float DEFAULT '0',
  `entradas` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo`
--

LOCK TABLES `equipo` WRITE;
/*!40000 ALTER TABLE `equipo` DISABLE KEYS */;
INSERT INTO `equipo` VALUES (2,'Nuevo','This shit','Tecnología',0,0),(3,'This is a new thing','sdfsdfg','Manualidades',0,0),(4,'cxb','sdf','Servicio Social',0,0),(5,'sdfg','sdfg','Servicio Social',0,0),(6,'sdfgsdfg','sdfgsdfg','Educación',0,0),(7,'hjkghj','sdfgsdg','Educación',0,0),(8,'ry','efgh','Educación',0,0),(9,'erh','erher','Servicio Social',0,0);
/*!40000 ALTER TABLE `equipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo_x_evento`
--

DROP TABLE IF EXISTS `equipo_x_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo_x_evento` (
  `evento_nombre` varchar(50) NOT NULL,
  `equipo_id` int(11) NOT NULL,
  PRIMARY KEY (`evento_nombre`,`equipo_id`),
  KEY `equipo_id` (`equipo_id`),
  CONSTRAINT `equipo_x_evento_ibfk_1` FOREIGN KEY (`evento_nombre`) REFERENCES `evento` (`nombre`),
  CONSTRAINT `equipo_x_evento_ibfk_2` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo_x_evento`
--

LOCK TABLES `equipo_x_evento` WRITE;
/*!40000 ALTER TABLE `equipo_x_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipo_x_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `equipo_x_miembro`
--

DROP TABLE IF EXISTS `equipo_x_miembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipo_x_miembro` (
  `equipo_id` int(11) NOT NULL,
  `miembro_id` int(11) NOT NULL,
  PRIMARY KEY (`equipo_id`,`miembro_id`),
  KEY `miembro_id` (`miembro_id`),
  CONSTRAINT `equipo_x_miembro_ibfk_1` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`),
  CONSTRAINT `equipo_x_miembro_ibfk_2` FOREIGN KEY (`miembro_id`) REFERENCES `miembro` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipo_x_miembro`
--

LOCK TABLES `equipo_x_miembro` WRITE;
/*!40000 ALTER TABLE `equipo_x_miembro` DISABLE KEYS */;
INSERT INTO `equipo_x_miembro` VALUES (2,1),(3,3);
/*!40000 ALTER TABLE `equipo_x_miembro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `nombre` varchar(50) NOT NULL,
  `categoria` varchar(50) NOT NULL,
  `num_entradas` int(11) NOT NULL,
  `precio_entrada` double NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES ('sdfg','Educación',3,22);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exposicion`
--

DROP TABLE IF EXISTS `exposicion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exposicion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equipo_id` int(11) NOT NULL,
  `fecha_participacion` varchar(50) NOT NULL,
  `hora_participacion` int(11) NOT NULL,
  `lugar_participacion` varchar(50) NOT NULL,
  `cantidad_asistentes` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `equipo_id` (`equipo_id`),
  CONSTRAINT `exposicion_ibfk_1` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicion`
--

LOCK TABLES `exposicion` WRITE;
/*!40000 ALTER TABLE `exposicion` DISABLE KEYS */;
/*!40000 ALTER TABLE `exposicion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exposicion_x_evento`
--

DROP TABLE IF EXISTS `exposicion_x_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exposicion_x_evento` (
  `evento_nombre` varchar(50) NOT NULL,
  `exposicion_id` int(11) NOT NULL,
  PRIMARY KEY (`evento_nombre`,`exposicion_id`),
  KEY `exposicion_id` (`exposicion_id`),
  CONSTRAINT `exposicion_x_evento_ibfk_1` FOREIGN KEY (`evento_nombre`) REFERENCES `evento` (`nombre`),
  CONSTRAINT `exposicion_x_evento_ibfk_2` FOREIGN KEY (`exposicion_id`) REFERENCES `exposicion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exposicion_x_evento`
--

LOCK TABLES `exposicion_x_evento` WRITE;
/*!40000 ALTER TABLE `exposicion_x_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `exposicion_x_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `externo`
--

DROP TABLE IF EXISTS `externo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `externo` (
  `codigo` int(11) NOT NULL,
  `dedicacion` varchar(15) NOT NULL,
  KEY `codigo` (`codigo`),
  CONSTRAINT `externo_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `miembro` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `externo`
--

LOCK TABLES `externo` WRITE;
/*!40000 ALTER TABLE `externo` DISABLE KEYS */;
/*!40000 ALTER TABLE `externo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feria`
--

DROP TABLE IF EXISTS `feria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feria` (
  `nombre` varchar(50) NOT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feria`
--

LOCK TABLES `feria` WRITE;
/*!40000 ALTER TABLE `feria` DISABLE KEYS */;
INSERT INTO `feria` VALUES ('feria','12/5/2016 2:35:59 AM');
/*!40000 ALTER TABLE `feria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feria_x_equipos`
--

DROP TABLE IF EXISTS `feria_x_equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feria_x_equipos` (
  `nombre_feria` varchar(50) NOT NULL,
  `equipo_id` int(11) NOT NULL,
  PRIMARY KEY (`nombre_feria`,`equipo_id`),
  KEY `equipo_id` (`equipo_id`),
  CONSTRAINT `feria_x_equipos_ibfk_1` FOREIGN KEY (`nombre_feria`) REFERENCES `feria` (`nombre`),
  CONSTRAINT `feria_x_equipos_ibfk_2` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feria_x_equipos`
--

LOCK TABLES `feria_x_equipos` WRITE;
/*!40000 ALTER TABLE `feria_x_equipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `feria_x_equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `miembro`
--

DROP TABLE IF EXISTS `miembro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `miembro` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(15) DEFAULT NULL,
  `fechaNacimiento` varchar(11) DEFAULT NULL,
  `direccion` varchar(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `miembro`
--

LOCK TABLES `miembro` WRITE;
/*!40000 ALTER TABLE `miembro` DISABLE KEYS */;
INSERT INTO `miembro` VALUES (1,'Diego','12/4/2016','chorillo','degva','M'),(3,'ui','12/4/2016','nisdd','lskjdfg','M');
/*!40000 ALTER TABLE `miembro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesor` (
  `codigo` int(11) NOT NULL,
  `codigo_prof` int(11) NOT NULL,
  `estado` varchar(25) NOT NULL,
  KEY `codigo` (`codigo`),
  CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`codigo`) REFERENCES `miembro` (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (3,1234,'dsf');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(15) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'degva','123');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-05  2:41:34
