DROP TABLE IF EXISTS `sweden_entity`;

CREATE TABLE `sweden_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `sweden_entity` WRITE;
/*!40000 ALTER TABLE `sweden_entity` DISABLE KEYS */;
INSERT INTO `sweden_entity` VALUES
(1,'City of Stockholm','A'),
(2,'City of Stockholm','AA'),
(3,'City of Stockholm','AB'),
(4,'Stockholms län','B'),
(5,'Stockholms län','BA'),
(6,'Stockholms län','BB'),
(7,'Uppsala län','C'),
(8,'Södermanlands län','D'),
(9,'Östergötlands län','E'),
(10,'Östergötlands län','EA'),
(11,'Jönköpings län','F'),
(12,'Jönköpings län','FA'),
(13,'Kronobergs län','G'),
(14,'Kalmar län','H'),
(15,'Gotlands län','I'),
(16,'Blekinge län','K'),
(17,'Kristianstads län (today part of Skåne län)','L'),
(18,'Kristianstads län (today part of Skåne län)','LA'),
(19,'Malmöhus län (today part of Skåne län)','M'),
(20,'Malmöhus län (today part of Skåne län)','MA'),
(21,'Malmöhus län (today part of Skåne län)','MB'),
(22,'Hallands län','N'),
(23,'Göteborgs och Bohus län (today part of Västra Götalands län)','O'),
(24,'Göteborgs och Bohus län (today part of Västra Götalands län)','OA'),
(25,'Göteborgs och Bohus län (today part of Västra Götalands län)','OB'),
(26,'Älvsborgs län (today part of Västra Götalands län)','P'),
(27,'Älvsborgs län (today part of Västra Götalands län)','PA'),
(28,'Skaraborgs län (today part of Västra Götalands län)','R'),
(29,'Värmlands län','S'),
(30,'Värmlands län','SA'),
(31,'Örebro län','T'),
(32,'Örebro län','TA'),
(33,'Västmanlands län','U'),
(34,'Västmanlands län','UA'),
(35,'Kopparbergs län (today Dalarnas län)','W'),
(36,'Kopparbergs län (today Dalarnas län)','WA'),
(37,'Gävleborgs län','X'),
(38,'Gävleborgs län','XA'),
(39,'Västernorrlands län','Y'),
(40,'Jämtlands län','Z'),
(41,'Västerbottens län','AC'),
(42,'Norrbottens län','BD');
UNLOCK TABLES;

ALTER TABLE sweden_entity ADD INDEX sweden_index (description, region);