CREATE DATABASE IF NOT EXISTS `bd_memoradum` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bd_memoradum`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_memoradum
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
-- Table structure for table `tb_areas`
--

DROP TABLE IF EXISTS `tb_areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_areas` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `desc_area` varchar(45) NOT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `desc_area_UNIQUE` (`desc_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_areas`
--

LOCK TABLES `tb_areas` WRITE;
/*!40000 ALTER TABLE `tb_areas` DISABLE KEYS */;
INSERT INTO `tb_areas` VALUES (2,'O. Solicitante'),(1,'OGA'),(3,'RRHH');
/*!40000 ALTER TABLE `tb_areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bol_venta`
--

DROP TABLE IF EXISTS `tb_bol_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_bol_venta` (
  `id_bol_venta` char(6) NOT NULL,
  `id_vendedor` varchar(45) NOT NULL,
  `id_cliente` varchar(45) NOT NULL,
  `fecha_venta` date NOT NULL,
  `monto_total` decimal(8,2) NOT NULL,
  PRIMARY KEY (`id_bol_venta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bol_venta`
--

LOCK TABLES `tb_bol_venta` WRITE;
/*!40000 ALTER TABLE `tb_bol_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_bol_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_cargos`
--

DROP TABLE IF EXISTS `tb_cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_cargos` (
  `id_cargo` int NOT NULL AUTO_INCREMENT,
  `desc_cargo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cargo`),
  UNIQUE KEY `desc_cargo_UNIQUE` (`desc_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_cargos`
--

LOCK TABLES `tb_cargos` WRITE;
/*!40000 ALTER TABLE `tb_cargos` DISABLE KEYS */;
INSERT INTO `tb_cargos` VALUES (3,'Analista'),(2,'Jefe'),(1,'Superintendente'),(4,'Técnico Administrativo');
/*!40000 ALTER TABLE `tb_cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado`
--

DROP TABLE IF EXISTS `tb_estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado` (
  `id_estado` int NOT NULL AUTO_INCREMENT,
  `desc_estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE KEY `desc_estado_UNIQUE` (`desc_estado`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado`
--

LOCK TABLES `tb_estado` WRITE;
/*!40000 ALTER TABLE `tb_estado` DISABLE KEYS */;
INSERT INTO `tb_estado` VALUES (3,'Aprobado'),(5,'Asignado'),(6,'Finalizado'),(1,'Pendiente'),(4,'Rechazado'),(2,'Revisado');
/*!40000 ALTER TABLE `tb_estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_estado_memo`
--

DROP TABLE IF EXISTS `tb_estado_memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_estado_memo` (
  `id_memo` int NOT NULL,
  `id_estado` int NOT NULL,
  `id_encargado_revision` int NOT NULL,
  `fecha_registro` date NOT NULL,
  `hora_registrada` time NOT NULL,
  `observacion` varchar(500) NOT NULL DEFAULT 'Ninguna',
  `orden_estado` int NOT NULL,
  PRIMARY KEY (`id_memo`,`id_estado`,`id_encargado_revision`),
  KEY `fk_idestado_idx` (`id_estado`),
  KEY `fk_usuario_idx` (`id_encargado_revision`),
  CONSTRAINT `fk_idestado` FOREIGN KEY (`id_estado`) REFERENCES `tb_estado` (`id_estado`),
  CONSTRAINT `fk_idmemo` FOREIGN KEY (`id_memo`) REFERENCES `tb_memo` (`cod_memo`),
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`id_encargado_revision`) REFERENCES `tb_usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_estado_memo`
--

LOCK TABLES `tb_estado_memo` WRITE;
/*!40000 ALTER TABLE `tb_estado_memo` DISABLE KEYS */;
INSERT INTO `tb_estado_memo` VALUES (1,1,1,'2023-04-16','08:36:50','Ninguna',1),(1,1,5,'2023-04-16','09:09:53','Por favor revise bien el documento.',3),(1,2,1,'2023-04-16','09:09:53','Se reviso encontrando todo conforme',2),(1,2,5,'2023-04-16','09:19:13','Se procede a asignar el trabajo para la difusion del mensaje',4),(1,5,6,'2023-04-16','09:19:13','Procede lo mas pronto posible',5),(1,6,6,'2023-04-16','09:26:34','Se procedio con el trabajo y termino todo correctamente',6),(2,1,5,'2023-04-16','08:40:22','Ninguna',1),(2,2,5,'2023-04-16','10:14:49','Ninguna',2),(2,5,7,'2023-04-16','10:14:49','Ninguna',3),(2,6,7,'2023-04-16','10:16:27','Ninguna',4),(3,1,1,'2023-04-16','08:41:42','Ninguna',1),(4,1,5,'2023-04-16','08:42:55','Ninguna',1),(5,1,5,'2023-04-16','08:54:18','Ninguna',1),(6,1,1,'2023-04-21','07:58:47','Ninguna',1);
/*!40000 ALTER TABLE `tb_estado_memo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_memo`
--

DROP TABLE IF EXISTS `tb_memo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_memo` (
  `cod_memo` int NOT NULL,
  `usuario_emisor` int NOT NULL,
  `usuario_receptor` int NOT NULL,
  `fecha` varchar(15) NOT NULL,
  `descripcion` varchar(900) NOT NULL,
  `asunto` varchar(200) NOT NULL,
  PRIMARY KEY (`cod_memo`),
  KEY `fk_tb_usuario_emi_idx` (`usuario_emisor`),
  KEY `fk_tbusuario_rece_idx` (`usuario_receptor`),
  CONSTRAINT `fk_tbusuario_emi` FOREIGN KEY (`usuario_emisor`) REFERENCES `tb_usuarios` (`id_usuario`),
  CONSTRAINT `fk_tbusuario_rece` FOREIGN KEY (`usuario_receptor`) REFERENCES `tb_usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_memo`
--

LOCK TABLES `tb_memo` WRITE;
/*!40000 ALTER TABLE `tb_memo` DISABLE KEYS */;
INSERT INTO `tb_memo` VALUES (1,2,1,'2023-04-16','Les escribo para informarles que se llevará a cabo una reunión de equipo el próximo viernes 23 de abril a las 2:00 p.m. en la sala de conferencias del tercer piso.\n\nEl objetivo de la reunión es discutir los avances en el proyecto actual y planificar las tareas a realizar durante el próximo mes. También se abordarán otros temas importantes para el equipo.\n\nEs importante que asistan todos los miembros del equipo, por lo que se les solicita su puntualidad. Si por algún motivo no pueden asistir, por favor comuníquense conmigo con anticipación para coordinar una fecha alternativa.','Anuncio de reunión'),(2,2,5,'2023-04-16','Les escribo para recordarles que la fecha límite para presentar el informe trimestral es el próximo viernes 30 de abril. Por favor, asegúrense de enviar el informe completo y en el formato requerido antes de la fecha límite.\n\nLes recuerdo que este informe es de vital importancia para la evaluación del desempeño de la empresa y de cada uno de ustedes. Por lo tanto, es crucial que se entregue a tiempo y con la calidad necesaria.\n\nSi tienen alguna pregunta o necesitan ayuda para completar el informe, no duden en comunicarse conmigo o con el departamento de Recursos Humanos.','Recordatorio de fecha límite para presentar informe'),(3,2,1,'2023-04-16','Les escribo para solicitar su colaboración en la presentación de un informe de ventas. Como saben, este informe es de vital importancia para el departamento de ventas y para la empresa en general.\n\nLes pido que proporcionen la información solicitada a más tardar el próximo viernes 23 de abril. Por favor, asegúrense de que los datos sean precisos y estén completos para garantizar que el informe sea confiable.','Solicitud de presentación de informe de ventas'),(4,2,5,'2023-04-16','Les escribo para solicitar su asistencia al próximo curso de capacitación que se llevará a cabo el jueves 25 de abril. Este curso es de suma importancia para el desarrollo de sus habilidades y conocimientos en el área laboral.\n\nLes pido que confirmen su asistencia antes del próximo lunes 22 de abril, para poder garantizar la disponibilidad de los recursos necesarios para el curso.','Solicitud de asistencia al curso de capacitación'),(5,2,5,'2023-04-16','Les informo que el proyecto de expansión de la empresa SMV se encuentra en la fase de diseño y planificación. Se ha creado un equipo de trabajo especializado en cada una de las áreas del proyecto y estamos trabajando en la elaboración de los planes de acción detallados y la definición de los recursos necesarios para llevar a cabo el proyecto con éxito.\n\nAgradezco a todos los empleados que han participado activamente en el proyecto y los mantendré informados sobre el progreso del mismo en futuros memorandos.','Informe de seguimiento del proyecto de expansión'),(6,2,1,'2023-04-21','Seleccion de Practicantes para el dia 18 de junio, se requiere 20 practicantes','Seleccion de practicantes');
/*!40000 ALTER TABLE `tb_memo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_usuarios`
--

DROP TABLE IF EXISTS `tb_usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `fech_nac` date NOT NULL,
  `cargo` int NOT NULL,
  `area` int NOT NULL,
  `usuario` char(5) NOT NULL,
  `clave` varchar(10) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `cargo_fk_idx` (`cargo`),
  KEY `area_fk_idx` (`area`),
  CONSTRAINT `area_fk` FOREIGN KEY (`area`) REFERENCES `tb_areas` (`id_area`),
  CONSTRAINT `cargo_fk` FOREIGN KEY (`cargo`) REFERENCES `tb_cargos` (`id_cargo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_usuarios`
--

LOCK TABLES `tb_usuarios` WRITE;
/*!40000 ALTER TABLE `tb_usuarios` DISABLE KEYS */;
INSERT INTO `tb_usuarios` VALUES (1,'Paola','Mori Yovera','2003-03-12',1,1,'U0002','123'),(2,'Jerson','Garcia Ramirez','2001-09-10',2,2,'U0001','123'),(5,'Ivan','Lopez Daza','2000-05-16',2,3,'U0003','123'),(6,'Juan','Estrada Ramirez','2001-09-10',3,3,'U0004','123'),(7,'Rosa','Espinoza Estrada','2001-04-12',4,3,'U0006','123'),(8,'Juan','Zambrana Escobar','2001-04-04',3,2,'U0005','123');
/*!40000 ALTER TABLE `tb_usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bd_memoradum'
--

--
-- Dumping routines for database 'bd_memoradum'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarEstadoxNombre` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarEstadoxNombre`(nom_estado varchar(45))
begin
select * from tb_estado te where te.desc_estado LIKE concat('%',nom_estado,'%')
order by te.id_estado ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_BuscarMemo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_BuscarMemo`(cod INT)
begin
select 
tm.cod_memo,
concat(useremi.nombre," ",useremi.apellidos) as 'Enviado por' ,
concat(emicargo.desc_cargo," ",emiarea.desc_area) as "Cargo y Área",
concat(userrecep.nombre," ",userrecep.apellidos) as 'Dirigido a' ,
concat(reccargo.desc_cargo," ",recarea.desc_area) as "Cargo y Área",
tm.fecha,
tm.asunto, 
tm.descripcion from tb_memo tm 
-- nombres
inner join tb_usuarios useremi on tm.usuario_emisor = useremi.id_usuario 
inner join tb_usuarios userrecep on userrecep.id_usuario = tm.usuario_receptor
-- descripcion de cargos
inner join tb_cargos emicargo on useremi.cargo = emicargo.id_cargo
inner join tb_cargos reccargo on userrecep.cargo = reccargo.id_cargo
-- descripcion de areas
inner join tb_areas emiarea on useremi.area =  emiarea.id_area
inner join tb_areas recarea on userrecep.area =  recarea.id_area
where tm.cod_memo = cod;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarMemox5Parametros` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarMemox5Parametros`(emisor int,cod int,nombre varchar (90),asunto varchar(45),
fecha VARCHAR(10))
BEGIN
SELECT tm.cod_memo,
concat(e.nombre, " ", e.apellidos) AS 'Remitente',
concat(r.nombre, " ", r.apellidos) AS 'Receptor',
tm.asunto,
tm.fecha 
FROM tb_memo tm
INNER JOIN tb_usuarios e ON tm.usuario_emisor = e.id_usuario
INNER JOIN tb_usuarios r ON tm.usuario_receptor = r.id_usuario
WHERE 
	tm.usuario_emisor = emisor
	AND(cod IS NULL OR tm.cod_memo LIKE CONCAT('%',cod, '%'))
	AND(nombre IS NULL OR CONCAT(r.nombre, " ", r.apellidos) LIKE CONCAT('%', nombre, '%'))
	AND (asunto IS NULL OR tm.asunto LIKE CONCAT('%', asunto, '%'))
    AND (fecha IS NULL OR tm.fecha LIKE CONCAT('%', fecha, '%'))
    ORDER BY tm.cod_memo DESC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_BuscarMemoxCod` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_BuscarMemoxCod`(cod INT)
begin
select 
tm.cod_memo,
concat(useremi.nombre," ",useremi.apellidos) as 'Enviado por' ,
concat(emicargo.desc_cargo," ",emiarea.desc_area) as "Cargo y Área",
concat(userrecep.nombre," ",userrecep.apellidos) as 'Dirigido a' ,
concat(reccargo.desc_cargo," ",recarea.desc_area) as "Cargo y Área",
tm.fecha,
tm.asunto, 
tm.descripcion from tb_memo tm 
-- nombres
inner join tb_usuarios useremi on tm.usuario_emisor = useremi.id_usuario 
inner join tb_usuarios userrecep on userrecep.id_usuario = tm.usuario_receptor
-- descripcion de cargos
inner join tb_cargos emicargo on useremi.cargo = emicargo.id_cargo
inner join tb_cargos reccargo on userrecep.cargo = reccargo.id_cargo
-- descripcion de areas
inner join tb_areas emiarea on useremi.area =  emiarea.id_area
inner join tb_areas recarea on userrecep.area =  recarea.id_area
where tm.cod_memo = cod;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarMemoxCodxNomxAsunto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarMemoxCodxNomxAsunto`(emisor int,cod int,nombre varchar (90),asunto varchar(45),
fecha VARCHAR(10))
BEGIN
SELECT tm.cod_memo,
concat(e.nombre, " ", e.apellidos) AS 'Remitente',
concat(r.nombre, " ", r.apellidos) AS 'Receptor',
tm.asunto,
tm.fecha 
FROM tb_memo tm
INNER JOIN tb_usuarios e ON tm.usuario_emisor = e.id_usuario
INNER JOIN tb_usuarios r ON tm.usuario_receptor = r.id_usuario
WHERE 
	tm.usuario_emisor = emisor
	AND(cod IS NULL OR tm.cod_memo LIKE CONCAT('%',cod, '%'))
	AND(nombre IS NULL OR CONCAT(r.nombre, " ", r.apellidos) LIKE CONCAT('%', nombre, '%'))
	AND (asunto IS NULL OR tm.asunto LIKE CONCAT('%', asunto, '%'))
    AND (fecha IS NULL OR tm.fecha LIKE CONCAT('%', fecha, '%'))
    ORDER BY tm.cod_memo DESC;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarUsuario`(nombre varchar(45),apellido varchar(45),area varchar(45))
begin
SELECT tu.id_usuario, tu.nombre, tu.apellidos, tu.fech_nac, tc.desc_cargo, ta.desc_area, tu.usuario, tu.clave
FROM tb_usuarios tu 
INNER JOIN tb_cargos tc ON tu.cargo = tc.id_cargo 
INNER JOIN tb_areas ta ON tu.area = ta.id_area
WHERE (nombre IS NULL OR tu.nombre LIKE CONCAT('%',usuario, '%'))
 AND (apellido IS NULL OR tu.apellidos LIKE CONCAT('%',usuario, '%'))
 AND (area IS NULL OR ta.dec_area LIKE CONCAT('%',area,'%'))
ORDER BY tu.id_usuario ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_buscarUsuarioxNomxApexArea` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_buscarUsuarioxNomxApexArea`(nombre varchar(45),apellido varchar(45),area varchar(45))
begin
SELECT tu.id_usuario, tu.nombre, tu.apellidos, tu.fech_nac, tc.desc_cargo, ta.desc_area, tu.usuario, tu.clave
FROM tb_usuarios tu 
INNER JOIN tb_cargos tc ON tu.cargo = tc.id_cargo 
INNER JOIN tb_areas ta ON tu.area = ta.id_area
WHERE (nombre IS NULL OR tu.nombre LIKE CONCAT('%',nombre, '%'))
 AND (apellido IS NULL OR tu.apellidos LIKE CONCAT('%',apellido, '%'))
 AND (area IS NULL OR ta.desc_area LIKE CONCAT('%',area,'%'))
ORDER BY tu.id_usuario ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_estadoMemo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_estadoMemo`(id int)
begin
select estmemo.id_memo,e.desc_estado,concat(u.nombre," ",u.apellidos)as 'encargado de revisar', estmemo.fecha_registro,
estmemo.hora_registrada,
estmemo.observacion
from tb_estado_memo estmemo
inner join tb_usuarios u on estmemo.id_encargado_revision = u.id_usuario
inner join tb_estado e on estmemo.id_estado = e.id_estado
where estmemo.id_encargado_revision = id
ORDER BY estmemo.fecha_registro ASC,estmemo.hora_registrada ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_EstadoMemoxIdMemo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_EstadoMemoxIdMemo`(codMemo int)
BEGIN
SELECT estmemo.id_memo,
       e.desc_estado,
       CONCAT(u.nombre," ",u.apellidos) AS 'encargado de revisar',
       estmemo.fecha_registro,
       estmemo.hora_registrada,
       estmemo.observacion
FROM tb_estado_memo estmemo
INNER JOIN tb_usuarios u ON estmemo.id_encargado_revision = u.id_usuario
INNER JOIN tb_estado e ON estmemo.id_estado = e.id_estado
WHERE estmemo.id_memo = codMemo
ORDER BY estmemo.orden_estado asc;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_estadoMemoxReceptor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_estadoMemoxReceptor`(id int)
begin
select estmemo.id_memo,e.desc_estado,concat(u.nombre," ",u.apellidos)as 'encargado de revisar', estmemo.fecha_registro,
estmemo.hora_registrada,
estmemo.observacion
from tb_estado_memo estmemo
inner join tb_usuarios u on estmemo.id_encargado_revision = u.id_usuario
inner join tb_estado e on estmemo.id_estado = e.id_estado
where estmemo.id_encargado_revision = id
ORDER BY estmemo.id_memo DESC,estmemo.hora_registrada DESC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_listarUsuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_listarUsuario`()
begin
select tu.id_usuario,tu.nombre,tu.apellidos,
tu.fech_nac,tc.desc_cargo,ta.desc_area,tu.usuario,tu.clave from tb_usuarios tu 
inner join tb_cargos tc on tu.cargo=tc.id_cargo 
inner join tb_areas ta on tu.area=ta.id_area
order by tu.id_usuario asc;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_Listar_Memo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_Listar_Memo`()
begin
SELECT tm.cod_memo,
concat(e.nombre, " ", e.apellidos) AS 'Remitente',
concat(r.nombre, " ", r.apellidos) AS 'Receptor',
tm.asunto,
tm.fecha 
FROM tb_memo tm
INNER JOIN tb_usuarios e ON tm.usuario_emisor = e.id_usuario
INNER JOIN tb_usuarios r ON tm.usuario_receptor = r.id_usuario
ORDER BY tm.cod_memo DESC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_Listar_MemoxEmisor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_Listar_MemoxEmisor`(cod int)
begin
SELECT tm.cod_memo,
concat(e.nombre, " ", e.apellidos) AS 'Remitente',
concat(r.nombre, " ", r.apellidos) AS 'Receptor',
tm.asunto,
tm.fecha 
FROM tb_memo tm
INNER JOIN tb_usuarios e ON tm.usuario_emisor = e.id_usuario
INNER JOIN tb_usuarios r ON tm.usuario_receptor = r.id_usuario
Where tm.usuario_emisor = cod
ORDER BY tm.cod_memo DESC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_memorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_memorandum`()
begin
select tm.cod_memo,tm.fecha,tm.descripcion,tm.asunto,te.desc_estado,tu.nombre,tu.apellidos,ta.desc_area,tc.desc_cargo
from tb_memo tm
inner join tb_areas ta on tm.area_destino = ta.id_area 
inner join tb_estado te on tm.estado = te.id_estado 
inner join tb_cargos tc on tm.cargo_destino = tc.id_cargo 
inner join tb_usuarios tu on tm.usuario_emisor = tu.id_usuario
ORDER BY cod_memo ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_reporteMemos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_reporteMemos`()
BEGIN
SELECT
	m.cod_memo, 
    ae.desc_area as 'remitente',
    ar.desc_area as 'destinatario',
    m.fecha, 
    m.asunto 
    FROM tb_memo m
    INNER JOIN tb_usuarios e ON m.usuario_emisor = e.id_usuario
    INNER JOIN tb_usuarios r ON m.usuario_receptor = r.id_usuario
    INNER JOIN tb_areas ae ON e.cargo = ae.id_area
    INNER JOIN tb_areas ar ON r.cargo = ar.id_area
    ORDER BY m.cod_memo ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_reporteMemosxFecha` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_reporteMemosxFecha`(fecha DATE)
BEGIN
SELECT
	m.cod_memo, 
    ae.desc_area as 'remitente',
    ar.desc_area as 'destinatario',
    m.fecha, 
    m.asunto 
    FROM tb_memo m
    INNER JOIN tb_usuarios e ON m.usuario_emisor = e.id_usuario
    INNER JOIN tb_usuarios r ON m.usuario_receptor = r.id_usuario
    INNER JOIN tb_areas ae ON e.cargo = ae.id_area
    INNER JOIN tb_areas ar ON r.cargo = ar.id_area
    WHERE  m.fecha = fecha
    ORDER BY m.cod_memo ASC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_reporte_memorandum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_reporte_memorandum`()
begin
select tm.cod_memo,tm.fecha,tm.descripcion,tm.asunto,te.desc_estado,tu.nombre,tu.apellidos,ta.desc_area,tc.desc_cargo
from tb_memo tm
inner join tb_areas ta on tm.area_destino = ta.id_area 
inner join tb_estado te on tm.estado = te.id_estado 
inner join tb_cargos tc on tm.cargo_destino = tc.id_cargo 
inner join tb_usuarios tu on tm.usuario_emisor = tu.id_usuario
ORDER BY cod_memo ASC;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usuarioXid` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usuarioXid`(cod int)
BEGIN
SELECT tu.id_usuario, tu.nombre, tu.apellidos, tu.fech_nac, tc.desc_cargo, ta.desc_area, tu.usuario, tu.clave
FROM tb_usuarios tu 
INNER JOIN tb_cargos tc ON tu.cargo = tc.id_cargo 
INNER JOIN tb_areas ta ON tu.area = ta.id_area
WHERE tu.id_usuario = cod;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-21  8:36:52
