DROP TABLE IF EXISTS `france_entity`;

CREATE TABLE `france_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `france_entity` WRITE;
/*!40000 ALTER TABLE `france_entity` DISABLE KEYS */;
INSERT INTO `france_entity` VALUES
(1,'Ain,LaonBourg-en-Bresse,Auvergne-Rhône-Alpes','01'),
(2,'Aisne,Laon,Hauts-de-France','02'),
(3,'Allier,Moulins,Auvergne-Rhône-Alpes','03'),
(4,'Alpes-de-Haute-Provence,Digne-les-Bains,Provence-Alpes-Côte d\'Azur','04'),
(5,'Hautes-Alpes,Gap,Provence-Alpes-Côte d\'Azur','05'),
(6,'Alpes-Maritimes,Nice,Provence-Alpes-Côte d\'Azur','06'),
(7,'Ardèche,Privas,Auvergne-Rhône-Alpes','07'),
(8,'Ardennes,Charleville-Mézières,Grand Est','08'),
(9,'Ariège,Foix,Occitanie','09'),
(10,'Aube,Troyes,Grand Est','10'),
(11,'Aude,Carcassonne,Occitanie','11'),
(12,'Aveyron,Rodez,Occitanie','12'),
(13,'Bouches-du-Rhône,Marseille,Provence-Alpes-Côte d\'Azur','13'),
(14,'Calvados,Caen,Normandie','14'),
(15,'Cantal,Aurillac,Auvergne-Rhône-Alpes','15'),
(16,'Charente,Angoulême,Nouvelle-Aquitaine','16'),
(17,'Charente-Maritime,La Rochelle,Nouvelle-Aquitaine','17'),
(18,'Cher,Bourges,Centre-Val de Loire','18'),
(19,'Corrèze,Tulle,Nouvelle-Aquitaine','19'),
(20,'Corse-du-Sud,Ajaccio,Corse','2A'),
(21,'Haute-Corse,Bastia,Corse','2B'),
(22,'Côte-d\'Or,Dijon,Bourgogne-Franche-Comté','21'),
(23,'Côtes-d\'Armor,Saint-Brieuc,Bretagne','22'),
(24,'Creuse,Guéret,Nouvelle-Aquitaine','23'),
(25,'Dordogne,Périgueux,Nouvelle-Aquitaine','24'),
(26,'Doubs,Besançon,Bourgogne-Franche-Comté	','25'),
(27,'Drôme,Valence,Auvergne-Rhône-Alpes','26'),
(28,'Eure,Évreux,Normandie','27'),
(29,'Eure-et-Loir,Chartres,Centre-Val de Loire','28'),
(30,'Finistère,Quimper,Bretagne','29'),
(31,'Gard,Nîmes,Occitanie','30'),
(32,'Haute-Garonne,Toulouse,Occitanie','31'),
(33,'Gers,Auch,Occitanie','32'),
(34,'Gironde,Bordeaux,Nouvelle-Aquitaine','33'),
(35,'Hérault,Montpellier,Occitanie','34'),
(36,'Ille-et-Vilaine,Rennes,Bretagne','35'),
(37,'Indre,Châteauroux,Centre-Val de Loire','36'),
(38,'Indre-et-Loire,Tours,Centre-Val de Loire','37'),
(39,'Isère,Grenoble,Auvergne-Rhône-Alpes','38'),
(40,'Jura,Lons-le-Saunier,Bourgogne-Franche-Comté','39'),
(41,'Landes,Mont-de-Marsan,Nouvelle-Aquitaine','40'),
(42,'Loir-et-Cher,Blois,Centre-Val de Loire','41'),
(43,'Loire,Saint-Étienne,Auvergne-Rhône-Alpes','42'),
(44,'Haute-Loire,Le Puy,Auvergne-Rhône-Alpes','43'),
(45,'Loire-Atlantique,Nantes,Pays de la Loire','44'),
(46,'Loiret,Orléans,Centre-Val de Loire','45'),
(47,'Lot,Cahors,Occitanie','46'),
(48,'Lot-et-Garonne,Agen,Nouvelle-Aquitaine','47'),
(49,'Lozère,Mende,Occitanie','48'),
(50,'Maine-et-Loire,Angers,Pays de la Loire','49'),
(51,'Manche,Saint-Lô,Normandie','50'),
(52,'Marne,Châlons-en-Champagne,Grand Est','51'),
(53,'Haute-Marne,Chaumont,Grand Est','52'),
(54,'Mayenne,Laval,Pays de la Loire','53'),
(55,'Meurthe-et-Moselle,Nancy,Grand Est','54'),
(56,'Meuse,Bar-le-Duc,Grand Est','55'),
(57,'Morbihan,Vannes,Bretagne','56'),
(58,'Moselle,Metz,Grand Est','57'),
(59,'Nièvre,Nevers,Bourgogne-Franche-Comté	','58'),
(60,'Nord,Lille,Hauts-de-France','59'),
(61,'Oise,Beauvais,Hauts-de-France','60'),
(62,'Orne,Alençon,Normandie','61'),
(63,'Pas-de-Calais,Arras,Hauts-de-France','62'),
(64,'Puy-de-Dôme,Clermont-Ferrand,Auvergne-Rhône-Alpes','63'),
(65,'Pyrénées-Atlantiques,Pau,Nouvelle-Aquitaine','64'),
(66,'Hautes-Pyrénées,Tarbes,Occitanie','65'),
(67,'Pyrénées-Orientales,Perpignan,Occitanie','66'),
(68,'Bas-Rhin,Strasbourg,Grand Est','67'),
(69,'Haut-Rhin,Colmar,Grand Est','68'),
(70,'Rhône,Lyon,Auvergne-Rhône-Alpes','69D'),
(71,'Métropolede Lyon,Lyon,Auvergne-Rhône-Alpes','69M'),
(72,'Haute-Saône,Vesoul,Bourgogne-Franche-Comté','70'),
(73,'Saône-et-Loire,Mâcon,Bourgogne-Franche-Comté','71'),
(74,'Sarthe,Le Mans,Pays de la Loire','72'),
(75,'Savoie,Chambéry,Auvergne-Rhône-Alpes','73'),
(76,'Haute-Savoie,Annecy,Auvergne-Rhône-Alpes','74'),
(77,'Paris,Paris,Île-de-France','75'),
(78,'Seine-Maritime,Rouen,Normandie','76'),
(79,'Seine-et-Marne,Melun,Île-de-France','77'),
(80,'Yvelines,Versailles,Île-de-France','78'),
(81,'Deux-Sèvres,Niort,Nouvelle-Aquitaine','79'),
(82,'Somme,Amiens,Hauts-de-France','80'),
(83,'Tarn,Albi,Occitanie','81'),
(84,'Tarn-et-Garonne,Montauban,Occitanie','82'),
(85,'Var,Toulon,Provence-Alpes-Côte d\'Azur	','83'),
(86,'Vaucluse,Avignon,Provence-Alpes-Côte d\'Azur	','84'),
(87,'Vendée,La Roche-sur-Yon,Pays de la Loire','85'),
(88,'Vienne,Poitiers,Nouvelle-Aquitaine','86'),
(89,'Haute-Vienne,Limoges,Nouvelle-Aquitaine','87'),
(90,'Vosges,Épinal,Grand Est','88'),
(91,'Yonne	Auxerre	Bourgogne-Franche-Comté	','89'),
(92,'Territoire-de-Belfort,Belfort,Bourgogne-Franche-Comté	','90'),
(93,'Essonne,Évry,Île-de-France','91'),
(94,'Hauts-de-Seine,Nanterre,Île-de-France','92'),
(95,'Seine-Saint-Denis,Bobigny,Île-de-France','93'),
(96,'Val-de-Marne,Créteil,Île-de-France','94'),
(97,'Val-d\'Oise,Pontoise,Île-de-France','95'),
(98,'Guadeloupe,Basse-Terre,Outre-Mer','971'),
(99,'Martinique,Fort-de-France,Outre-Mer','972'),
(100,'Guyane française,Cayenne,Outre-Mer','973'),
(101,'Réunion,Saint-Denis,Outre-Mer','974'),
(102,'Mayotte,Mamoudzou,Outre-Mer','976');
UNLOCK TABLES;