DROP TABLE IF EXISTS `poland_dip_entity`;
CREATE TABLE `poland_dip_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `poland_dip_entity` WRITE;
INSERT INTO `poland_dip_entity` VALUES
(1,'United States','001'),
(2,'United Kingdom','002'),
(3,'France','003'),
(4,'Canada','004'),
(5,'Germany','005'),
(6,'Netherlands','006'),
(7,'Italy','007'),
(8,'Austria','008'),
(9,'Japan','009'),
(10,'Turkey','010'),
(11,'Belgium','011'),
(12,'Denmark','012'),
(13,'Norway','013'),
(14,'Greece','014'),
(15,'Australia','015'),
(16,'Algeria','016'),
(17,'Afghanistan','017'),
(18,'Argentina','018'),
(19,'Brazil','019'),
(20,'Bangladesh','020'),
(21,'Egypt','021'),
(22,'Ecuador','022'),
(23,'Finland','023'),
(24,'Spain','024'),
(25,'Iraq','025'),
(26,'Iran','026'),
(27,'India','027'),
(28,'Indonesia','028'),
(29,'Colombia','029'),
(30,'Malaysia','030'),
(31,'Libya','031'),
(32,'Morocco','032'),
(33,'Mexico','033'),
(34,'Nigeria','034'),
(35,'Pakistan','035'),
(36,'Portugal','036'),
(37,'Palestine','037'),
(38,'Syria','038'),
(39,'Sweden','039'),
(40,'Switzerland','040'),
(41,'Tunisia','041'),
(42,'Thailand','042'),
(43,'Venezuela','043'),
(44,'Uruguay','044'),
(45,'Peru','045'),
(46,'Yemen','046'),
(47,'Costa Rica','047'),
(48,'Democratic Republic of Congo','048'),
(49,'Israel','049'),
(50,'Nicaragua','050'),
(51,'Chile','051'),
(52,'Holy See','052'),
(53,'South Korea','053'),
(54,'European Union European Commission','054'),
(55,'Ireland','055'),
(56,'World Bank','056'),
(57,'International Monetary Fund','057'),
(58,'Philippines','058'),
(59,'International Finance Corporation','059'),
(60,'South Africa','060'),
(61,'Office for Democratic Institutions and Human Rights','061'),
(62,'Cyprus','062'),
(63,'Kuwait','063'),
(64,'United Nations','064'),
(65,'Russia','065'),
(66,'Slovakia','066'),
(67,'Czech Republic','067'),
(68,'Bulgaria','068'),
(69,'Hungary','069'),
(70,'Romania','070'),
(71,'Vietnam','071'),
(72,'Serbia','072'),
(73,'North Korea','073'),
(74,'Cuba','074'),
(75,'Albania','075'),
(76,'China','076'),
(77,'Mongolia','077'),
(78,'International Labour Organization','078'),
(79,'Organization for Cooperation of Railways','079'),
(80,'Diplomatic Club','080'),
(81,'Laos','081'),
(82,'Angola','082'),
(83,'Ukraine','083'),
(84,'European Bank for Reconstruction and Development','084'),
(85,'Lithuania','085'),
(86,'Belarus','086'),
(87,'Latvia','087'),
(88,'Croatia','088'),
(89,'Lebanon','089'),
(90,'Slovenia','090'),
(91,'Guatemala','091'),
(92,'Estonia','092'),
(93,'Macedonia','093'),
(94,'Moldova','094'),
(95,'Israel','095'),
(96,'Armenia','096'),
(97,'Sri Lanka','097'),
(98,'Kazakhstan','098'),
(99,'Saudi Arabia','099'),
(100,'Georgia','100'),
(101,'Uzbekistan','101'),
(102,'United Nations Human Settlements Programme','102'),
(103,'New Zealand','103'),
(104,'Azerbaijan','104'),
(105,'Sovereign Military Order of Malta','105'),
(106,'Cambodia','106'),
(107,'Frontex','107'),
(108,'Luxembourg','108'),
(109,'Bosnia and Herzegovina','109'),
(110,'Panama','110'),
(111,'Qatar','111'),
(112,'Malta','112'),
(113,'United Arab Emirates','113'),
(114,'Montenegro','114'),
(115,'Senegal','115');
UNLOCK TABLES;