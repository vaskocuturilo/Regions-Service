DROP TABLE IF EXISTS `north_macedonia_entity`;
CREATE TABLE `north_macedonia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `north_macedonia_entity` WRITE;
INSERT INTO `north_macedonia_entity` (region, description) VALUES
('BE','Berovo'),
('BT','Bitola'),
('DB','Debar'),
('DE','Delčevo'),
('DH','Demir Hisar'),
('DK','Demir Kapija'),
('GE','Gevgelija'),
('GV','Gostivar'),
('KA','Kavadarci'),
('KI','Kičevo'),
('KO','Kočani'),
('KR','Kratovo'),
('KP','Kriva Palanka'),
('KS','Kruševo'),
('KU','Kumanovo'),
('MB','Makedonski Brod'),
('MK','Makedonska Kamenica'),
('NE','Negotino'),
('OH','Ohrid'),
('PE','Pehčevo'),
('PP','Prilep'),
('PS','Probištip'),
('RA','Radoviš'),
('RE','Resen'),
('SK','Skopje'),
('SN','Sveti Nikole'),
('SU','Struga'),
('SR','Strumica'),
('ST','Štip'),
('TE','Tetovo'),
('VA','Valandovo'),
('VE','Veles'),
('VI','Vinica'),
('VV','Vevčani');
UNLOCK TABLES;

ALTER TABLE north_macedonia_entity ADD INDEX north_macedonia_entity (description, region);