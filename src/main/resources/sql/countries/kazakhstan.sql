DROP TABLE IF EXISTS `kazakhstan_entity`;

CREATE TABLE `kazakhstan_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kazakhstan_entity` WRITE;
/*!40000 ALTER TABLE `kazakhstan_entity` DISABLE KEYS */;
INSERT INTO `kazakhstan_entity` VALUES
(1,'Нур-Султан','01'),
(2,'Алма-Ата','02'),
(3,'Шымкент','17'),
(4,'Акмолинская область (Кокчетавская область)','03'),
(5,'Актюбинская область','04'),
(6,'Алматинская область (Талды-Курганская область)','05'),
(7,'Атырауская область','06'),
(8,'Западно-Казахстанская область','07'),
(9,'Жамбылская область','08'),
(10,'Карагандинская область (Джезказганская область)','09'),
(11,'Костанайская область (Тургайская область)','10'),
(12,'Кызылординская область','11'),
(13,'Мангистауская область','12'),
(14,'Туркестанская область (Южно-Казахстанская область)','13'),
(15,'Павлодарская область','14'),
(16,'Северо-Казахстанская область (Кокчетавская область)','15'),
(17,'Восточно-Казахстанская область (Семипалатинская область)','16'),
(18,'Ввезённые из стран ЕАЭС','18');
UNLOCK TABLES;

ALTER TABLE kazakhstan_entity ADD INDEX kazakhstan_index (description, region);