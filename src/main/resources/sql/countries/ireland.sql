DROP TABLE IF EXISTS `ireland_entity`;

CREATE TABLE `ireland_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `ireland_entity` WRITE;
/*!40000 ALTER TABLE `ireland_entity` DISABLE KEYS */;
INSERT INTO `ireland_entity` (description, region) VALUES
('Cork','C'),
('Clare','CE'),
('Cavan','CN'),
('Carlow','CW'),
('Dublin','D'),
('Donegal','DL'),
('Galway','G'),
('Kildare','KE'),
('Kilkenny','KK'),
('Kerry','KY'),
('Limerick','L'),
('Longford','LD'),
('Louth','LH'),
('Leitrim','LM'),
('Laois','LS'),
('Meath','MH'),
('Monaghan','MN'),
('Mayo','MO'),
('Offaly','OY'),
('Roscommon','RN'),
('Sligo','SO'),
('Tipperary','T'),
('Waterford','W'),
('Westmeath','WH'),
('Wexford','WX'),
('Wicklow','WW');
UNLOCK TABLES;

ALTER TABLE ireland_entity ADD INDEX ireland_index (description, region);