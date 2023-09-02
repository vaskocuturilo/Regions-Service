DROP TABLE IF EXISTS `kosovo_entity`;

CREATE TABLE `kosovo_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kosovo_entity` WRITE;
/*!40000 ALTER TABLE `kosovo_entity` DISABLE KEYS */;
INSERT INTO `kosovo_entity` (description, region) VALUES
('Pristina','01'),
('Mitrovica','02'),
('Peja','03'),
('Prizren','04'),
('Ferizaj','05'),
('Gjilan','06'),
('Gjakova','07');
UNLOCK TABLES;

ALTER TABLE kosovo_entity ADD INDEX kosovo_index (description, region);