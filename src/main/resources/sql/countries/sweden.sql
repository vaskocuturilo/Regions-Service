DROP TABLE IF EXISTS `sweden_entity`;

CREATE TABLE `sweden_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `sweden_entity` WRITE;
/*!40000 ALTER TABLE `sweden_entity` DISABLE KEYS */;
INSERT INTO `sweden_entity` (description, region) VALUES
('City of Stockholm','A'),
('City of Stockholm','AA'),
('City of Stockholm','AB'),
('Stockholms län','B'),
('Stockholms län','BA'),
('Stockholms län','BB'),
('Uppsala län','C'),
('Södermanlands län','D'),
('Östergötlands län','E'),
('Östergötlands län','EA'),
('Jönköpings län','F'),
('Jönköpings län','FA'),
('Kronobergs län','G'),
('Kalmar län','H'),
('Gotlands län','I'),
('Blekinge län','K'),
('Kristianstads län (today part of Skåne län)','L'),
('Kristianstads län (today part of Skåne län)','LA'),
('Malmöhus län (today part of Skåne län)','M'),
('Malmöhus län (today part of Skåne län)','MA'),
('Malmöhus län (today part of Skåne län)','MB'),
('Hallands län','N'),
('Göteborgs och Bohus län (today part of Västra Götalands län)','O'),
('Göteborgs och Bohus län (today part of Västra Götalands län)','OA'),
('Göteborgs och Bohus län (today part of Västra Götalands län)','OB'),
('Älvsborgs län (today part of Västra Götalands län)','P'),
('Älvsborgs län (today part of Västra Götalands län)','PA'),
('Skaraborgs län (today part of Västra Götalands län)','R'),
('Värmlands län','S'),
('Värmlands län','SA'),
('Örebro län','T'),
('Örebro län','TA'),
('Västmanlands län','U'),
('Västmanlands län','UA'),
('Kopparbergs län (today Dalarnas län)','W'),
('Kopparbergs län (today Dalarnas län)','WA'),
('Gävleborgs län','X'),
('Gävleborgs län','XA'),
('Västernorrlands län','Y'),
('Jämtlands län','Z'),
('Västerbottens län','AC'),
('Norrbottens län','BD');
UNLOCK TABLES;

ALTER TABLE sweden_entity ADD INDEX sweden_index (description, region);