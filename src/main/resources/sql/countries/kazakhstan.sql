DROP TABLE IF EXISTS `kazakhstan_entity`;

CREATE TABLE `kazakhstan_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kazakhstan_entity` WRITE;
/*!40000 ALTER TABLE `kazakhstan_entity` DISABLE KEYS */;
INSERT INTO `kazakhstan_entity` (description, region) VALUES
('Нур-Султан','01'),
('Алма-Ата','02'),
('Шымкент','17'),
('Акмолинская область (Кокчетавская область)','03'),
('Актюбинская область','04'),
('Алматинская область (Талды-Курганская область)','05'),
('Атырауская область','06'),
('Западно-Казахстанская область','07'),
('Жамбылская область','08'),
('Карагандинская область (Джезказганская область)','09'),
('Костанайская область (Тургайская область)','10'),
('Кызылординская область','11'),
('Мангистауская область','12'),
('Туркестанская область (Южно-Казахстанская область)','13'),
('Павлодарская область','14'),
('Северо-Казахстанская область (Кокчетавская область)','15'),
('Восточно-Казахстанская область (Семипалатинская область)','16'),
('Ввезённые из стран ЕАЭС','18');
UNLOCK TABLES;

ALTER TABLE kazakhstan_entity ADD INDEX kazakhstan_index (description, region);