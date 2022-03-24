DROP TABLE IF EXISTS `romania_entity`;

CREATE TABLE `romania_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `romania_entity` WRITE;
/*!40000 ALTER TABLE `romania_entity` DISABLE KEYS */;
INSERT INTO `romania_entity` VALUES
(1,'Alba','AB'),
(2,'Argeș','AG'),
(3,'Arad','AR'),
(4,'Bucharest','B'),
(5,'Bacău','BC'),
(6,'Bihor','BH'),
(7,'Bistrița-Năsăud','BN'),
(8,'Brăila','BR'),
(9,'Botoșani','BT'),
(10,'Brașov','BV'),
(11,'Buzău','BZ'),
(12,'Cluj','CJ'),
(13,'Călărași','CL'),
(14,'Caraș-Severin','CS'),
(15,'Constanța','CT'),
(16,'Covasna','CV'),
(17,'Dâmbovița','DB'),
(18,'Dolj','DJ'),
(19,'Gorj','GJ'),
(20,'Galați','GL'),
(21,'Giurgiu','GR'),
(22,'Hunedoara','HD'),
(23,'Harghita','HR'),
(24,'Ilfov','IF'),
(25,'Ialomița','IL'),
(26,'Iași','IS'),
(27,'Mehedinți','MH'),
(28,'Maramureș','MM'),
(29,'Mureș','MS'),
(30,'Neamț','NT'),
(31,'Olt','OT'),
(32,'Prahova','PH'),
(33,'Sibiu','SB'),
(34,'Sălaj','SJ'),
(35,'Satu Mare','SM'),
(36,'Suceava','SV'),
(37,'Tulcea','TL'),
(38,'Timiș','TM'),
(39,'Teleorman','TR'),
(40,'Vâlcea','VL'),
(41,'Vrancea','VN'),
(42,'Vaslui','VS');
UNLOCK TABLES;