DROP TABLE IF EXISTS `poland_old_entity`;

CREATE TABLE `poland_old_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `poland_old_entity` WRITE;
/*!40000 ALTER TABLE `poland_old_entity` DISABLE KEYS */;
INSERT INTO `poland_old_entity` (description, region) VALUES
('Białystok Voivodeship','A'),
('Bydgoszcz Voivodeship','B'),
('Kielce Voivodeship','C'),
('Koszalin Voivodeship','E'),
('Łódź Voivodeship','F'),
('Gdańsk Voivodeship','G'),
('Opole Voivodeship','H'),
('city of Łódź','I'),
('Kraków Voivodeship','K'),
('Lublin Voivodeship','L'),
('Szczecin Voivodeship','M'),
('Olsztyn Voivodeship','O'),
('Poznań Voivodeship','P'),
('Rzeszów Voivodeship','R'),
('Katowice Voivodeship','S'),
('Warsaw Voivodeship','T'),
('capital city of Warsaw','W'),
('Wrocław Voivodeship','X'),
('Zielona Góra Voivodeship','Z');
UNLOCK TABLES;

ALTER TABLE poland_old_entity ADD INDEX poland_index (description, region);
