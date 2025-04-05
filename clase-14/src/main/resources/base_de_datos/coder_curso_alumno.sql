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
-- Table structure for table `curso_alumno`
--

DROP TABLE IF EXISTS `curso_alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso_alumno` (
  `curso_id` bigint NOT NULL,
  `alumno_id` bigint NOT NULL,
  KEY `FKlo9nukmhox3g7spntr761iytl` (`alumno_id`),
  KEY `FKtgh467qpy8hymle733khllua` (`curso_id`),
  CONSTRAINT `FKlo9nukmhox3g7spntr761iytl` FOREIGN KEY (`alumno_id`) REFERENCES `alumnos` (`id`),
  CONSTRAINT `FKtgh467qpy8hymle733khllua` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso_alumno`
--

LOCK TABLES `curso_alumno` WRITE;
/*!40000 ALTER TABLE `curso_alumno` DISABLE KEYS */;
INSERT INTO `curso_alumno` VALUES (2,1),(2,3),(2,4),(5,1),(5,3),(5,4),(8,4),(3,1),(3,3),(3,4),(4,1),(4,3),(4,4),(1,1),(1,3),(1,4),(1,4);
/*!40000 ALTER TABLE `curso_alumno` ENABLE KEYS */;
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
