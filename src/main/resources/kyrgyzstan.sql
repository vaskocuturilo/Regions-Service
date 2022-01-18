DROP TABLE IF EXISTS `kyrgyzstan_entity`;

CREATE TABLE `kyrgyzstan_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `kyrgyzstan_entity` WRITE;
/*!40000 ALTER TABLE `kyrgyzstan_entity` DISABLE KEYS */;
INSERT INTO `kyrgyzstan_entity` VALUES
(1,'Баткенская область','03'),
(2,'Бишкек','01'),
(3,'Джалабадская область','04'),
(4,'Иссык-Кульская область','09'),
(5,'Нарынская область','05'),
(6,'Ош','02'),
(7,'Ошская область','06'),
(8,'Таласская область','07'),
(9,'Чуйская область','08');
UNLOCK TABLES;