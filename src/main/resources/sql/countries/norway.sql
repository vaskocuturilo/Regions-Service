DROP TABLE IF EXISTS `norway_entity`;
CREATE TABLE `norway_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `norway_entity` WRITE;
/*!40000 ALTER TABLE `armenia_entity` DISABLE KEYS */;
INSERT INTO `norway_entity` VALUES
(1,'Asker and Bærum, Viken','BL'),
(2,'Asker and Bærum, Viken','BN'),
(3,'Asker and Bærum, Viken','BP'),
(4,'Asker and Bærum, Viken','BR'),
(5,'Asker and Bærum, Viken','BS'),
(6,'Asker and Bærum, Viken','BT'),
(7,'Asker and Bærum, Viken','BU'),
(8,'Asker and Bærum, Viken','BV'),
(9,'Asker and Bærum, Viken','BX'),
(10,'Asker and Bærum, Viken','BY'),
(11,'Asker and Bærum, Viken','BZ'),
(12,'Asker and Bærum, Viken','CA'),
(13,'Asker and Bærum, Viken','CB'),
(14,'Drammen, Viken','KE'),
(15,'Drammen, Viken','KF'),
(16,'Drammen, Viken','KH'),
(17,'Drammen, Viken','KJ'),
(18,'Drammen, Viken','KK'),
(19,'Drammen, Viken','KL'),
(20,'Drammen, Viken','KN'),
(21,'Drammen, Viken','KN'),
(22,'Drammen, Viken','KP'),
(23,'Drammen, Viken','KR'),
(24,'Drammen, Viken','KS'),
(25,'Drøbak, Viken','BC'),
(26,'Drøbak, Viken','BD'),
(27,'Drøbak, Viken','BE'),
(28,'Drøbak, Viken','BF'),
(29,'Drøbak, Viken','BH'),
(30,'Drøbak, Viken','BJ'),
(31,'Drøbak, Viken','BK'),
(32,'Gol, Viken','KB'),
(33,'Gol, Viken','KC'),
(34,'Gol, Viken','KD'),
(35,'Hafslund, Viken','AD'),
(36,'Hafslund, Viken','AR'),
(37,'Hafslund, Viken','AS'),
(38,'Hafslund, Viken','AT'),
(39,'Hafslund, Viken','AU'),
(40,'Hafslund, Viken','AV'),
(41,'Hafslund, Viken','AW'),
(42,'Hafslund, Viken','DW'),
(43,'Hafslund, Viken','FL'),
(44,'Hafslund, Viken','ES'),
(45,'Halden, Viken','AA'),
(46,'Halden, Viken','AB'),
(47,'Halden, Viken','AC'),
(48,'Hønefoss, Viken','JU'),
(49,'Hønefoss, Viken','JV'),
(50,'Hønefoss, Viken','JX'),
(51,'Hønefoss, Viken','JY'),
(52,'Hønefoss, Viken','JZ'),
(53,'Hønefoss, Viken','KA'),
(54,'Jessheim, Viken','CV'),
(55,'Jessheim, Viken','CX'),
(56,'Jessheim, Viken','CY'),
(57,'Jessheim, Viken','CZ'),
(58,'Jessheim, Viken','CU'),
(59,'Kongsberg, Viken','KT'),
(60,'Kongsberg, Viken','KU'),
(61,'Kongsberg, Viken','KV'),
(62,'Kongsberg, Viken','KX'),
(63,'Kongsberg, Viken','KY'),
(64,'Lillestrøm, Viken','CC'),
(65,'Lillestrøm, Viken','CE'),
(66,'Lillestrøm, Viken','CF'),
(67,'Lillestrøm, Viken','CH'),
(68,'Lillestrøm, Viken','CJ'),
(69,'Lillestrøm, Viken','CK'),
(70,'Lillestrøm, Viken','CL'),
(71,'Lillestrøm, Viken','CN'),
(72,'Lillestrøm, Viken','CP'),
(73,'Lillestrøm, Viken','CR'),
(74,'Lillestrøm, Viken','CS'),
(75,'Lillestrøm, Viken','CT'),
(76,'Lillestrøm, Viken','CU'),
(77,'Moss, Viken','AX'),
(78,'Moss, Viken','AY'),
(79,'Moss, Viken','AZ'),
(80,'Moss, Viken','BA'),
(81,'Mysen, Viken','AJ'),
(82,'Mysen, Viken','AK'),
(83,'Mysen, Viken','AL'),
(84,'Mysen, Viken','AN'),
(85,'Mysen, Viken','AP'),
(86,'Mysen, Viken','FN'),
(87,'Mysen, Viken','BW'),
(88,'Sarpsborg, Viken','AE'),
(89,'Sarpsborg, Viken','AF'),
(90,'Sarpsborg, Viken','AH'),
(91,'Oslo, Oslo','DA'),
(92,'Oslo, Oslo','DB'),
(93,'Oslo, Oslo','DC'),
(94,'Oslo, Oslo','DD'),
(95,'Oslo, Oslo','DE'),
(96,'Oslo, Oslo','DF'),
(97,'Oslo, Oslo','DH'),
(98,'Oslo, Oslo','DJ'),
(99,'Oslo, Oslo','DK'),
(100,'Oslo, Oslo','DL'),
(101,'Oslo, Oslo','DN'),
(102,'Oslo, Oslo','DP'),
(103,'Oslo, Oslo','DR'),
(104,'Oslo, Oslo','DS'),
(105,'Oslo, Oslo','DT'),
(106,'Oslo, Oslo','DU'),
(107,'Oslo, Oslo','DV'),
(108,'Oslo, Oslo','DX'),
(109,'Oslo, Oslo','DY'),
(110,'Oslo, Oslo','DZ'),
(111,'Oslo, Oslo','EA'),
(112,'Oslo, Oslo','EF'),
(113,'Oslo, Oslo','EH'),
(114,'Oslo, Oslo','EJ'),
(115,'Oslo, Oslo','EN'),
(116,'Oslo, Oslo','EP'),
(117,'Oslo, Oslo','ER'),
(118,'Oslo, Oslo','EU'),
(119,'Elverum, Innlandet','HB'),
(120,'Elverum, Innlandet','HC'),
(121,'Elverum, Innlandet','HD'),
(122,'Elverum, Innlandet','HE'),
(123,'Elverum, Innlandet','HA'),
(124,'Elverum, Innlandet','FZ'),
(125,'Fagernes, Innlandet','JR'),
(126,'Fagernes, Innlandet','JS'),
(127,'Fagernes, Innlandet','JT'),
(128,'Gjøvik, Innlandet','JC'),
(129,'Gjøvik, Innlandet','JD'),
(130,'Gjøvik, Innlandet','JE'),
(131,'Gjøvik, Innlandet','JF'),
(132,'Gjøvik, Innlandet','JH'),
(133,'Gjøvik, Innlandet','JJ'),
(134,'Gjøvik, Innlandet','JK'),
(135,'Gjøvik, Innlandet','JL'),
(136,'Gjøvik, Innlandet','JN'),
(137,'Gjøvik, Innlandet','JP'),
(138,'Hamar, Innlandet','FS'),
(139,'Hamar, Innlandet','FT'),
(140,'Hamar, Innlandet','FU'),
(141,'Hamar, Innlandet','FV'),
(142,'Hamar, Innlandet','FX'),
(143,'Hamar, Innlandet','FY'),
(144,'Hamar, Innlandet','FZ'),
(145,'Hamar, Innlandet','FW'),
(146,'Hamar, Innlandet','ET'),
(147,'Kongsvinger, Innlandet','HJ'),
(148,'Kongsvinger, Innlandet','HK'),
(149,'Kongsvinger, Innlandet','HL'),
(150,'Kongsvinger, Innlandet','HN'),
(151,'Kongsvinger, Innlandet','HP'),
(152,'Kongsvinger, Innlandet','HR'),
(153,'Lillehammer, Innlandet','HS'),
(154,'Lillehammer, Innlandet','HT'),
(155,'Lillehammer, Innlandet','HU'),
(156,'Lillehammer, Innlandet','HV'),
(157,'Lillehammer, Innlandet','HX'),
(158,'Lillehammer, Innlandet','FB'),
(159,'Otta, Innlandet','HZ'),
(160,'Otta, Innlandet','JA'),
(161,'Otta, Innlandet','JB'),
(162,'Tynset, Innlandet','HF'),
(163,'Tynset, Innlandet','HH'),
(164,'Horten, Vestfold og Telemark','KZ'),
(165,'Horten, Vestfold og Telemark','LA'),
(166,'Horten, Vestfold og Telemark','LB'),
(167,'Horten, Vestfold og Telemark','LC'),
(168,'Horten, Vestfold og Telemark','LD'),
(169,'Larvik, Vestfold og Telemark','LS'),
(170,'Larvik, Vestfold og Telemark','LT'),
(171,'Larvik, Vestfold og Telemark','LU'),
(172,'Larvik, Vestfold og Telemark','LV'),
(173,'Larvik, Vestfold og Telemark','LX'),
(174,'Larvik, Vestfold og Telemark','LZ'),
(175,'Larvik, Vestfold og Telemark','NA'),
(176,'Larvik, Vestfold og Telemark','NB'),
(177,'Larvik, Vestfold og Telemark','NC'),
(178,'Notodden, Vestfold og Telemark','NV'),
(179,'Notodden, Vestfold og Telemark','NX'),
(180,'Notodden, Vestfold og Telemark','NY'),
(181,'Notodden, Vestfold og Telemark','NZ'),
(182,'Rjukan, Vestfold og Telemark','PA'),
(183,'Rjukan, Vestfold og Telemark','PB'),
(184,'Sandefjord, Vestfold og Telemark','LY'),
(185,'Sandefjord, Vestfold og Telemark','NA'),
(186,'Skien, Vestfold og Telemark','ND'),
(187,'Skien, Vestfold og Telemark','NE'),
(188,'Skien, Vestfold og Telemark','NF'),
(189,'Skien, Vestfold og Telemark','NH'),
(190,'Skien, Vestfold og Telemark','NJ'),
(191,'Skien, Vestfold og Telemark','NK'),
(192,'Skien, Vestfold og Telemark','NL'),
(193,'Skien, Vestfold og Telemark','NN'),
(194,'Skien, Vestfold og Telemark','NP'),
(195,'Skien, Vestfold og Telemark','NR'),
(196,'Skien, Vestfold og Telemark','NT'),
(197,'Skien, Vestfold og Telemark','NU'),
(198,'Tønsberg, Vestfold og Telemark','LH'),
(199,'Tønsberg, Vestfold og Telemark','LJ'),
(200,'Tønsberg, Vestfold og Telemark','LK'),
(201,'Tønsberg, Vestfold og Telemark','LL'),
(202,'Tønsberg, Vestfold og Telemark','LN'),
(203,'Tønsberg, Vestfold og Telemark','LP'),
(204,'Tønsberg, Vestfold og Telemark','LR'),
(205,'Tønsberg, Vestfold og Telemark','LD'),
(206,'Arendal, Agder','PC'),
(207,'Arendal, Agder','PD'),
(208,'Arendal, Agder','PE'),
(209,'Arendal, Agder','PF'),
(210,'Arendal, Agder','PH'),
(211,'Arendal, Agder','PJ'),
(212,'Arendal, Agder','PK'),
(213,'Flekkefjord, Agder','RA'),
(214,'Flekkefjord, Agder','RB'),
(215,'Kristiansand, Agder','PN'),
(216,'Kristiansand, Agder','PP'),
(217,'Kristiansand, Agder','PR'),
(218,'Kristiansand, Agder','PS'),
(219,'Kristiansand, Agder','PT'),
(220,'Kristiansand, Agder','PU'),
(221,'Kristiansand, Agder','PV'),
(222,'Kristiansand, Agder','PW'),
(223,'Mandal, Agder','PX'),
(224,'Mandal, Agder','PY'),
(225,'Mandal, Agder','PZ'),
(226,'Mandal, Agder','RC'),
(227,'Mandal, Agder','RD'),
(228,'Setesdal, Agder','PL'),
(229,'Setesdal, Agder','LF'),
(230,'Egersund, Rogaland','RZ'),
(231,'Egersund, Rogaland','SA'),
(232,'Egersund, Rogaland','SB'),
(233,'Haugesund, Rogaland','SC'),
(234,'Haugesund, Rogaland','SD'),
(235,'Haugesund, Rogaland','SE'),
(236,'Haugesund, Rogaland','SF'),
(237,'Haugesund, Rogaland','SH'),
(238,'Haugesund, Rogaland','SJ'),
(239,'Haugesund, Rogaland','SK'),
(240,'Haugesund, Rogaland','SL'),
(241,'Stavanger, Rogaland','RE'),
(242,'Stavanger, Rogaland','RF'),
(243,'Stavanger, Rogaland','RH'),
(244,'Stavanger, Rogaland','RJ'),
(245,'Stavanger, Rogaland','RK'),
(246,'Stavanger, Rogaland','RL'),
(247,'Stavanger, Rogaland','RN'),
(248,'Stavanger, Rogaland','RP'),
(249,'Stavanger, Rogaland','RR'),
(250,'Stavanger, Rogaland','RS'),
(251,'Stavanger, Rogaland','RT'),
(252,'Stavanger, Rogaland','RU'),
(253,'Stavanger, Rogaland','RV'),
(254,'Stavanger, Rogaland','RX'),
(255,'Stavanger, Rogaland','RY'),
(256,'Stavanger, Rogaland','RW'),
(257,'Bergen, Vestland','SN'),
(258,'Bergen, Vestland','SP'),
(259,'Bergen, Vestland','SR'),
(260,'Bergen, Vestland','SS'),
(261,'Bergen, Vestland','ST'),
(262,'Bergen, Vestland','SU'),
(263,'Bergen, Vestland','SV'),
(264,'Bergen, Vestland','SX'),
(265,'Bergen, Vestland','SY'),
(266,'Bergen, Vestland','SZ'),
(267,'Bergen, Vestland','TA'),
(268,'Bergen, Vestland','TB'),
(269,'Bergen, Vestland','TC'),
(270,'Bergen, Vestland','TD'),
(271,'Bergen, Vestland','TE'),
(272,'Bergen, Vestland','HW'),
(273,'Førde, Vestland','TV'),
(274,'Førde, Vestland','TX'),
(275,'Førde, Vestland','TY'),
(276,'Førde, Vestland','TZ'),
(277,'Nordfjordeid, Vestland','UA'),
(278,'Nordfjordeid, Vestland','UB'),
(279,'Odda, Vestland','TS'),
(280,'Odda, Vestland','TT'),
(281,'Odda, Vestland','TU'),
(282,'Sogndal, Vestland','UC'),
(283,'Sogndal, Vestland','UD'),
(284,'Stord, Vestland','TL'),
(285,'Stord, Vestland','TN'),
(286,'Stord, Vestland','TP'),
(287,'Stord, Vestland','TR'),
(288,'Voss, Vestland','TF'),
(289,'Voss, Vestland','TH'),
(290,'Voss, Vestland','TJ'),
(291,'Voss, Vestland','TK'),
(292,'Kristiansund, Møre og Romsdal','UX'),
(293,'Kristiansund, Møre og Romsdal','UY'),
(294,'Kristiansund, Møre og Romsdal','UZ'),
(295,'Kristiansund, Møre og Romsdal','VA'),
(296,'Molde, Møre og Romsdal','UR'),
(297,'Molde, Møre og Romsdal','US'),
(298,'Molde, Møre og Romsdal','UT'),
(299,'Molde, Møre og Romsdal','UU'),
(300,'Molde, Møre og Romsdal','UV'),
(301,'Sunndalsøra, Møre og Romsdal','VB'),
(302,'Sunndalsøra, Møre og Romsdal','VC'),
(303,'Ørsta, Møre og Romsdal','UN'),
(304,'Ørsta, Møre og Romsdal','UP'),
(305,'Ørsta, Møre og Romsdal','BB'),
(306,'Ålesund, Møre og Romsdal','UE'),
(307,'Ålesund, Møre og Romsdal','UF'),
(308,'Ålesund, Møre og Romsdal','UH'),
(309,'Ålesund, Møre og Romsdal','UJ'),
(310,'Ålesund, Møre og Romsdal','UK'),
(311,'Ålesund, Møre og Romsdal','UL'),
(312,'Brekstad, Trøndelag','XA'),
(313,'Brekstad, Trøndelag','XB'),
(314,'Brekstad, Trøndelag','XC'),
(315,'Levanger, Trøndelag','XK'),
(316,'Levanger, Trøndelag','XL'),
(317,'Levanger, Trøndelag','VW'),
(318,'Namsos, Trøndelag','XR'),
(319,'Namsos, Trøndelag','XS'),
(320,'Namsos, Trøndelag','XT'),
(321,'Namsos, Trøndelag','XU'),
(322,'Orkdal, Trøndelag','VX'),
(323,'Orkdal, Trøndelag','VY'),
(324,'Orkdal, Trøndelag','VZ'),
(325,'Steinkjer, Trøndelag','XD'),
(326,'Steinkjer, Trøndelag','XE'),
(327,'Steinkjer, Trøndelag','XF'),
(328,'Steinkjer, Trøndelag','XH'),
(329,'Steinkjer, Trøndelag','XJ'),
(330,'Steinkjer, Trøndelag','XW'),
(331,'Stjørdal, Trøndelag','XN'),
(332,'Støren, Trøndelag','VS'),
(333,'Støren, Trøndelag','VT'),
(334,'Trondheim, Trøndelag','FP'),
(335,'Trondheim, Trøndelag','VD'),
(336,'Trondheim, Trøndelag','VE'),
(337,'Trondheim, Trøndelag','VF'),
(338,'Trondheim, Trøndelag','VH'),
(339,'Trondheim, Trøndelag','VJ'),
(340,'Trondheim, Trøndelag','VK'),
(341,'Trondheim, Trøndelag','VL'),
(342,'Trondheim, Trøndelag','VN'),
(343,'Trondheim, Trøndelag','VP'),
(344,'Trondheim, Trøndelag','VR'),
(345,'Trondheim, Trøndelag','VS'),
(346,'Trondheim, Trøndelag','VU'),
(347,'Trondheim, Trøndelag','VV'),
(348,'Trondheim, Trøndelag','NW'),
(349,'Bodø, Trøndelag','YE'),
(350,'Bodø, Trøndelag','YF'),
(351,'Bodø, Trøndelag','YH'),
(352,'Bodø, Trøndelag','YJ'),
(353,'Bodø, Trøndelag','FD'),
(354,'Bodø, Trøndelag','EZ'),
(355,'Fauske, Nordland','YK'),
(356,'Fauske, Nordland','YL'),
(357,'Mo i Rana, Nordland','YA'),
(358,'Mo i Rana, Nordland','YB'),
(359,'Mo i Rana, Nordland','YC'),
(360,'Mo i Rana, Nordland','YD'),
(361,'Mosjøen, Nordland','XV'),
(362,'Mosjøen, Nordland','XX'),
(363,'Mosjøen, Nordland','XY'),
(364,'Mosjøen, Nordland','XZ'),
(365,'Mosjøen, Nordland','FA'),
(366,'Narvik, Nordland','YN'),
(367,'Narvik, Nordland','YP'),
(368,'Narvik, Nordland','YR'),
(369,'Narvik, Nordland','YS'),
(370,'Sortland, Nordland','YU'),
(371,'Sortland, Nordland','YV'),
(372,'Sortland, Nordland','YX'),
(373,'Svolvær, Nordland','YT'),
(374,'Svolvær, Nordland','YY'),
(375,'Alta, Troms og Finnmark','ZT'),
(376,'Alta, Troms og Finnmark','ZU'),
(377,'Alta, Troms og Finnmark','ZV'),
(378,'Alta, Troms og Finnmark','ZY'),
(379,'Alta, Troms og Finnmark','ZW'),
(380,'Alta, Troms og Finnmark','UW'),
(381,'Finnsnes, Troms og Finnmark','ZD'),
(382,'Finnsnes, Troms og Finnmark','ZF'),
(383,'Finnsnes, Troms og Finnmark','ZJ'),
(384,'Finnsnes, Troms og Finnmark','EX'),
(385,'Hammerfest, Troms og Finnmark','ZX'),
(386,'Hammerfest, Troms og Finnmark','FF'),
(387,'Hammerfest, Troms og Finnmark','EX'),
(388,'Harstad, Troms og Finnmark','YZ'),
(389,'Harstad, Troms og Finnmark','ZA'),
(390,'Harstad, Troms og Finnmark','ZB'),
(391,'Harstad, Troms og Finnmark','TW'),
(392,'Kirkenes, Troms og Finnmark','ZS'),
(393,'Kirkenes, Troms og Finnmark','EY'),
(394,'Lakselv, Troms og Finnmark','ZZ'),
(395,'Lakselv, Troms og Finnmark','CW'),
(396,'Storslett, Troms og Finnmark','FK'),
(397,'Storslett, Troms og Finnmark','SW'),
(398,'Tromsø, Troms og Finnmark','ZC'),
(399,'Tromsø, Troms og Finnmark','ZE'),
(400,'Tromsø, Troms og Finnmark','ZH'),
(401,'Tromsø, Troms og Finnmark','ZK'),
(402,'Tromsø, Troms og Finnmark','ZL'),
(403,'Tromsø, Troms og Finnmark','FC'),
(404,'Vadsø, Troms og Finnmark','FR'),
(405,'Vadsø, Troms og Finnmark','ZP'),
(406,'Vadsø, Troms og Finnmark','ZR'),
(407,'Vadsø, Troms og Finnmark','LE'),
(408,'Svalbard, Troms og Finnmark','ZN'),
(409,'Svalbard, Troms og Finnmark','FH'),
(410,'Electrically powered vehicles','EL'),
(411,'Electrically powered vehicles','EK'),
(412,'Electrically powered vehicles','EV'),
(413,'Electrically powered vehicles','EB'),
(414,'Electrically powered vehicles','EC'),
(415,'Electrically powered vehicles','ED'),
(416,'Electrically powered vehicles','EE'),
(417,'Former military vehicles','FE'),
(418,'autogas/LPG (liquified petroleum gas) or other gas powered vehicles','GA'),
(419,'Hydrogen powered vehicles','HY');
UNLOCK TABLES;

ALTER TABLE norway_entity ADD INDEX norway_index (description, region);