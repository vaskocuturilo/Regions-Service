DROP TABLE IF EXISTS `serbia_entity`;

CREATE TABLE `serbia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `serbia_entity` WRITE;
/*!40000 ALTER TABLE `serbia_entity` DISABLE KEYS */;
INSERT INTO `serbia_entity` (description, region) VALUES
('Aleksinac','AL'),
('Aranđelovac','AR'),
('Aleksandrovac','AC'),
('Bajina Bašta','BB'),
('Barajevo, Voždovac, Vračar, Grocka, Zvezdara, Zemun, Lazarevac, Mladenovac, Novi Beograd, Obrenovac, Palilula, Rakovica, Savski Venac, Sopot, Stari Grad, Surčin, Čukarica','BG'),
('Majdanpek, Bor','BO'),
('Bačka Palanka','BP'),
('Bačka Topola','BT'),
('Bogatić','BĆ'),
('Bogatić, Bečej','BC'),
('Bujanovac','BU'),
('Bečej','BČ'),
('Lajkovac, Ljig, Mionica, Osečina, Valjevo','VA'),
('Vrnjačka Banja','VB'),
('Vlasotince','VL'),
('Velika Plana','VP'),
('Bosilegrad, Vladičin Han, Preševo, Trgovište, Vranje','VR'),
('Vrbas, Bela Crkva, Plandište, Vršac','VS'),
('Bela Crkva, Plandište, Vršac','VŠ'),
('Vitina, Kosovska Kamenica, Novo Brdo, Gnjilane','GL'),
('Gornji Milanovac','GM'),
('Despotovac','DE'),
('Dečani, Đakovica','ĐA'),
('Dečani, Đakovica','DA'),
('Boljevac, Sokobanja, Zaječar','ZA'),
('Žitište, Novi Bečej, Nova Crnja, Sečanj, Zrenjanin','ZR'),
('Inđija','IN'),
('Ivanjica','IC'),
('Rekovac, Jagodina','JA'),
('Kanjiža','KA'),
('Koceljeva','KC'),
('Kraljevo','KV'),
('Batočina, Knić, Lapovo, Rača, City of Kragujevac','KG'),
('Knjaževac','KŽ'),
('Knjaževac','KZ'),
('Čoka, Novi Kneževac, Kikinda','KI'),
('Kladovo','KL'),
('Vučitrn, Zvečan, Zubin Potok, Leposavić, Srbica, Kosovska Mitrovica','KM'),
('Kovin','KO'),
('Brus, Varvarin, Ćićevac, Kruševac','KŠ'),
('Brus, Varvarin, Ćićevac, Kruševac','KS'),
('Lebane','LB'),
('Bojnik, Medveđa, Crna Trava, Leskovac','LE'),
('Krupanj, Ljubovija, Mali Zvornik, Loznica','LO'),
('Lučani','LU'),
('Nova Varoš','NV'),
('Negotin','NG'),
('Doljevac, Gadžin Han, Merošina, Ražanj, Svrljig, City of Niš','NI'),
('Novi Pazar','NP'),
('Bač, Bački Petrovac, Beočin, Žabalj, Srbobran, Sremski Karlovci, Temerin, Titel, City of Novi Sad','NS'),
('Alibunar, Kovačica, Opovo, Pančevo','PA'),
('Priboj','PB'),
('Istok, Klina, Peć','PE'),
('Požega','PŽ'),
('Požega, Gora, Orahovac, Suva Reka, Prizren','PZ'),
('Babušnica, Bela Palanka, Dimitrovgrad, Pirot','PI'),
('Blace, Žitorađa, Kuršumlija, Prokuplje','PK'),
('Paraćin','PN'),
('Veliko Gradište, Golubac, Žabari, Žagubica, Kučevo, Malo Crniće, Požarevac','PO'),
('Prijepolje','PP'),
('Glogovac, Kosovo Polje, Lipljan, Obilić, Podujevo, Priština','PR'),
('Petrovac','PT'),
('Raška','RA'),
('Irig, Pećinci, Ruma','RU'),
('Ada, Senta','SA'),
('Sremska Mitrovica','SM'),
('Svilajnac','SV'),
('Smederevo','SD'),
('Sjenica','SJ'),
('Apatin, Kula, Odžaci, Sombor','SO'),
('Smederevska Palanka','SP'),
('Stara Pazova','ST'),
('Mali Iđoš, Subotica','SU'),
('Surdulica','SC'),
('Topola','TO'),
('Trstenik','TS'),
('Tutin','TT'),
('Ćuprija','ĆU'),
('Ćuprija','CU'),
('Ub','UB'),
('Arilje, Kosjerić, Čajetina, Zlatibor, Užice','UE'),
('Kačanik, Uroševac, Štimlje, Štrpce','UR'),
('Čačak','ČA'),
('Čačak','CA'),
('Vladimirci, Šabac','ŠA'),
('Vladimirci, Šabac','SA'),
('Šid','ŠI'),
('Šid','SI');
UNLOCK TABLES;

ALTER TABLE serbia_entity ADD INDEX serbia_index (description, region);