DROP TABLE IF EXISTS `lithuania_entity`;

CREATE TABLE `lithuania_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


LOCK TABLES `lithuania_entity` WRITE;
/*!40000 ALTER TABLE `lithuania_entity` DISABLE KEYS */;
INSERT INTO `lithuania_entity` VALUES
(1,'Alytus County','A'),
(2,'Tauragė County (but code from first letter of Jurbarkas)','J'),
(3,'Kaunas County','K'),
(4,'Klaipėda County','L'),
(5,'Marijampolė County','M'),
(6,'Panevėžys County','P'),
(7,'Šiauliai County','S'),
(8,'Telšiai County','T'),
(9,'Utena County','U'),
(10,'Vilnius County','V');
UNLOCK TABLES;

ALTER TABLE lithuania_entity ADD INDEX lithuania_index (description, region);
