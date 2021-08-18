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

DROP DATABASE IF EXISTS `regions`;

CREATE DATABASE regions;

USE regions;

DROP TABLE IF EXISTS `russia_entity`;
DROP TABLE IF EXISTS `ukraine_entity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `russia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `ukraine_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `russia_entity` and 'ukraine_entity`
--

LOCK TABLES `russia_entity` WRITE;
/*!40000 ALTER TABLE `russia_entity` DISABLE KEYS */;
INSERT INTO `russia_entity` VALUES
(1,'Республика Адыгея','1'),
(2,'Республика Башкортостан','2'),
(3,'Республика Башкортостан','102'),
(4,'Республика Башкортостан','702'),
(5,'Республика Бурятия','3'),
(6,'Республика Алтай','4'),
(7,'Республика Дагестан','5'),
(8,'Республика Ингушетия','6'),
(9,'Кабардино-Балкарская Республика','7'),
(10,'Республика Калмыкия','8'),
(11,'Республика Карелия','10'),
(12,'Республика Коми','11'),
(13,'Республика Марий Эл','12'),
(14,'Республика Мордовия','13'),
(15,'Республика Мордовия','113'),
(16,'Республика Саха (Якутия)','14'),
(17,'Республика Северная Осетия — Алания','15'),
(18,'Республика Татарстан','16'),
(19,'Республика Татарстан','116'),
(20,'Республика Татарстан','716'),
(21,'Республика Тыва','17'),
(22,'Удмуртская Республика','18'),
(23,'Республика Хакасия','19'),
(24,'Чувашская Республика','21'),
(25,'Чувашская Республика','121'),
(26,'Алтайский край','22'),
(27,'Алтайский край','122'),
(28,'Краснодарский край','23'),
(29,'Краснодарский край','93'),
(30,'Краснодарский край','123'),
(31,'Краснодарский край','193'),
(32,'Красноярский край','24'),
(33,'Красноярский край','84'),
(34,'Красноярский край','88'),
(35,'Красноярский край','124'),
(36,'Приморский край','25'),
(37,'Приморский край','125'),
(38,'Ставропольский край','26'),
(39,'Ставропольский край','126'),
(40,'Хабаровский край','27'),
(41,'Хабаровский край','127'),
(42,'Амурская область','28'),
(43,'Архангельская область','29'),
(44,'Астраханская область','30'),
(45,'Белгородская область','31'),
(46,'Брянская область','32'),
(47,'Владимирская область','33'),
(48,'Волгоградская область','34'),
(49,'Волгоградская область','134'),
(50,'Вологодская область','35'),
(51,'Воронежская область','36'),
(52,'Воронежская область','136'),
(53,'Ивановская область','37'),
(54,'Иркутская область','38'),
(55,'Иркутская область','85'),
(56,'Иркутская область','138'),
(57,'Калининградская область','39'),
(58,'Калининградская область','91'),
(59,'Калужская область','40'),
(60,'Камчатский край','41'),
(61,'Камчатский край','82'),
(62,'Кемеровская область','42'),
(63,'Кемеровская область','142'),
(64,'Кировская область','43'),
(65,'Костромская область','44'),
(66,'Курганская область','45'),
(67,'Курская область','46'),
(68,'Ленинградская область','47'),
(69,'Ленинградская область','147'),
(70,'Липецкая область','48'),
(71,'Магаданская область','49'),
(72,'Московская область','50'),
(73,'Московская область','90'),
(74,'Московская область','150'),
(75,'Московская область','190'),
(76,'Московская область','750'),
(77,'Московская область','790'),
(78,'Мурманская область','51'),
(79,'Нижегородская область','52'),
(80,'Нижегородская область','152'),
(81,'Новгородская область','53'),
(82,'Новосибирская область','54'),
(83,'Новосибирская область','154'),
(84,'Омская область','55'),
(85,'Оренбургская область','56'),
(86,'Оренбургская область','156'),
(87,'Пензенская область','58'),
(88,'Пермский край','59'),
(89,'Пермский край','81'),
(90,'Пермский край','159'),
(91,'Псковская область','60'),
(92,'Ростовская область','61'),
(93,'Ростовская область','161'),
(94,'Ростовская область','761'),
(95,'Рязанская область','62'),
(96,'Самарская область','63'),
(97,'Самарская область','163'),
(98,'Самарская область','763'),
(99,'Саратовская область','64'),
(100,'Саратовская область','164'),
(101,'Сахалинская область','65'),
(102,'Свердловская область','66'),
(103,'Свердловская область','96'),
(104,'Свердловская область','196'),
(105,'Смоленская область','67'),
(106,'Тамбовская область','68'),
(107,'Тверская область','69'),
(108,'Тверская область','169'),
(109,'Томская область','70'),
(110,'Тульская область','71'),
(111,'Тюменская область','72'),
(112,'Ульяновская область','73'),
(113,'Ульяновская область','173'),
(114,'Челябинская область','74'),
(115,'Челябинская область','174'),
(116,'Челябинская область','774'),
(117,'Забайкальский край','75'),
(118,'Забайкальский край','80'),
(119,'Ярославская область','76'),
(120,'Москва','77'),
(121,'Москва','97'),
(122,'Москва','99'),
(123,'Москва','177'),
(124,'Москва','199'),
(125,'Москва','197'),
(126,'Москва','777'),
(127,'Москва','797'),
(128,'Москва','799'),
(129,'Санкт-Петербург','78'),
(130,'Санкт-Петербург','98'),
(131,'Санкт-Петербург','178'),
(132,'Санкт-Петербург','198'),
(133,'Еврейская автономная область','79'),
(134,'Республика Крым','82'),
(135,'Ненецкий автономный округ','83'),
(136,'Ханты-Мансийский автономный округ Югра','86'),
(137,'Ханты-Мансийский автономный округ Югра','186'),
(138,'Чукотский автономный округ','87'),
(139,'Ямало-Ненецкий автономный округ','89'),
(140,'Севастополь','92'),
(141,'Байконур','94'),
(142,'Чеченская республика','20'),
(143,'Чеченская республика','95');
/*!40000 ALTER TABLE `russia_entity` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `ukraine_entity` WRITE;
/*!40000 ALTER TABLE `ukraine_entity` DISABLE KEYS */;
INSERT INTO `ukraine_entity` VALUES
(1,'город Киев','AA'),
(2,'Винницкая область','AB'),
(3,'Волынская область','AC'),
(4,'Днепропетровская область','AE'),
(5,'Донецкая область','AH'),
(6,'Киевская область','AI'),
(7,'Автономная Республика Крым','AK'),
(8,'Житомирская область','AM'),
(9,'Закарпатская область','AO'),
(10,'Запорожская область','AP'),
(11,'Ивано-Франковская область','AT'),
(12,'Харьковская область','AX'),
(13,'Кировоградская область','BA'),
(14,'Луганская область','BB'),
(15,'Львовская область','BC'),
(16,'Николаевская область','BE'),
(17,'Одесская область','BH'),
(18,'Полтавская область','BI'),
(19,'Ровенская область','BK'),
(20,'Сумская область','BM'),
(21,'Тернопольская область','BO'),
(22,'Херсонская область','BT'),
(23,'Хмельницкая область','BX'),
(24,'Черкасская область','CA'),
(25,'Черниговская область','CB'),
(26,'Черновицкая область','CE'),
(27,'город Севастополь','CH'),
(28,'Общегосударственные номера','II');
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-06 19:26:54
