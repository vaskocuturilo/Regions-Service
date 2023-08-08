DROP TABLE IF EXISTS `slovenia_entity`;

CREATE TABLE `slovenia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `slovenia_entity` WRITE;
/*!40000 ALTER TABLE `slovenia_entity` DISABLE KEYS */;
INSERT INTO `slovenia_entity` VALUES
(1,'Celje, Laško, Mozirje, Slovenske Konjice, Šentjur, Šmarje pri Jelšah, Velenje, Žalec','CE'),
(2,'Ajdovščina, Idrija, Tolmin, Nova Gorica','GO'),
(3,'Brežice, Krško, Sevnica','KK'),
(4,'Izola, Koper, Piran, Sežana, Ilirska Bistrica','KP'),
(5,'Jesenice, Kranj, Radovljica, Škofja Loka, Tržič','KR'),
(6,'Cerknica, Domžale, Grosuplje, Hrastnik, Kamnik, Kočevje, Litija, Ljubljana, Logatec, Ribnica, Ribnica, Trbovlje, Vrhnika, Zagorje ob Savi','LJ'),
(7,'Lenart v Slovenskih Goricah, Maribor, Ormož, Pesnica pri Mariboru, Ptuj, Ruše, Slovenska Bistrica','MB'),
(8,'Gornja Radgona, Lendava, Ljutomer, Murska Sobota','MS'),
(9,'Črnomelj, Metlika, Novo Mesto, Trebnje','NM'),
(10,'Postojna','PO'),
(11,'Dravograd, Radlje ob Dravi, Ravne na Koroškem, Slovenj Gradec','SG');
UNLOCK TABLES;

ALTER TABLE slovenia_entity ADD INDEX slovenia_index (description, region);