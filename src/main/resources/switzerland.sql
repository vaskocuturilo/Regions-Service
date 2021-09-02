DROP TABLE IF EXISTS `switzerland_entity`;

CREATE TABLE `switzerland_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `switzerland_entity` WRITE;
/*!40000 ALTER TABLE `switzerland_entity` DISABLE KEYS */;
INSERT INTO `switzerland_entity` VALUES
(1,'Aargau','AG'),
(2,'Appenzell Innerrhoden','AI'),
(3,'Appenzell Ausserrhoden','AR'),
(4,'Bern','BE'),
(5,'Basel-Landschaft','BL'),
(6,'Basel-Stadt','BS'),
(7,'Fribourg','FR'),
(8,'Geneva','GE'),
(9,'Glarus','GL'),
(10,'Graubünden','GR'),
(11,'Jura','JU'),
(12,'Lucerne','LU'),
(13,'Neuchâtel','NE'),
(14,'Nidwalden','NW'),
(15,'Obwalden','OW'),
(16,'St. Gallen','SG'),
(17,'Schaffhausen','SH'),
(18,'Solothurn','SO'),
(19,'Schwyz','SZ'),
(20,'Thurgau','TG'),
(21,'Ticino','TI'),
(22,'Uri','UR'),
(23,'Vaud','VD'),
(24,'Valais','VS'),
(25,'Zug','ZG'),
(26,'Zürich','ZH');
UNLOCK TABLES;
