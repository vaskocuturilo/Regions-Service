DROP TABLE IF EXISTS `moldova_entity`;

CREATE TABLE `moldova_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `moldova_entity` WRITE;
/*!40000 ALTER TABLE `moldova_entity` DISABLE KEYS */;
INSERT INTO `moldova_entity` (description, region) VALUES
('Anenii Noi','AN'),
('Tighina','BE'),
('Bălți','BL'),
('Briceni','BR'),
('Basarabeasca','BS'),
('Chișinău','C'),
('Camenca','CC'),
('Ceadîr-Lunga (currently Gagauzia)','CG'),
('Cahul','CH'),
('Călărași','CL'),
('Cimișlia','CM'),
('Căinari (currently merged with Căușeni)','CN'),
('Comrat (currently Gagauzia)','CO'),
('Criuleni','CR'),
('Căușeni','CS'),
('Cantemir','CT'),
('Chișinău District (1999–2002)','CU'),
('Dubăsari','DB'),
('Dondușeni','DN'),
('Drochia','DR'),
('Edineț','ED'),
('Fălești','FL'),
('Florești','FR'),
('Gagauzia','GE'),
('Glodeni','GL'),
('Grigoriopol','GR'),
('Hîncești','HN'),
('Ialoveni','IL'),
('Chișinău','K'),
('Lăpușna (1999–2002)','LP'),
('Leova','LV'),
('Nisporeni','NS'),
('Ocnița','OC'),
('Orhei','OR'),
('Rîbnița','RB'),
('Rîșcani','RS'),
('Rezina','RZ'),
('Șoldănești','SD'),
('Sîngerei','SG'),
('Slobozia','SL'),
('Soroca','SR'),
('Strășeni','ST'),
('Ștefan Vodă','SV'),
('Tighina','TG'),
('Telenești','TL'),
('Taraclia','TR'),
('Tiraspol','TS'),
('Ungheni','UN'),
('Vulcănești (currently Gagauzia)','VL');
UNLOCK TABLES;

ALTER TABLE moldova_entity ADD INDEX moldova_index (description, region);
