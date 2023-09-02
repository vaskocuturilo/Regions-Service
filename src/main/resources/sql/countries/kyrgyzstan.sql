DROP TABLE IF EXISTS `kyrgyzstan_entity`;

CREATE TABLE `kyrgyzstan_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kyrgyzstan_entity` WRITE;
/*!40000 ALTER TABLE `kyrgyzstan_entity` DISABLE KEYS */;
INSERT INTO `kyrgyzstan_entity` (description, region) VALUES
('Баткенская область','03'),
('Бишкек','01'),
('Джалабадская область','04'),
('Иссык-Кульская область','09'),
('Нарынская область','05'),
('Ош','02'),
('Ошская область','06'),
('Таласская область','07'),
('Чуйская область','08');
UNLOCK TABLES;

ALTER TABLE kyrgyzstan_entity ADD INDEX kyrgyzstan_index (description, region);