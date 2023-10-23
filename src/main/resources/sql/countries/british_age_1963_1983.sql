DROP TABLE IF EXISTS `british_age_entity`;
CREATE TABLE `british_age_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `letter` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `british_age_entity` WRITE;
/*!40000 ALTER TABLE `british_entity` DISABLE KEYS */;
INSERT INTO `british_age_entity` (date, letter) VALUES
('February 1963 – 31 December 1963','A'),
('1 January 1964 – 31 December 1964','B'),
('1 January 1965 – 31 December 1965','C'),
('1 January 1966 – 31 December 1966','D'),
('1 January 1967 – 31 July 1967','E'),
('1 August 1967 – 31 July 1968','F'),
('1 August 1968 – 31 July 1969','G'),
('1 August 1969 – 31 July 1970','H'),
('1 August 1970 – 31 July 1971','J'),
('1 August 1971 – 31 July 1972','K'),
('1 August 1972 – 31 July 1973','L'),
('1 August 1973 – 31 July 1974','M'),
('1 August 1974 – 31 July 1975','N'),
('1 August 1975 – 31 July 1976','P'),
('1 August 1976 – 31 July 1977','R'),
('1 August 1977 – 31 July 1978','S'),
('1 August 1978 – 31 July 1979','T'),
('1 August 1979 – 31 July 1980','V'),
('1 August 1980 – 31 July 1981','W'),
('1 August 1981 – 31 July 1982','X'),
('1 August 1982 – 31 July 1983','Y');
UNLOCK TABLES;

ALTER TABLE british_age_entity ADD INDEX british_age_index (date, letter);