DROP TABLE IF EXISTS `slovenia_entity`;

CREATE TABLE `slovenia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `slovenia_entity` WRITE;
/*!40000 ALTER TABLE `slovenia_entity` DISABLE KEYS */;
INSERT INTO `slovenia_entity` (description, region) VALUES
('Celje, Laško, Mozirje, Slovenske Konjice, Šentjur, Šmarje pri Jelšah, Velenje, Žalec','CE'),
('Ajdovščina, Idrija, Tolmin, Nova Gorica','GO'),
('Brežice, Krško, Sevnica','KK'),
('Izola, Koper, Piran, Sežana, Ilirska Bistrica','KP'),
('Jesenice, Kranj, Radovljica, Škofja Loka, Tržič','KR'),
('Cerknica, Domžale, Grosuplje, Hrastnik, Kamnik, Kočevje, Litija, Ljubljana, Logatec, Ribnica, Ribnica, Trbovlje, Vrhnika, Zagorje ob Savi','LJ'),
('Lenart v Slovenskih Goricah, Maribor, Ormož, Pesnica pri Mariboru, Ptuj, Ruše, Slovenska Bistrica','MB'),
('Gornja Radgona, Lendava, Ljutomer, Murska Sobota','MS'),
('Črnomelj, Metlika, Novo Mesto, Trebnje','NM'),
('Postojna','PO'),
('Dravograd, Radlje ob Dravi, Ravne na Koroškem, Slovenj Gradec','SG');
UNLOCK TABLES;

ALTER TABLE slovenia_entity ADD INDEX slovenia_index (description, region);