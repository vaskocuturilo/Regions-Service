DROP TABLE IF EXISTS `croatia_entity`;

CREATE TABLE `croatia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `croatia_entity` WRITE;
/*!40000 ALTER TABLE `croatia_entity` DISABLE KEYS */;
INSERT INTO `croatia_entity` VALUES
(1,'Bjelovar, Čazma, Garešnica','BJ'),
(2,'Beli Manastir','BM'),
(3,'Čakovec, Mursko Središće, Prelog','ČK'),
(4,'Daruvar, Grubišno Polje, Lipik, Pakrac','DA'),
(5,'Čabar, Delnice','DE'),
(6,'Đakovo','DJ'),
(7,'Dubrovnik, Korčula, Metković, Opuzen, Ploče','DU'),
(8,'Gospić, Novalja, Otočac, Senj','GS'),
(9,'Imotski','IM'),
(10,'Duga Resa, Karlovac, Slunj, Ozalj','KA'),
(11,'Đurđevac, Koprivnica','KC'),
(12,'Donja Stubica, Klanjec, Krapina, Oroslavje, Pregrada, Zabok, Zlatar','KR'),
(13,'Kutina, Novska, Popovača','KT'),
(14,'Križevci','KŽ'),
(15,'Makarska, Vrgorac','MA'),
(16,'Donji Miholjac, Našice','NA'),
(17,'Nova Gradiška','NG'),
(18,'Ogulin','OG'),
(19,'Belišće, Osijek, Valpovo','OS'),
(20,'Buje, Buzet, Labin, Novigrad, Pazin, Poreč, Pula, Rovinj, Umag, Vodnjan','PU'),
(21,'Kutjevo, Pleternica, Požega','PŽ'),
(22,'Bakar, Cres, Crikvenica, Kastav, Kraljevica, Krk, Mali Lošinj, Novi Vinodolski, Opatija, Rab, Rijeka, Vrbovsko','RI'),
(23,'Slavonski Brod','SB'),
(24,'Glina, Hrvatska Kostajnica, Sisak, Petrinja','SK'),
(25,'Orahovica, Slatina','SL'),
(26,'Hvar, Kaštela, Komiža, Omiš, Sinj, Solin, Split, Stari Grad, Supetar, Trilj, Trogir, Vis, Vrlika','ST'),
(27,'Drniš, Knin, Skradin, Šibenik, Vodice','ŠI'),
(28,'Otok, Vinkovci','VK'),
(29,'Virovitica','VT'),
(30,'Ilok, Vukovar','VU'),
(31,'Ivanec, Lepoglava, Ludbreg, Novi Marof, Varaždin, Varaždinske Toplice','VŽ'),
(32,'Benkovac, Biograd na Moru, Nin, Obrovac, Pag, Zadar','ZD'),
(33,'Dugo Selo, Ivanić-Grad, Jastrebarsko, Samobor, Sveta Nedelja, Sveti Ivan Zelina, Velika Gorica, Vrbovec, Zagreb, Zaprešić','ZG'),
(34,'Županja','ŽU'),
(35,'KN','Krapina'),
(36,'Slatina','PS'),
(37,'Sisak','SI'),
(38,'Požega','SP'),
(39,'Korenica','TK');
UNLOCK TABLES;

ALTER TABLE croatia_entity ADD INDEX croatia_index (description, region);