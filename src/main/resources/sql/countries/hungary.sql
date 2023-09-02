DROP TABLE IF EXISTS `hungary_entity`;

CREATE TABLE `hungary_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `hungary_entity` WRITE;
/*!40000 ALTER TABLE `hungary_entity` DISABLE KEYS */;
INSERT INTO `hungary_entity` (description, region) VALUES
('1990','A'),
('1991','B'),
('1991','C'),
('1992','D'),
('1993','E'),
('1994','F'),
('1996','G'),
('1999','H'),
('2001','I'),
('Dec 2003','J'),
('Dec 2005','K'),
('Nov 2007','L'),
('Dec 2011','M'),
('Dec 2014','N'),
('Dec 2016','P'),
('Jul 2018','R'),
('Jan 2020','S'),
('Sep 2021','T'),
('Sep 2022-2023','U');
UNLOCK TABLES;

ALTER TABLE hungary_entity ADD INDEX hungary_index (description, region);