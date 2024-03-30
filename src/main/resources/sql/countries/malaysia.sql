DROP TABLE IF EXISTS `malaysia_entity`;

CREATE TABLE `malaysia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `malaysia_entity` WRITE;
/*!40000 ALTER TABLE `moldova_entity` DISABLE KEYS */;
INSERT INTO `malaysia_entity` (description, region) VALUES
('Perak','A'),
('Selangor','B'),
('Pahang','C'),
('Kelantan','D'),
('Putrajaya','F'),
('Johor','J'),
('Kedah','K'),
('Malacca','M'),
('Negeri Sembilan','N'),
('Penang','P'),
('Perlis','R'),
('Terengganu','T'),
('Kuala Lumpur','V'),
('Kuala Lumpur','W');
UNLOCK TABLES;

ALTER TABLE malaysia_entity ADD INDEX malaysia_index (description, region);
