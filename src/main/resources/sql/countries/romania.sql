DROP TABLE IF EXISTS `romania_entity`;

CREATE TABLE `romania_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `romania_entity` WRITE;
/*!40000 ALTER TABLE `romania_entity` DISABLE KEYS */;
INSERT INTO `romania_entity` (description, region) VALUES
('Alba','AB'),
('Argeș','AG'),
('Arad','AR'),
('Bucharest','B'),
('Bacău','BC'),
('Bihor','BH'),
('Bistrița-Năsăud','BN'),
('Brăila','BR'),
('Botoșani','BT'),
('Brașov','BV'),
('Buzău','BZ'),
('Cluj','CJ'),
('Călărași','CL'),
('Caraș-Severin','CS'),
('Constanța','CT'),
('Covasna','CV'),
('Dâmbovița','DB'),
('Dolj','DJ'),
('Gorj','GJ'),
('Galați','GL'),
('Giurgiu','GR'),
('Hunedoara','HD'),
('Harghita','HR'),
('Ilfov','IF'),
('Ialomița','IL'),
('Iași','IS'),
('Mehedinți','MH'),
('Maramureș','MM'),
('Mureș','MS'),
('Neamț','NT'),
('Olt','OT'),
('Prahova','PH'),
('Sibiu','SB'),
('Sălaj','SJ'),
('Satu Mare','SM'),
('Suceava','SV'),
('Tulcea','TL'),
('Timiș','TM'),
('Teleorman','TR'),
('Vâlcea','VL'),
('Vrancea','VN'),
('Vaslui','VS');
UNLOCK TABLES;

ALTER TABLE romania_entity ADD INDEX romania_index (description, region);