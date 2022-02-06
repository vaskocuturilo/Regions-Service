DROP TABLE IF EXISTS `ireland_entity`;

CREATE TABLE `ireland_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `ireland_entity` WRITE;
/*!40000 ALTER TABLE `ireland_entity` DISABLE KEYS */;
INSERT INTO `ireland_entity` VALUES
(1,'Cork','C'),
(2,'Clare','CE'),
(3,'Cavan','CN'),
(4,'Carlow','CW'),
(5,'Dublin','D'),
(6,'Donegal','DL'),
(7,'Galway','G'),
(8,'Kildare','KE'),
(9,'Kilkenny','KK'),
(10,'Kerry','KY'),
(11,'Limerick','L'),
(12,'Longford','LD'),
(13,'Louth','LH'),
(14,'Leitrim','LM'),
(15,'Laois','LS'),
(16,'Meath','MH'),
(17,'Monaghan','MN'),
(18,'Mayo','MO'),
(19,'Offaly','OY'),
(20,'Roscommon','RN'),
(21,'Sligo','SO'),
(22,'Tipperary','T'),
(23,'Waterford','W'),
(24,'Westmeath','WH'),
(25,'Wexford','WX'),
(26,'Wicklow','WW');
UNLOCK TABLES;