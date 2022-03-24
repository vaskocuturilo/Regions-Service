DROP TABLE IF EXISTS `hungary_entity`;

CREATE TABLE `hungary_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `hungary_entity` WRITE;
/*!40000 ALTER TABLE `hungary_entity` DISABLE KEYS */;
INSERT INTO `hungary_entity` VALUES
(1,'1990','A'),
(2,'1991','B'),
(3,'1991','C'),
(4,'1992','D'),
(5,'1993','E'),
(6,'1994','F'),
(7,'1996','G'),
(8,'1999','H'),
(9,'2001','I'),
(10,'Dec 2003','J'),
(11,'Dec 2005','K'),
(12,'Nov 2007','L'),
(13,'Dec 2011','M'),
(14,'Dec 2014','N'),
(15,'Dec 2016','P'),
(16,'Jul 2018','R'),
(17,'Jan 2020','S'),
(18,'Sep 2021','T');
UNLOCK TABLES;