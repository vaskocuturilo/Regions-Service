DROP TABLE IF EXISTS `bulgaria_entity`;

CREATE TABLE `bulgaria_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `bulgaria_entity` WRITE;
/*!40000 ALTER TABLE `bulgaria_entity` DISABLE KEYS */;
INSERT INTO `bulgaria_entity` (description, region) VALUES
('Burgas Province','A'),
('Varna Province','B'),
('Vidin Province','BH'),
('Vratsa Province','BP'),
('Veliko Tarnovo Province','BT'),
('Blagoevgrad Province','E'),
('Gabrovo Province','EB'),
('Pleven Province','EH'),
('Kardzhali Province','K'),
('Kyustendil Province','KH'),
('Montana Province','M'),
('Shumen Province','H'),
('Lovech Province','OB'),
('Ruse Province','P'),
('Pazardzhik Province','PA'),
('Plovdiv Province','PB'),
('Pernik Province','PK'),
('Razgrad Province','PP'),
('Sofia (Capital)','C'),
('Sofia (Capital)','CA'),
('Sofia (Capital)','CB'),
('Sliven Province','CH'),
('Smolyan Province','CM'),
('Sofia Province','CO'),
('Silistra Province','CC'),
('Stara Zagora Province','CT'),
('Targovishte Province','T'),
('Dobrich Province','TX'),
('Yambol Province','Y'),
('Haskovo Province','X');
UNLOCK TABLES;

ALTER TABLE bulgaria_entity ADD INDEX bulgaria_index (description, region);


