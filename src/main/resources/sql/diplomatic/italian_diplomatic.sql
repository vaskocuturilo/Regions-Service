DROP TABLE IF EXISTS `italian_diplomatic_entity`;
CREATE TABLE `italian_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `italian_diplomatic_entity` WRITE;
INSERT INTO `italian_diplomatic_entity` VALUES
(1,'Albania','AA'),
(2,'Austria','AC'),
(3,'Belgium','AE'),
(4,'Bulgaria','AG'),
(5,'Czech Republic','AK'),
(6,'Cyprus','AM'),
(7,'Denmark','AN'),
(8,'Finland','AP'),
(9,'France','AQ'),
(10,'Germany','AU'),
(11,'West Germany','AV'),
(12,'East Germany','BA'),
(13,'United Kingdom','BC'),
(14,'Slovenia','BF'),
(15,'Greece','BG'),
(16,'Ireland','BM'),
(17,'Italy (Holy See)','BN'),
(18,'Serbia','BP'),
(19,'Croatia','BQ'),
(20,'Luxembourg','BR'),
(21,'Malta','BS'),
(22,'Monaco','BT'),
(23,'Norway','BV'),
(24,'Netherlands','BX'),
(25,'Poland','CA'),
(26,'Portugal','CC'),
(27,'Romania','CE'),
(28,'San Marino','CG'),
(29,'Spain','CH'),
(30,'Switzerland','CM'),
(31,'Sweden','CN'),
(32,'Switzerland','CQ'),
(33,'Turkey','CR'),
(34,'Hungary','CX'),
(35,'Russia (formerly  Soviet Union)','DA'),
(36,'Ukraine','DC'),
(37,'Uzbekistan','DD'),
(38,'Vatican City (Apostolic Nunciature)','DE'),
(39,'Slovenia','DF'),
(40,'North Macedonia','DG'),
(41,'Bosnia and Herzegovina','DH'),
(42,'Slovakia','DL'),
(43,'Armenia','DM'),
(44,'Georgia','DN'),
(45,'Kazakhstan','DP'),
(46,'Latvia','DQ'),
(47,'Belarus','DR'),
(48,'Lithuania','DS'),
(49,'Moldova','DT'),
(50,'Iceland','DV'),
(51,'Azerbaijan','DZ'),
(52,'Burkina Faso','EA'),
(53,'Dominica','EB'),
(54,'Uganda','EC'),
(55,'Burundi','ED'),
(56,'Rwanda','EF'),
(57,'Zimbabwe','EG'),
(58,'Qatar','EH'),
(59,'Chad','EL'),
(60,'Mauritania','EM'),
(61,'Eritrea','EN'),
(62,'Mali','EP'),
(63,'Belize','ER'),
(64,'Equatorial Guinea (c/o FAO)','ES'),
(65,'Kosovo','ET'),
(66,'Afghanistan','GA'),
(67,'Saudi Arabia','GB'),
(68,'Bangladesh','GC'),
(69,'Myanmar','GD'),
(70,'Taiwan','GE'),
(71,'China','GF'),
(72,'Philippines','GQ'),
(73,'North Korea','GS'),
(74,'South Korea','GM'),
(75,'United Arab Emirates','GP'),
(76,'Japan','GS'),
(77,'Jordan','GZ'),
(78,'India','HA'),
(79,'Indonesia','HC'),
(80,'Iran','HE'),
(81,'Iraq','HF'),
(82,'Israel','HL'),
(83,'Iraq','HP'),
(84,'Kuwait','HQ'),
(85,'Lebanon','HR'),
(86,'Malaysia','HS'),
(87,'Oman','HT'),
(88,'Pakistan','HV'),
(89,'Syria','HX'),
(90,'Sri Lanka','LA'),
(91,'Thailand','LB'),
(92,'Vietnam','LE'),
(93,'Yemen','LF'),
(94,'Montenegro','LH'),
(95,'Timor-Leste','LM'),
(96,'Algeria','NA'),
(97,'Angola','NC'),
(98,'Cameroon','ND'),
(99,'Cape Verde','NF'),
(100,'Central African Republic','NG'),
(101,'Republic of the Congo','NH'),
(102,'Ivory Coast','NL'),
(103,'Egypt','NM'),
(104,'Ethiopia','NR'),
(105,'Gabon','NT'),
(106,'Ghana','NX'),
(107,'Guinea','PA'),
(108,'Kenya','PB'),
(109,'Lesotho','PC'),
(110,'Liberia','PD'),
(111,'Libya','PE'),
(112,'Madagascar','PL'),
(113,'Morocco','PN'),
(114,'Nigeria','PQ'),
(115,'Senegal','PS'),
(116,'Sierra Leone','PT'),
(117,'Mozambique','PV'),
(118,'Somalia','PX'),
(119,'South Africa','QA'),
(120,'Sudan','QC'),
(121,'Tanzania','QE'),
(122,'Tunisia','QG'),
(123,'Democratic Republic of the Congo','QL'),
(124,'Zambia','QN'),
(125,'Niger','QP'),
(126,'Canada','SA'),
(127,'Mexico','SD'),
(128,'United States','SF'),
(129,'United States','SH'),
(130,'United States','SL'),
(131,'United States','SN'),
(132,'United States','SQ'),
(133,'Costa Rica','TA'),
(134,'Cuba','TC'),
(135,'Dominican Republic','TE'),
(136,'Ecuador','TF'),
(137,'Jamaica','TG'),
(138,'Guatemala','TH'),
(139,'Haiti','TL'),
(140,'Honduras','TM'),
(141,'Nicaragua','TP'),
(142,'Panama','TQ'),
(143,'El Salvador','TS'),
(144,'Argentina','UA'),
(145,'Bolivia','UE'),
(146,'Brazil','UF'),
(147,'Chile','UH'),
(148,'Colombia','UL'),
(149,'Paraguay','UN'),
(150,'Peru','UP'),
(151,'Uruguay','US'),
(152,'Venezuela','UT'),
(153,'Argentina','VA'),
(154,'Brazil','VF'),
(155,'Colombia','VL'),
(156,'Uruguay','VS'),
(157,'S.M.O.M and  Palestine','XA'),
(158,'FAO,  United Nations, International organizations, and  European Union','XC'),
(159,'FAO,  United Nations, International organizations, and  European Union','XD'),
(160,'FAO,  United Nations, International organizations, and  European Union','XE'),
(161,'FAO,  United Nations, International organizations, and  European Union','XF'),
(162,'FAO,  United Nations, International organizations, and  European Union','XH'),
(163,'Vatican City','XG'),
(164,'Australia','ZA'),
(165,'New Zealand','ZC'),
(166,'Philippines','GQ');
UNLOCK TABLES;

ALTER TABLE italian_diplomatic_entity ADD INDEX italian_diplomatic_index (description, region);