-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: coder
-- ------------------------------------------------------
-- Server version	8.0.41

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
-- Table structure for table `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `dni` int NOT NULL,
  `edad` int DEFAULT NULL,
  `legajo` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKf2c9i14wnebiikl4lldh5yam2` (`dni`),
  UNIQUE KEY `UK2g5igfhgo95lofjvx3jufwrad` (`legajo`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos`
--

LOCK TABLES `alumnos` WRITE;
/*!40000 ALTER TABLE `alumnos` DISABLE KEYS */;
INSERT INTO `alumnos` VALUES (1,'Di Stefano',NULL,22333666,49,'L22333666','Alejandro'),(2,'Montero',NULL,33555888,30,'L33555888','Luciano'),(3,'Correia',NULL,44222333,29,'L44222333','Guillermo '),(4,'Trillini',NULL,25666333,28,'L25666333','Juan'),(5,'Perez',NULL,44666777,32,'L44666777','Tomas'),(8,'Di Iorio',NULL,2323233,40,'L2323233','Federico'),(10,'Bincaz',NULL,23232338,40,'L23232338','Lorena '),(11,'Di Stefano',NULL,2323234,16,'L2323243','Federico');
/*!40000 ALTER TABLE `alumnos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-08 19:26:11
