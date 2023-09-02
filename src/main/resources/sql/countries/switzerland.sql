DROP TABLE IF EXISTS `switzerland_entity`;

CREATE TABLE `switzerland_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `switzerland_entity` WRITE;
/*!40000 ALTER TABLE `switzerland_entity` DISABLE KEYS */;
INSERT INTO `switzerland_entity` (description, region) VALUES
('Aargau','AG'),
('Appenzell Innerrhoden','AI'),
('Appenzell Ausserrhoden','AR'),
('Bern','BE'),
('Basel-Landschaft','BL'),
('Basel-Stadt','BS'),
('Fribourg','FR'),
('Geneva','GE'),
('Glarus','GL'),
('Graubünden','GR'),
('Jura','JU'),
('Lucerne','LU'),
('Neuchâtel','NE'),
('Nidwalden','NW'),
('Obwalden','OW'),
('St. Gallen','SG'),
('Schaffhausen','SH'),
('Solothurn','SO'),
('Schwyz','SZ'),
('Thurgau','TG'),
('Ticino','TI'),
('Uri','UR'),
('Vaud','VD'),
('Valais','VS'),
('Zug','ZG'),
('Zürich','ZH');
UNLOCK TABLES;

ALTER TABLE switzerland_entity ADD INDEX switzerland_index (description, region);
