DROP TABLE IF EXISTS `poland_entity`;

CREATE TABLE `poland_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `poland_entity` WRITE;
/*!40000 ALTER TABLE `poland_entity` DISABLE KEYS */;
INSERT INTO `poland_entity` VALUES
(1,'Województwo Lubelskie, Biała Podlaska','LB'),
(2,'Województwo Lubelskie, Chełm','LC'),
(3,'Województwo Lubelskie, Lublin','LU'),
(4,'Województwo Lubelskie, Zamość','LZ'),
(5,'Województwo Lubelskie, Biała Podlaska powiat','LBI'),
(6,'Województwo Lubelskie, Biłgoraj','LBL'),
(7,'Województwo Lubelskie, Chełm powiat','LCH'),
(8,'Województwo Lubelskie, Hrubieszów','LHR'),
(9,'Województwo Lubelskie, Janów Lubelski','LJA'),
(10,'Województwo Lubelskie, Krasnystaw','LKS'),
(11,'Województwo Lubelskie, Kraśnik','LKR'),
(12,'Województwo Lubelskie, Lubartów','LLB'),
(13,'Województwo Lubelskie, Lublin powiat','LUB'),
(14,'Województwo Lubelskie, Łęczna','LLE'),
(15,'Województwo Lubelskie, Łuków','LLU'),
(16,'Województwo Lubelskie, Opole Lubelskie','LOP'),
(17,'Województwo Lubelskie, Parczew','LPA'),
(18,'Województwo Lubelskie, Puławy','LPU'),
(19,'Województwo Lubelskie, Radzyń Podlaski','LRA'),
(20,'Województwo Lubelskie, Ryki','LRY'),
(21,'Województwo Lubelskie, Świdnik','LSW'),
(22,'Województwo Lubelskie, Tomaszów Lubelski','LTM'),
(23,'Województwo Lubelskie, Włodawa','LWL'),
(24,'Województwo Lubelskie, Zamość powiat','LZA'),
(25,'Województwo Lubelskie, Gorzów','FG'),
(26,'Województwo Lubelskie, Zielona Góra','FZ'),
(27,'Województwo Lubelskie, Gorzów Wielkopolski powiat','FGW'),
(28,'Województwo Lubelskie, Krosno Odrzańskie','FKR'),
(29,'Województwo Lubelskie, Międzyrzecz','FMI'),
(30,'Województwo Lubelskie, Nowa Sól','FNW'),
(31,'Województwo Lubelskie, Słubice','FSL'),
(32,'Województwo Lubelskie, Strzelce Krajeńskie','FSD'),
(33,'Województwo Lubelskie, Sulęczyn','FSU'),
(34,'Województwo Lubelskie, Świebodzin','FSW'),
(35,'Województwo Lubelskie, Zielona Góra powiat','FZI'),
(36,'Województwo Lubelskie, Żagań','FZG'),
(37,'Województwo Lubelskie, Żary','FZA'),
(38,'Województwo mazowieckie, Ostrołęka','WO'),
(39,'Województwo mazowieckie, Płock','WP'),
(40,'Województwo mazowieckie, Radom','WR'),
(41,'Województwo mazowieckie, Siedlce','WS'),
(42,'Województwo mazowieckie, Białobrzegi','WBR'),
(43,'Województwo mazowieckie, Ciechanów','WCI'),
(44,'Województwo mazowieckie, Garwolin','WG'),
(45,'Województwo mazowieckie, Gostynin','WGS'),
(46,'Województwo mazowieckie, Grodzisk','WGM'),
(47,'Województwo mazowieckie, Grójec','WGR'),
(48,'Województwo mazowieckie, Kozienice','WKZ'),
(49,'Województwo mazowieckie, Legionowo','WL'),
(50,'Województwo mazowieckie, Lipsko','WLI'),
(51,'Województwo mazowieckie, Łosice','WLS'),
(52,'Województwo mazowieckie, Maków Mazowiecki','WMA'),
(53,'Województwo mazowieckie, Mińsk Mazowiecki','WM'),
(54,'Województwo mazowieckie, Mława','WML'),
(55,'Województwo mazowieckie, Nowy Dwór Mazowiecki','WND'),
(56,'Województwo mazowieckie, Ostrołęka powiat','WOS'),
(57,'Województwo mazowieckie, Ostrów Mazowiecka','WOR'),
(58,'Województwo mazowieckie, Otwock','WOT'),
(59,'Województwo mazowieckie, Piaseczno','WPI'),
(60,'Województwo mazowieckie, Płock powiat','WPL'),
(61,'Województwo mazowieckie, Płońsk','WPN'),
(62,'Województwo mazowieckie, Pruszków','WPR'),
(63,'Województwo mazowieckie, Przasnysz','WPZ'),
(64,'Województwo mazowieckie, Przysucha','WPY'),
(65,'Województwo mazowieckie, Pułtusk','WPU'),
(66,'Województwo mazowieckie, Radom powiat','WRA'),
(67,'Województwo mazowieckie, Siedlce powiat','WSI'),
(68,'Województwo mazowieckie, Sierpc','WSE'),
(69,'Województwo mazowieckie, Sochaczew','WSC'),
(70,'Województwo mazowieckie, Sokołów Podlaski','WSK'),
(71,'Województwo mazowieckie, Szydłowiec','WSZ'),
(72,'Województwo mazowieckie, Warszawa-Bemowo','WB'),
(73,'Województwo mazowieckie, Warszawa-Białołęka','WA'),
(74,'Województwo mazowieckie, Warszawa-Bielany','WD'),
(75,'Województwo mazowieckie, Warszawa-Rembertów','WW-A'),
(76,'Województwo mazowieckie, Warszawa-Targówek','WJ'),
(77,'Województwo mazowieckie, Warszawa-Ursus','WK'),
(78,'Województwo mazowieckie, Warszawa-Ursynów','WN'),
(79,'Województwo mazowieckie, Warszawa-Wawer','WT'),
(80,'Województwo mazowieckie, Warszawa-Wilanów','WW-F'),
(81,'Województwo mazowieckie, Warszawa-Wilanów','WW-G'),
(82,'Województwo mazowieckie, Warszawa-Wilanów','WW-H'),
(83,'Województwo mazowieckie, Warszawa-Wilanów','WW-J'),
(84,'Województwo mazowieckie, Warszawa-Wilanów','WW-W'),
(85,'Województwo mazowieckie, Warszawa-Włochy','WW-K'),
(86,'Województwo mazowieckie, Warszawa-Włochy','WW-L'),
(87,'Województwo mazowieckie, Warszawa-Włochy','WW-M'),
(88,'Województwo mazowieckie, Warszawa-Włochy','WW-N'),
(89,'Województwo mazowieckie, Warszawa-Włochy','WW-V'),
(90,'Województwo mazowieckie, Warszawa-Zachód','WZ'),
(91,'Województwo mazowieckie, Węgrów','WWE'),
(92,'Województwo mazowieckie, Wołomin','WWL'),
(93,'Województwo mazowieckie, Wyszków','WWY'),
(94,'Województwo mazowieckie, Zwoleń','WZW'),
(95,'Województwo mazowieckie, Żyrardów','WZY'),
(96,'Województwo mazowieckie, Żuromin','WZU'),
(97,'Województwo mazowieckie, Warszawa-Mokotów','WE'),
(98,'Województwo mazowieckie, Warszawa-Ochota','WU'),
(99,'Województwo mazowieckie, Warszawa-Praga Południe','WF'),
(100,'Województwo mazowieckie, Warszawa-Praga Północ','WH'),
(101,'Województwo mazowieckie, Warszawa-Śródmieście','WI'),
(102,'Województwo mazowieckie, Warszawa-Wola','WY'),
(103,'Województwo mazowieckie, Warszawa-Żoliborz','WX'),
(104,'Województwo opolskie, Opole','OP'),
(105,'Województwo opolskie, Brzeg','OB'),
(106,'Województwo opolskie, Głubczyce','OGL'),
(107,'Województwo opolskie, Kędzierzyn Koźle','OK'),
(108,'Województwo opolskie, Kluczbork','OKL'),
(109,'Województwo opolskie, Krapkowice','OKR'),
(110,'Województwo opolskie, Namysłów','ONA'),
(111,'Województwo opolskie, Nysa','ONY'),
(112,'Województwo opolskie, Olesno','OOL'),
(113,'Województwo opolskie, Opole powiat','OPO'),
(114,'Województwo opolskie, Prudnik','OPR'),
(115,'Województwo opolskie, Strzelce Opolskie','OST'),
(116,'Województwo podkarpackie, Krosno','RK'),
(117,'Województwo podkarpackie, Przemyśl','RP'),
(118,'Województwo podkarpackie, Rzeszów','RZ'),
(119,'Województwo podkarpackie, Tarnobrzeg','RT'),
(120,'Województwo podkarpackie, Ustrzyki Dolne','RBI'),
(121,'Województwo podkarpackie, Brzozów','RBR'),
(122,'Województwo podkarpackie, Dębica','RDE'),
(123,'Województwo podkarpackie, Jarosław','RJA'),
(124,'Województwo podkarpackie, Jasło','RJS'),
(125,'Województwo podkarpackie, Kolbuszowa','RKL'),
(126,'Województwo podkarpackie, Krosno powiat','RKR'),
(127,'Województwo podkarpackie, Leżajsk','RLE'),
(128,'Województwo podkarpackie, Lubaczów','RLU'),
(129,'Województwo podkarpackie, Łańcut','RLA'),
(130,'Województwo podkarpackie, Mielec','RMI'),
(131,'Województwo podkarpackie, Nisko','RNI'),
(132,'Województwo podkarpackie, Przemyśl powiat','RPR'),
(133,'Województwo podkarpackie, Przeworsk','RPZ'),
(134,'Województwo podkarpackie, Ropczyce','RRS'),
(135,'Województwo podkarpackie, Rzeszów powiat','RZE'),
(136,'Województwo podkarpackie, Sanok','RSA'),
(137,'Województwo podkarpackie, Stalowa Wola','RST'),
(138,'Województwo podkarpackie, Strzyżów','RSR'),
(139,'Województwo podkarpackie, Tarnobrzeg powiat','RTA'),
(140,'Województwo podlaskie, Białystok','BI'),
(141,'Województwo podlaskie, Łomża','BL'),
(142,'Województwo podlaskie, Suwałki','BS'),
(143,'Województwo podlaskie, Augustów','BAU'),
(144,'Województwo podlaskie, Białystok powiat','BIA'),
(145,'Województwo podlaskie, Bielsk Podlaski','BBI'),
(146,'Województwo podlaskie, Grajewo','BGR'),
(147,'Województwo podlaskie, Hajnówka','BHA'),
(148,'Województwo podlaskie, Kolno','BKL'),
(149,'Województwo podlaskie, Łomża powiat','BLM'),
(150,'Województwo podlaskie, Mońki','BMN'),
(151,'Województwo podlaskie, Sejny','BSE'),
(152,'Województwo podlaskie, Siemiatycze','BSI'),
(153,'Województwo podlaskie, Sokółka','BSK'),
(154,'Województwo podlaskie, Suwałki powiat','BSU'),
(155,'Województwo podlaskie, Wysokie Mazowieckie','BWM'),
(156,'Województwo podlaskie, Zambrów','BZA'),
(157,'Województwo pomorskie, Gdańsk','GD'),
(158,'Województwo pomorskie, Gdynia','GA'),
(159,'Województwo pomorskie, Słupsk','GS'),
(160,'Województwo pomorskie, Sopot','GSP'),
(161,'Województwo pomorskie, Bytów','GBY'),
(162,'Województwo pomorskie, Chojnice','GCH'),
(163,'Województwo pomorskie, Człuchów','GCZ'),
(164,'Województwo pomorskie, Pruszcz Gdański','GDA'),
(165,'Województwo pomorskie, Kartuzy','GKA'),
(166,'Województwo pomorskie, Kościerzyna','GKS'),
(167,'Województwo pomorskie, Kwidzyn','GKW'),
(168,'Województwo pomorskie, Lębork','GLE'),
(169,'Województwo pomorskie, Malbork','GMB'),
(170,'Województwo pomorskie, Nowy Dwór Gdański','GND'),
(171,'Województwo pomorskie, Puck','GPU'),
(172,'Województwo pomorskie, Słupsk powiat','GSL'),
(173,'Województwo pomorskie, Starogard Gdański','GST'),
(174,'Województwo pomorskie, Tczew','GTC'),
(175,'Województwo pomorskie, Wejherowo','GWE'),
(176,'Województwo wielkopolskie, Kalisz','PK'),
(177,'Województwo wielkopolskie, Konin','PKO'),
(178,'Województwo wielkopolskie, Leszno','PL'),
(179,'Województwo wielkopolskie, Poznań','PO'),
(180,'Województwo wielkopolskie, Poznań','PY'),
(181,'Województwo wielkopolskie, Poznań','PZ'),
(182,'Województwo wielkopolskie, Konin','PN'),
(183,'Województwo wielkopolskie, Chodzież','PCH'),
(184,'Województwo wielkopolskie, Czarnków','PCT'),
(185,'Województwo wielkopolskie, Gniezno','PGN'),
(186,'Województwo wielkopolskie, Gostyń','PGS'),
(187,'Województwo wielkopolskie, Grodzisk Wielkopolski','PGO'),
(188,'Województwo wielkopolskie, Jarocin','PJA'),
(189,'Województwo wielkopolskie, Kalisz powiat','PKA'),
(190,'Województwo wielkopolskie, Kępno','PKE'),
(191,'Województwo wielkopolskie, Koło','PKL'),
(192,'Województwo wielkopolskie, Konin powiat','PKN'),
(193,'Województwo wielkopolskie, Kościan','PKS'),
(194,'Województwo wielkopolskie, Krotoszyn','PKR'),
(195,'Województwo wielkopolskie, Leszno powiat','PLE'),
(196,'Województwo wielkopolskie, Międzychód','PMI'),
(197,'Województwo wielkopolskie, Nowy Tomyśl','PNT'),
(198,'Województwo wielkopolskie, Oborniki','POB'),
(199,'Województwo wielkopolskie, Ostrów Wielkopolski','POS'),
(200,'Województwo wielkopolskie, Ostrzeszów','POT'),
(201,'Województwo wielkopolskie, Piła','PP'),
(202,'Województwo wielkopolskie, Pleszew','PPL'),
(203,'Województwo wielkopolskie, Poznań powiat','POZ'),
(204,'Województwo wielkopolskie, Rawicz','PRA'),
(205,'Województwo wielkopolskie, Słupca','PSL'),
(206,'Województwo wielkopolskie, Szamotuły','PSZ'),
(207,'Województwo wielkopolskie, Środa Wielkopolska','PSR'),
(208,'Województwo wielkopolskie, Śrem','PSE'),
(209,'Województwo wielkopolskie, Turek','PTU'),
(210,'Województwo wielkopolskie, Wągrowiec','PWA'),
(211,'Województwo wielkopolskie, Wolsztyn','PWL'),
(212,'Województwo wielkopolskie, Września','PWR'),
(213,'Województwo wielkopolskie, Złotów','PZL'),
(214,'Województwo zachodniopomorskie, Koszalin','ZK'),
(215,'Województwo zachodniopomorskie, Szczecin','ZS'),
(216,'Województwo zachodniopomorskie, Świnoujście','ZSW'),
(217,'Województwo zachodniopomorskie, Białogard','ZBI'),
(218,'Województwo zachodniopomorskie, Choszczno','ZCH'),
(219,'Województwo zachodniopomorskie, Drawsko','ZDR'),
(220,'Województwo zachodniopomorskie, Goleniów','ZGL'),
(221,'Województwo zachodniopomorskie, Gryfice','ZGY'),
(222,'Województwo zachodniopomorskie, Gryfino','ZGR'),
(223,'Województwo zachodniopomorskie, Kamień Pomorski','ZKA'),
(224,'Województwo zachodniopomorskie, Kołobrzeg','ZKL'),
(225,'Województwo zachodniopomorskie, Koszalin powiat','ZKO'),
(226,'Województwo zachodniopomorskie, Myślibórz','ZMY'),
(227,'Województwo zachodniopomorskie, Police','ZPL'),
(228,'Województwo zachodniopomorskie, Pyrzyce','ZPY'),
(229,'Województwo zachodniopomorskie, Sławno','ZSL'),
(230,'Województwo zachodniopomorskie, Stargard Szczeciński','ZST'),
(231,'Województwo zachodniopomorskie, Szczecinek','ZSZ'),
(232,'Województwo zachodniopomorskie, Świdwin','ZSD'),
(233,'Województwo zachodniopomorskie, Wałcz','ZWA'),
(234,'Województwo dolnośląskie, Jelenia Góra','DJ'),
(235,'Województwo dolnośląskie, Legnica','DL'),
(236,'Województwo dolnośląskie, Wałbrzych','DB'),
(237,'Województwo dolnośląskie, Wrocław','DW'),
(238,'Województwo dolnośląskie, Bolesławiec','DBL'),
(239,'Województwo dolnośląskie, Dzierżoniów','DDZ'),
(240,'Województwo dolnośląskie, Głogów','DGL'),
(241,'Województwo dolnośląskie, Góra','DGR'),
(242,'Województwo dolnośląskie, Jawor','DJA'),
(243,'Województwo dolnośląskie, Jelenia Góra powiat','DJE'),
(244,'Województwo dolnośląskie, Kamienna Góra','DKA'),
(245,'Województwo dolnośląskie, Kłodzko','DKL'),
(246,'Województwo dolnośląskie, Legnica powiat','DLE'),
(247,'Województwo dolnośląskie, Lubań','DLB'),
(248,'Województwo dolnośląskie, Lubin','DLU'),
(249,'Województwo dolnośląskie, Lwówek','DLW'),
(250,'Województwo dolnośląskie, Milicz','DMI'),
(251,'Województwo dolnośląskie, Oleśnica','DOL'),
(252,'Województwo dolnośląskie, Oława','DOA'),
(253,'Województwo dolnośląskie, Polkowice','DPL'),
(254,'Województwo dolnośląskie, Strzelin','DST'),
(255,'Województwo dolnośląskie, Środa Śląska','DSR'),
(256,'Województwo dolnośląskie, Świdnica','DSW'),
(257,'Województwo dolnośląskie, Trzebnica','DTR'),
(258,'Województwo dolnośląskie, Wałbrzych powiat','DBA'),
(259,'Województwo dolnośląskie, Wołów','DWL'),
(260,'Województwo dolnośląskie, Wrocław powiat','DWR'),
(261, 'Województwo dolnośląskie, Ząbkowice','DZA'),
(262,'Województwo dolnośląskie, Zgorzelec','DZG'),
(263,'Województwo dolnośląskie, Złotoryja','DZL'),
(264,'Województwo kujawsko-pomorskie, Świecie','CSW'),
(265,'Województwo kujawsko-pomorskie, Toruń powiat','CTR'),
(266,'Województwo kujawsko-pomorskie, Tuchola','CTU'),
(267,'Województwo kujawsko-pomorskie, Wąbrzeźno','CWA'),
(268,'Województwo kujawsko-pomorskie, Włocławek powiat','CWL'),
(269,'Województwo kujawsko-pomorskie, Żnin','CZN'),
(270,'Województwo kujawsko-pomorskie, Bydgoszcz','CB'),
(271,'Województwo kujawsko-pomorskie, Grudziądz','CG'),
(272,'Województwo kujawsko-pomorskie, Toruń','CT'),
(273,'Województwo kujawsko-pomorskie, Włocławek','CW'),
(274,'Województwo kujawsko-pomorskie, Aleksandrów Kujawski','CAL'),
(275,'Województwo kujawsko-pomorskie, Brodnica','CBR'),
(276,'Województwo kujawsko-pomorskie, Bydgoszcz powiat','CBY'),
(277,'Województwo kujawsko-pomorskie, Chełmno','CCH'),
(278,'Województwo kujawsko-pomorskie, Golub-Dobrzyń','CGD'),
(279,'Województwo kujawsko-pomorskie, Grudziądz powiat','CGR'),
(280,'Województwo kujawsko-pomorskie, Inowrocław','CIN'),
(281,'Województwo kujawsko-pomorskie, Lipno','CLI'),
(282,'Województwo kujawsko-pomorskie, Mogilno','CMG'),
(283,'Województwo kujawsko-pomorskie, Nakło nad Notecią','CNA'),
(284,'Województwo kujawsko-pomorskie, Radziejów','CRA'),
(285,'Województwo kujawsko-pomorskie, Rypin','CRY'),
(286,'Województwo kujawsko-pomorskie, Sępólno Krajeńskie','CSE'),
(287,'Województwo łódzkie, Łódź','EL'),
(288,'Województwo łódzkie, Piotrków Trybunalski','EP'),
(289,'Województwo łódzkie, Skierniewice','ES'),
(290,'Województwo łódzkie, Bełchatów','EBE'),
(291,'Województwo łódzkie, Kutno','EKU'),
(292,'Województwo łódzkie, Łask','ELA'),
(293,'Województwo łódzkie, Łęczyca','ELE'),
(294,'Województwo łódzkie, Łowicz','ELC'),
(295,'Województwo łódzkie, Łódź powiat','ELW'),
(296,'Województwo łódzkie, Opoczno','EOP'),
(297,'Województwo łódzkie, Pabianice','EPA'),
(298,'Województwo łódzkie, Pajęczno','EPJ'),
(299,'Województwo łódzkie, Piotrków Trybunalski powiat','EPI'),
(300,'Województwo łódzkie, Poddębice','EPD'),
(301,'Województwo łódzkie, Radomsko','ERA'),
(302,'Województwo łódzkie, Rawa Mazowiecka','ERW'),
(303,'Województwo łódzkie, Sieradz','ESI'),
(304,'Województwo łódzkie, Skierniewice powiat','ESK'),
(305,'Województwo łódzkie, Tomaszów Mazowiecki','ETM'),
(306,'Województwo łódzkie, Wieluń','EWI'),
(307,'Województwo łódzkie, Wieruszów','EWE'),
(308,'Województwo łódzkie, Zduńska Wola','EZD'),
(309,'Województwo łódzkie, Zgierz','EZG'),
(310,'Województwo małopolskie, Kraków','KR'),
(311,'Województwo małopolskie, Nowy Sącz','KN'),
(312,'Województwo małopolskie, Tarnów','KT'),
(313,'Województwo małopolskie, Bochnia','KBC'),
(314,'Województwo małopolskie, Brzesko','KBR'),
(315,'Województwo małopolskie, Chrzanów','KCH'),
(316,'Województwo małopolskie, Dąbrowa Tarnowska','KDA'),
(317,'Województwo małopolskie, Gorlice','KGR'),
(318,'Województwo małopolskie, Kraków powiat','KRA'),
(319,'Województwo małopolskie, Limanowa','KLI'),
(320,'Województwo małopolskie, Miechów','KMI'),
(321,'Województwo małopolskie, Myślenice','KMY'),
(322,'Województwo małopolskie, Nowy Sącz powiat','KNS'),
(323,'Województwo małopolskie, Nowy Targ','KNT'),
(324,'Województwo małopolskie, Olkusz','KOL'),
(325,'Województwo małopolskie, Oświęcim','KOS'),
(326,'Województwo małopolskie, Proszowice','KPR'),
(327,'Województwo małopolskie, Sucha Beskidzka','KSU'),
(328,'Województwo małopolskie, Tarnów powiat','KTA'),
(329,'Województwo małopolskie, Zakopane','KTT'),
(330,'Województwo małopolskie, Wadowice','KWA'),
(331,'Województwo małopolskie, Wieliczka','KWI'),
(332,'Województwo śląskie, Bielsko-Biała','SB'),
(333,'Województwo śląskie, Bytom','SY'),
(334,'Województwo śląskie, Chorzów','SH'),
(335,'Województwo śląskie, Częstochowa','SC'),
(336,'Województwo śląskie, Dąbrowa Górnicza','SD'),
(337,'Województwo śląskie, Gliwice','SG'),
(338,'Województwo śląskie, Jastrzębie Zdrój','SJZ'),
(339,'Województwo śląskie, Jaworzno','SJ'),
(340,'Województwo śląskie, Katowice','SK'),
(341,'Województwo śląskie, Mysłowice','SM'),
(342,'Województwo śląskie, Piekary Śląskie','SPI'),
(343,'Województwo śląskie, Ruda Śląska','SRS'),
(344,'Województwo śląskie, Rybnik miasto','SR'),
(345,'Województwo śląskie, Siemianowice Śląskie','SI'),
(346,'Województwo śląskie, Sosnowiec','SO'),
(347,'Województwo śląskie, Swiętochłowice','SW'),
(348,'Województwo śląskie, Tychy miasto','ST'),
(349,'Województwo śląskie, Zabrze','SZ'),
(350,'Województwo śląskie, Żory','SZO'),
(351,'Województwo śląskie, Będzin','SBE'),
(352,'Województwo śląskie, Bielsko-Biała powiat','SBI'),
(353,'Województwo śląskie, Cieszyn','SCI'),
(354,'Województwo śląskie, Częstochowa powiat','SCZ'),
(355,'Województwo śląskie, Gliwice powiat','SGL'),
(356,'Województwo śląskie, Kłobuck','SKL'),
(357,'Województwo śląskie, Lubliniec','SLU'),
(358,'Województwo śląskie, Mikołów','SMI'),
(359,'Województwo śląskie, Myszków','SMY'),
(360,'Województwo śląskie, Pszczyna','SPS'),
(361,'Województwo śląskie, Racibórz','SRC'),
(362,'Województwo śląskie, Rybnik powiat','SRB'),
(363,'Województwo śląskie, Tarnowskie Góry','STA'),
(364,'Województwo śląskie, Tychy powiat','STY'),
(365,'Województwo śląskie, Wodzisław','SWD'),
(366,'Województwo śląskie, Zawiercie','SZA'),
(367,'Województwo śląskie, Żywiec','SZY'),
(368,'Województwo świętokrzyskie, Kielce','TK'),
(369,'Województwo świętokrzyskie, Busko','TBU'),
(370,'Województwo świętokrzyskie, Jędrzejów','TJE'),
(371,'Województwo świętokrzyskie, Kazimierza Wielka','TKA'),
(372,'Województwo świętokrzyskie, Kielce powiat','TKI'),
(373,'Województwo świętokrzyskie, Końskie','TKN'),
(374,'Województwo świętokrzyskie, Opatów','TOP'),
(375,'Województwo świętokrzyskie, Ostrowiec Świętokrzyski','TOS'),
(376,'Województwo świętokrzyskie, Pińczów','TPI'),
(377,'Województwo świętokrzyskie, Sandomierz','TSA'),
(378,'Województwo świętokrzyskie, Skarżysko-Kamienna','TSK'),
(379,'Województwo świętokrzyskie, Starachowice','TST'),
(380,'Województwo świętokrzyskie, Staszów','TSZ'),
(381,'Województwo świętokrzyskie, Włoszczowa','TWL'),
(382,'Województwo warmińsko-mazurskie, Elbląg','NE'),
(383,'Województwo warmińsko-mazurskie, Olsztyn','NO'),
(384,'Województwo warmińsko-mazurskie, Bartoszyce','NBA'),
(385,'Województwo warmińsko-mazurskie, Braniewo','NBR'),
(386,'Województwo warmińsko-mazurskie, Działdowo','NDZ'),
(387,'Województwo warmińsko-mazurskie, Elbląg powiat','NEB'),
(388,'Województwo warmińsko-mazurskie, Ełk','NEL'),
(389,'Województwo warmińsko-mazurskie, Giżycko','NGI'),
(390,'Województwo warmińsko-mazurskie, Iława','NIL'),
(391,'Województwo warmińsko-mazurskie, Kętrzyn','NKE'),
(392,'Województwo warmińsko-mazurskie, Lidzbark Warmiński','NLI'),
(393,'Województwo warmińsko-mazurskie, Mrągowo','NMR'),
(394,'Województwo warmińsko-mazurskie, Nidzica','NNI'),
(395,'Województwo warmińsko-mazurskie, Nowe Miasto Lubawskie','NNM'),
(396,'Województwo warmińsko-mazurskie, Olecko','NOG'),
(397,'Województwo warmińsko-mazurskie, Olsztyn powiat','NOL'),
(398,'Województwo warmińsko-mazurskie, Ostróda','NOS'),
(399,'Województwo warmińsko-mazurskie, Pisz','NPI'),
(400,'Województwo warmińsko-mazurskie, Szczytno','NSZ'),
(401,'Województwo mazowieckie, Warszawa Rembertów, Warszawa Wilanów, Warszawa Włochy','WW'),
(402,'Warsaw (Włochy district)','WWK'),
(403,'Warsaw (Włochy district)','WWM'),
(404,'Warsaw (Włochy district)','WWV'),
(405,'Warsaw (Włochy district)','WWR'),
(406,'Warsaw (Włochy district)','WWS'),
(407,'Warsaw (Wilanów district)','WWF'),
(408,'Warsaw (Wilanów district)','WWG'),
(409,'Warsaw (Wilanów district)','WWH'),
(410,'Warsaw (Wilanów district)','WWJ'),
(411,'Warsaw (Wilanów district)','WWW'),
(412,'Warsaw (Rembertów district)','WWA'),
(413,'Warsaw (Rembertów district)','WWC'),
(414,'Warsaw (Rembertów district)','WWX'),
(415,'Wołomin County','WV'),
(416,'Województwo Podlaskie','B'),
(417,'Województwo kujawsko-pomorskie','C'),
(418,'Województwo dolnośląskie','D'),
(419,'Województwo łódzkie','E'),
(420,'Województwo lubuskie','F'),
(421,'Województwo pomorskie','G'),
(422,'Województwo małopolskie','K'),
(423,'Województwo lubelskie','L'),
(424,'Województwo warmińsko-mazurskie','N'),
(425,'Województwo opolskie','O'),
(426,'Województwo wielkopolskie','P'),
(427,'Województwo podkarpackie','R'),
(428,'Województwo śląskie','S'),
(429,'Województwo świętokrzyskie','T'),
(430,'Województwo mazowieckie','W'),
(431,'Województwo zachodniopomorskie','Z');
UNLOCK TABLES;

ALTER TABLE poland_entity ADD INDEX poland_index (description, region);
