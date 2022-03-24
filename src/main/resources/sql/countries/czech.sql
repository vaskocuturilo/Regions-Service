DROP TABLE IF EXISTS `czech_entity`;

CREATE TABLE `czech_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `czech_entity` WRITE;
/*!40000 ALTER TABLE `czech_entity` DISABLE KEYS */;
INSERT INTO `czech_entity` VALUES
(1,'Hlavní město Praha, Capital City Prague','A'),
(2,'Jihomoravský kraj (Brno), South Moravia (Brno)','B'),
(3,'Jihočeský kraj (České Budějovice), South Bohemia (České Budějovice)','C'),
(4,'Pardubický kraj (Pardubice), (Pardubice)','E'),
(5,'Královéhradecký kraj (Hradec Králové), (Hradec Králové)','H'),
(6,'Vysočina(Jihlava), Highland (Vysočina) Region(Jihlava)','J'),
(7,'Karlovarský kraj (Karlovy Vary), (Karlovy Vary)','K'),
(8,'Liberecký kraj (Liberec), (Liberec)','L'),
(9,'Olomoucký kraj (Olomouc), (Olomouc)','M'),
(10,'Plzeňský kraj (Plzeň), (Plzeň)','P'),
(11,'Středočeský kraj (Praha), Central Bohemia (Prague)','S'),
(12,'Moravskoslezský kraj (Ostrava), Moravia-Silesia Region(Ostrava)','T'),
(13,'Ústecký kraj (Ústí nad Labem), (Ústí nad Labem)','U'),
(14,'Zlínský kraj (Zlín), (Zlín)','Z');
UNLOCK TABLES;
