DROP TABLE IF EXISTS `lithuania_entity`;

CREATE TABLE `lithuania_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


LOCK TABLES `lithuania_entity` WRITE;
/*!40000 ALTER TABLE `lithuania_entity` DISABLE KEYS */;
INSERT INTO `lithuania_entity` (description, region) VALUES
('Alytus County','A'),
('Tauragė County (but code from first letter of Jurbarkas)','J'),
('Kaunas County','K'),
('Klaipėda County','L'),
('Marijampolė County','M'),
('Panevėžys County','P'),
('Šiauliai County','S'),
('Telšiai County','T'),
('Utena County','U'),
('Vilnius County','V');
UNLOCK TABLES;

ALTER TABLE lithuania_entity ADD INDEX lithuania_index (description, region);
