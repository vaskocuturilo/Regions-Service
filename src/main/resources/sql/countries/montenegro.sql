DROP TABLE IF EXISTS `montenegro_entity`;

CREATE TABLE `montenegro_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `montenegro_entity` WRITE;
/*!40000 ALTER TABLE `montenegro_entity` DISABLE KEYS */;
INSERT INTO `montenegro_entity` (description, region) VALUES
('Andrijevica','AN'),
('Berane','BA'),
('Budva','BD'),
('Bijelo Polje','BP'),
('Bar','BR'),
('Cetinje','CT'),
('Danilovgrad','DG'),
('Gusinje','GS'),
('Herceg Novi','HN'),
('Kolašin','KL'),
('Kotor','KO'),
('Mojkovac','MK'),
('Nikšić','NK'),
('Podgorica','PG'),
('Plav','PL'),
('Petnjica','PT'),
('Plužine','PŽ'),
('Pljevlja','PV'),
('Rožaje','RO'),
('Šavnik','ŠN'),
('Tivat','TV'),
('Tuzi','TZ'),
('Ulcinj','UL'),
('Žabljak','ŽB');
UNLOCK TABLES;

ALTER TABLE montenegro_entity ADD INDEX montenegro_index (description, region);