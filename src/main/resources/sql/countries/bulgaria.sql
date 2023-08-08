DROP TABLE IF EXISTS `bulgaria_entity`;

CREATE TABLE `bulgaria_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `bulgaria_entity` WRITE;
/*!40000 ALTER TABLE `bulgaria_entity` DISABLE KEYS */;
INSERT INTO `bulgaria_entity` VALUES
(1,'Burgas Province','A'),
(2,'Varna Province','B'),
(3,'Vidin Province','BH'),
(4,'Vratsa Province','BP'),
(5,'Veliko Tarnovo Province','BT'),
(6,'Blagoevgrad Province','E'),
(7,'Gabrovo Province','EB'),
(8,'Pleven Province','EH'),
(9,'Kardzhali Province','K'),
(10,'Kyustendil Province','KH'),
(11,'Montana Province','M'),
(12,'Shumen Province','H'),
(13,'Lovech Province','OB'),
(14,'Ruse Province','P'),
(15,'Pazardzhik Province','PA'),
(16,'Plovdiv Province','PB'),
(17,'Pernik Province','PK'),
(18,'Razgrad Province','PP'),
(19,'Sofia (Capital)','C'),
(20,'Sofia (Capital)','CA'),
(21,'Sofia (Capital)','CB'),
(22,'Sliven Province','CH'),
(23,'Smolyan Province','CM'),
(24,'Sofia Province','CO'),
(25,'Silistra Province','CC'),
(26,'Stara Zagora Province','CT'),
(27,'Targovishte Province','T'),
(28,'Dobrich Province','TX'),
(29,'Yambol Province','Y'),
(30,'Haskovo Province','X');
UNLOCK TABLES;

ALTER TABLE bulgaria_entity ADD INDEX bulgaria_index (description, region);


