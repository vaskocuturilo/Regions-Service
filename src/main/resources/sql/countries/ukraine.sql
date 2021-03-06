DROP TABLE IF EXISTS `ukraine_entity`;

CREATE TABLE `ukraine_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `ukraine_entity` WRITE;
/*!40000 ALTER TABLE `ukraine_entity` DISABLE KEYS */;
INSERT INTO `ukraine_entity` VALUES
(1,'город Киев','AA'),
(2,'Винницкая область','AB'),
(3,'Волынская область','AC'),
(4,'Днепропетровская область','AE'),
(5,'Донецкая область','AH'),
(6,'Киевская область','AI'),
(7,'Автономная Республика Крым','AK'),
(8,'Житомирская область','AM'),
(9,'Закарпатская область','AO'),
(10,'Запорожская область','AP'),
(11,'Ивано-Франковская область','AT'),
(12,'Харьковская область','AX'),
(13,'Кировоградская область','BA'),
(14,'Луганская область','BB'),
(15,'Львовская область','BC'),
(16,'Николаевская область','BE'),
(17,'Одесская область','BH'),
(18,'Полтавская область','BI'),
(19,'Ровенская область','BK'),
(20,'Сумская область','BM'),
(21,'Тернопольская область','BO'),
(22,'Херсонская область','BT'),
(23,'Хмельницкая область','BX'),
(24,'Черкасская область','CA'),
(25,'Черниговская область','CB'),
(26,'Черновицкая область','CE'),
(27,'город Севастополь','CH'),
(28,'Общегосударственные номера','II');
UNLOCK TABLES;
