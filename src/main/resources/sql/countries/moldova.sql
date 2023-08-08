DROP TABLE IF EXISTS `moldova_entity`;

CREATE TABLE `moldova_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `moldova_entity` WRITE;
/*!40000 ALTER TABLE `moldova_entity` DISABLE KEYS */;
INSERT INTO `moldova_entity` VALUES
(1,'Anenii Noi','AN'),
(2,'Tighina','BE'),
(3,'Bălți','BL'),
(4,'Briceni','BR'),
(5,'Basarabeasca','BS'),
(6,'Chișinău','C'),
(7,'Camenca','CC'),
(8,'Ceadîr-Lunga (currently Gagauzia)','CG'),
(9,'Cahul','CH'),
(10,'Călărași','CL'),
(11,'Cimișlia','CM'),
(12,'Căinari (currently merged with Căușeni)','CN'),
(13,'Comrat (currently Gagauzia)','CO'),
(14,'Criuleni','CR'),
(15,'Căușeni','CS'),
(16,'Cantemir','CT'),
(17,'Chișinău District (1999–2002)','CU'),
(18,'Dubăsari','DB'),
(19,'Dondușeni','DN'),
(20,'Drochia','DR'),
(21,'Edineț','ED'),
(22,'Fălești','FL'),
(23,'Florești','FR'),
(24,'Gagauzia','GE'),
(25,'Glodeni','GL'),
(26,'Grigoriopol','GR'),
(27,'Hîncești','HN'),
(28,'Ialoveni','IL'),
(29,'Chișinău','K'),
(30,'Lăpușna (1999–2002)','LP'),
(31,'Leova','LV'),
(32,'Nisporeni','NS'),
(33,'Ocnița','OC'),
(34,'Orhei','OR'),
(35,'Rîbnița','RB'),
(36,'Rîșcani','RS'),
(37,'Rezina','RZ'),
(38,'Șoldănești','SD'),
(39,'Sîngerei','SG'),
(40,'Slobozia','SL'),
(41,'Soroca','SR'),
(42,'Strășeni','ST'),
(43,'Ștefan Vodă','SV'),
(44,'Tighina','TG'),
(45,'Telenești','TL'),
(46,'Taraclia','TR'),
(47,'Tiraspol','TS'),
(48,'Ungheni','UN'),
(49,'Vulcănești (currently Gagauzia)','VL');
UNLOCK TABLES;

ALTER TABLE moldova_entity ADD INDEX moldova_index (description, region);
