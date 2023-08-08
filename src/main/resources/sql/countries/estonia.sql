DROP TABLE IF EXISTS `estonia_entity`;

CREATE TABLE `estonia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `estonia_entity` WRITE;
/*!40000 ALTER TABLE `estonia_entity` DISABLE KEYS */;
INSERT INTO `estonia_entity` VALUES
(1,'Tallinn','A'),
(2,'Tallinn','B'),
(3,'Viljandimaa','D'),
(4,'Pärnumaa','F'),
(5,'Valgamaa','G'),
(6,'Hiiumaa','H'),
(7,'Ida-Virumaa outside of Narva','I'),
(8,'Jõgevamaa','J'),
(9,'Saaremaa as Kuressaare','K'),
(10,'Raplamaa','L'),
(11,'Harjumaa outside of Tallinn','M'),
(12,'Narva','N'),
(13,'Põlvamaa','O'),
(14,'Järvamaa as Paide','P'),
(15,'Lääne-Virumaa as Rakvere','R'),
(17,'Läänemaa as Haapsalu','S'),
(18,'Tartumaa','T'),
(19,'Võrumaa','V');
UNLOCK TABLES;

ALTER TABLE estonia_entity ADD INDEX estonia_index (description, region);