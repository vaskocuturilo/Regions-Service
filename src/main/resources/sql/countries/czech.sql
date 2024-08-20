DROP TABLE IF EXISTS `czech_entity`;

CREATE TABLE `czech_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `czech_entity` WRITE;
/*!40000 ALTER TABLE `czech_entity` DISABLE KEYS */;
INSERT INTO `czech_entity` (description, region) VALUES
('Hlavní město Praha, Capital City Prague','A'),
('Jihomoravský kraj (Brno), South Moravia (Brno)','B'),
('Jihočeský kraj (České Budějovice), South Bohemia (České Budějovice)','C'),
('Pardubický kraj (Pardubice), (Pardubice)','E'),
('Královéhradecký kraj (Hradec Králové), (Hradec Králové)','H'),
('Vysočina(Jihlava), Highland (Vysočina) Region(Jihlava)','J'),
('Karlovarský kraj (Karlovy Vary), (Karlovy Vary)','K'),
('Liberecký kraj (Liberec), (Liberec)','L'),
('Olomoucký kraj (Olomouc), (Olomouc)','M'),
('Plzeňský kraj (Plzeň), (Plzeň)','P'),
('Středočeský kraj (Praha)','S'),
('Moravskoslezský kraj (Ostrava), Moravia-Silesia Region(Ostrava)','T'),
('Ústecký kraj (Ústí nad Labem), (Ústí nad Labem)','U'),
('Zlínský kraj (Zlín), (Zlín)','Z');
UNLOCK TABLES;

ALTER TABLE czech_entity ADD INDEX czech_index (description, region);
