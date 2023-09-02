DROP TABLE IF EXISTS `croatia_entity`;

CREATE TABLE `croatia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `croatia_entity` WRITE;
/*!40000 ALTER TABLE `croatia_entity` DISABLE KEYS */;
INSERT INTO `croatia_entity` (description, region) VALUES
('Bjelovar, Čazma, Garešnica','BJ'),
('Beli Manastir','BM'),
('Čakovec, Mursko Središće, Prelog','ČK'),
('Daruvar, Grubišno Polje, Lipik, Pakrac','DA'),
('Čabar, Delnice','DE'),
('Đakovo','DJ'),
('Dubrovnik, Korčula, Metković, Opuzen, Ploče','DU'),
('Gospić, Novalja, Otočac, Senj','GS'),
('Imotski','IM'),
('Duga Resa, Karlovac, Slunj, Ozalj','KA'),
('Đurđevac, Koprivnica','KC'),
('Donja Stubica, Klanjec, Krapina, Oroslavje, Pregrada, Zabok, Zlatar','KR'),
('Kutina, Novska, Popovača','KT'),
('Križevci','KŽ'),
('Makarska, Vrgorac','MA'),
('Donji Miholjac, Našice','NA'),
('Nova Gradiška','NG'),
('Ogulin','OG'),
('Belišće, Osijek, Valpovo','OS'),
('Buje, Buzet, Labin, Novigrad, Pazin, Poreč, Pula, Rovinj, Umag, Vodnjan','PU'),
('Kutjevo, Pleternica, Požega','PŽ'),
('Bakar, Cres, Crikvenica, Kastav, Kraljevica, Krk, Mali Lošinj, Novi Vinodolski, Opatija, Rab, Rijeka, Vrbovsko','RI'),
('Slavonski Brod','SB'),
('Glina, Hrvatska Kostajnica, Sisak, Petrinja','SK'),
('Orahovica, Slatina','SL'),
('Hvar, Kaštela, Komiža, Omiš, Sinj, Solin, Split, Stari Grad, Supetar, Trilj, Trogir, Vis, Vrlika','ST'),
('Drniš, Knin, Skradin, Šibenik, Vodice','ŠI'),
('Otok, Vinkovci','VK'),
('Virovitica','VT'),
('Ilok, Vukovar','VU'),
('Ivanec, Lepoglava, Ludbreg, Novi Marof, Varaždin, Varaždinske Toplice','VŽ'),
('Benkovac, Biograd na Moru, Nin, Obrovac, Pag, Zadar','ZD'),
('Dugo Selo, Ivanić-Grad, Jastrebarsko, Samobor, Sveta Nedelja, Sveti Ivan Zelina, Velika Gorica, Vrbovec, Zagreb, Zaprešić','ZG'),
('Županja','ŽU'),
('KN','Krapina'),
('Slatina','PS'),
('Sisak','SI'),
('Požega','SP'),
('Korenica','TK');
UNLOCK TABLES;

ALTER TABLE croatia_entity ADD INDEX croatia_index (description, region);