DROP TABLE IF EXISTS `montenegro_entity`;

CREATE TABLE `montenegro_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `montenegro_entity` WRITE;
/*!40000 ALTER TABLE `montenegro_entity` DISABLE KEYS */;
INSERT INTO `montenegro_entity` VALUES
(1,'Andrijevica','AN'),
(2,'Berane','BA'),
(3,'Budva','BD'),
(4,'Bijelo Polje','BP'),
(5,'Bar','BR'),
(6,'Cetinje','CT'),
(7,'Danilovgrad','DG'),
(8,'Gusinje','GS'),
(9,'Herceg Novi','HN'),
(10,'Kolašin','KL'),
(11,'Kotor','KO'),
(12,'Mojkovac','MK'),
(13,'Nikšić','NK'),
(14,'Podgorica','PG'),
(15,'Plav','PL'),
(16,'Petnjica','PT'),
(17,'Plužine','PŽ'),
(18,'Pljevlja','PV'),
(19,'Rožaje','RO'),
(20,'Šavnik','ŠN'),
(21,'Tivat','TV'),
(22,'Tuzi','TZ'),
(23,'Ulcinj','UL'),
(24,'Žabljak','ŽB');
UNLOCK TABLES;

ALTER TABLE montenegro_entity ADD INDEX montenegro_index (description, region);