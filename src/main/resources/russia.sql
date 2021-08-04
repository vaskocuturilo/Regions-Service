-- MySQL dump 10.13  Distrib 8.0.26, for macos11.3 (x86_64)
--
-- Host: localhost    Database: regions
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `russia_entity`
--
DROP DATABASE IF EXISTS regions;

CREATE DATABASE regions;

USE regions;

DROP TABLE IF EXISTS `russia_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `russia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `russia_entity`
--

LOCK TABLES `russia_entity` WRITE;
/*!40000 ALTER TABLE `russia_entity` DISABLE KEYS */;
INSERT INTO `russia_entity` VALUES 
(1,'Республика Адыгея',01),
(2,'Республика Башкортостан',02),
(3,'Республика Башкортостан',102),
(4,'Республика Башкортостан',702),
(5,'Республика Бурятия',3),
(6,'Республика Алтай',4),
(7,'Республика Дагестан',5),
(8,'Республика Ингушетия',6),
(9,'Кабардино-Балкарская Республика',7),
(10,'Республика Калмыкия',8),
(11,'Республика Карелия',10),
(12,'Республика Коми',11),
(13,'Республика Марий Эл',12),
(14,'Республика Мордовия',13),
(15,'Республика Мордовия',113),
(16,'Республика Саха (Якутия)',14),
(17,'Республика Северная Осетия — Алания',15),
(18,'Республика Татарстан',16),
(19,'Республика Татарстан',116),
(20,'Республика Татарстан',716),
(21,'Республика Тыва',17),
(22,'Удмуртская Республика',18),
(23,'Республика Хакасия',19),
(24,'Чувашская Республика',21),
(25,'Чувашская Республика',121),
(26,'Алтайский край',22),
(27,'Алтайский край',122),
(28,'Краснодарский край',23),
(29,'Краснодарский край',93),
(30,'Краснодарский край',123),
(31,'Краснодарский край',193),
(32,'Красноярский край',24),
(33,'Красноярский край',84),
(34,'Красноярский край',88),
(35,'Красноярский край',124),
(36,'Приморский край',25),
(37,'Приморский край',125),
(38,'Ставропольский край',26),
(39,'Ставропольский край',126),
(40,'Хабаровский край',27),
(41,'Хабаровский край',127),
(42,'Амурская область',28),
(43,'Архангельская область',29),
(44,'Астраханская область',30);
/*!40000 ALTER TABLE `russia_entity` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-04 20:03:10
