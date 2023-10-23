DROP TABLE IF EXISTS `british_age_1983_entity`;
CREATE TABLE `british_age_1983_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `letter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `british_age_1983_entity` WRITE;
/*!40000 ALTER TABLE `british_age_1983_entity` DISABLE KEYS */;
INSERT INTO `british_age_1983_entity` (date, letter) VALUES
('1 August 1983 – 31 July 1984','A'),
('1 August 1984 – 31 July 1985','B'),
('1 August 1985 – 31 July 1986','C'),
('1 August 1986 – 31 July 1987','D'),
('1 August 1987 – 31 July 1988','E'),
('1 August 1988 – 31 July 1989','F'),
('1 August 1989 – 31 July 1990','G'),
('1 August 1990 – 31 July 1991','H'),
('1 August 1991 – 31 July 1992','J'),
('1 August 1992 – 31 July 1993','K'),
('1 August 1993 – 31 July 1994','L'),
('1 August 1994 – 31 July 1995','M'),
('1 August 1995 – 31 July 1996','N'),
('1 August 1996 – 31 July 1997','P'),
('1 August 1997 – 31 July 1998','R'),
('1 August 1998 – 28 February 1999','S'),
('1 March 1999 – 31 August 1999','T'),
('1 September 1999 – 29 February 2000','V'),
('1 March 2000 – 31 August 2000','W'),
('1 September 2000 – 28 February 2001','X'),
('1 March 2001 – 31 August 2001','Y');
UNLOCK TABLES;

ALTER TABLE british_age_1983_entity ADD INDEX british_age_index (date, letter);