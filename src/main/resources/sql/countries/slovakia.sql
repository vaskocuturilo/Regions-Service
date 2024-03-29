DROP TABLE IF EXISTS `slovakia_entity`;

CREATE TABLE `slovakia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `slovakia_entity` WRITE;
/*!40000 ALTER TABLE `slovakia_entity` DISABLE KEYS */;
INSERT INTO `slovakia_entity` (description, region) VALUES
('Bratislava','BA'),
('Bratislava','BD'),
('Bratislava','BE'),
('Bratislava','BI'),
('Bratislava','BL'),
('Bratislava','BT'),
('Banská Bystrica','BB'),
('Banská Bystrica','BC'),
('Banská Bystrica','BK'),
('Bardejov','BJ'),
('Bánovce nad Bebravou','BN'),
('Brezno','BR'),
('Banská Štiavnica','BS'),
('Bytča','BY'),
('Čadca','CA'),
('Dolný Kubín','DK'),
('Dunajská Streda','DS'),
('Detva','DT'),
('Galanta','GA'),
('Gelnica','GL'),
('Hlohovec','HC'),
('Humenné','HE'),
('Ilava','IL'),
('Krupina','KA'),
('Košice','KE'),
('Košice','KC'),
('Košice','KI'),
('Kežmarok','KK'),
('Kysucké Nové Mesto','KM'),
('Komárno','KN'),
('Košice-okolie','KS'),
('Lučenec','LC'),
('Levoča','LE'),
('Liptovský Mikuláš','LM'),
('Levice','LV'),
('Levice','LL'),
('Malacky','MA'),
('Michalovce','MI'),
('Medzilaborce','ML'),
('Martin','MT'),
('Myjava','MY'),
('Nitra','NR'),
('Nitra','NI'),
('Nitra','NT'),
('Nové Mesto nad Váhom','NM'),
('Námestovo','NO'),
('Nové Zámky','NZ'),
('Nové Zámky','NC'),
('Považská Bystrica','PB'),
('Prievidza','PD'),
('Partizánske','PE'),
('Pezinok','PK'),
('Piešťany','PN'),
('Prešov','PO'),
('Prešov','PV'),
('Prešov','PS'),
('Poprad','PP'),
('Poltár','PT'),
('Púchov','PU'),
('Revúca','RA'),
('Ružomberok','RK'),
('Rimavská Sobota','RS'),
('Rožňava','RV'),
('Šaľa','SA'),
('Sabinov','SB'),
('Senec','SC'),
('Senica','SE'),
('Skalica','SI'),
('Svidník','SK'),
('Stará Ľubovňa','SL'),
('Spišská Nová Ves','SN'),
('Sobrance','SO'),
('Stropkov','SP'),
('Snina','SV'),
('Trnava','TT'),
('Trnava','TA'),
('Trnava','TB'),
('Trenčín','TN'),
('Trenčín','TC'),
('Trenčín','TE'),
('Topoľčany','TO'),
('Turčianske Teplice','TR'),
('Tvrdošín','TS'),
('Trebišov','TV'),
('Veľký Krtíš','VK'),
('Vranov nad Topľou','VT'),
('Žilina','ZA'),
('Žilina','ZI'),
('Žilina','ZL'),
('Žarnovica','ZC'),
('Žiar nad Hronom','ZH'),
('Zlaté Moravce','ZM'),
('Zvolen','ZV');
UNLOCK TABLES;

ALTER TABLE slovakia_entity ADD INDEX slovakia_index (description, region);
