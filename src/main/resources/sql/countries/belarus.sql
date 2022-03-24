DROP TABLE IF EXISTS `belarus_entity`;

CREATE TABLE `belarus_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `belarus_entity` WRITE;
/*!40000 ALTER TABLE `belarus_entity` DISABLE KEYS */;
INSERT INTO `belarus_entity` VALUES
(1,'Вооружённые Силы','0'),
(2,'Брестская область','1'),
(3,'Витебская область','2'),
(4,'Гомельская область','3'),
(5,'Гродненская область','4'),
(6,'Минская область','5'),
(7,'Могилёвская область','6'),
(8,'город Минск','7'),
(9,'Минский автомобильный завод','8');
UNLOCK TABLES;