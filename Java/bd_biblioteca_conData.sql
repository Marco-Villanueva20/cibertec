CREATE DATABASE  IF NOT EXISTS `bd_biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_biblioteca
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
-- Table structure for table `tb_editorial`
--

DROP TABLE IF EXISTS `tb_editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_editorial` (
  `id_editorial` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_editorial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_editorial`
--

LOCK TABLES `tb_editorial` WRITE;
/*!40000 ALTER TABLE `tb_editorial` DISABLE KEYS */;
INSERT INTO `tb_editorial` VALUES (1,'Santillana'),(2,'Arca de Papel');
/*!40000 ALTER TABLE `tb_editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_libros`
--

DROP TABLE IF EXISTS `tb_libros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_libros` (
  `id_libros` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(45) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `id_editorial` int DEFAULT NULL,
  PRIMARY KEY (`id_libros`),
  KEY `fk_ideditorial_idx` (`id_editorial`),
  CONSTRAINT `fk_ideditorial` FOREIGN KEY (`id_editorial`) REFERENCES `tb_editorial` (`id_editorial`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_libros`
--

LOCK TABLES `tb_libros` WRITE;
/*!40000 ALTER TABLE `tb_libros` DISABLE KEYS */;
INSERT INTO `tb_libros` VALUES (1,'Matemática 1',188,20,1),(2,'Manualidades 2',150,50,2);
/*!40000 ALTER TABLE `tb_libros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_biblioteca'
--

--
-- Dumping routines for database 'bd_biblioteca'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 16:31:16
