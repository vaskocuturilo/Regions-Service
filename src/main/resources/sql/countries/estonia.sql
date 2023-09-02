DROP TABLE IF EXISTS `estonia_entity`;

CREATE TABLE `estonia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `estonia_entity` WRITE;
/*!40000 ALTER TABLE `estonia_entity` DISABLE KEYS */;
INSERT INTO `estonia_entity` (description, region) VALUES
('Tallinn','A'),
('Tallinn','B'),
('Viljandimaa','D'),
('Pärnumaa','F'),
('Valgamaa','G'),
('Hiiumaa','H'),
('Ida-Virumaa outside of Narva','I'),
('Jõgevamaa','J'),
('Saaremaa as Kuressaare','K'),
('Raplamaa','L'),
('Harjumaa outside of Tallinn','M'),
('Narva','N'),
('Põlvamaa','O'),
('Järvamaa as Paide','P'),
('Lääne-Virumaa as Rakvere','R'),
('Läänemaa as Haapsalu','S'),
('Tartumaa','T'),
('Võrumaa','V');
UNLOCK TABLES;

ALTER TABLE estonia_entity ADD INDEX estonia_index (description, region);