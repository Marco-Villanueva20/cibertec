CREATE DATABASE  IF NOT EXISTS `bd_empresa` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_empresa`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_empresa
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `tb_distrito`
--

DROP TABLE IF EXISTS `tb_distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_distrito` (
  `id_distrito` int NOT NULL AUTO_INCREMENT,
  `distrito` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_distrito`
--

LOCK TABLES `tb_distrito` WRITE;
/*!40000 ALTER TABLE `tb_distrito` DISABLE KEYS */;
INSERT INTO `tb_distrito` VALUES (1,'Carabayllo'),(2,'Puente Piedra'),(3,'Zapallal');
/*!40000 ALTER TABLE `tb_distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_empleado`
--

DROP TABLE IF EXISTS `tb_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_empleado` (
  `codigo` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `dni` int DEFAULT NULL,
  `nro_hijos` int DEFAULT NULL,
  `sueldo` double DEFAULT NULL,
  `id_distrito` int DEFAULT NULL,
  `estado` int DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_iddistrito_idx` (`id_distrito`),
  CONSTRAINT `fk_iddistrito` FOREIGN KEY (`id_distrito`) REFERENCES `tb_distrito` (`id_distrito`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_empleado`
--

LOCK TABLES `tb_empleado` WRITE;
/*!40000 ALTER TABLE `tb_empleado` DISABLE KEYS */;
INSERT INTO `tb_empleado` VALUES (1,'Marco','Villanueva',12345678,1,256,1,0),(2,'Jerson','Garcia',23456789,1,256,2,0),(3,'Kiuksam','Lopez',34567890,1,256,3,0);
/*!40000 ALTER TABLE `tb_empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_empresa'
--

--
-- Dumping routines for database 'bd_empresa'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 17:13:13
