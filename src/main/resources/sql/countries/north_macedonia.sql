DROP TABLE IF EXISTS `north_macedonia_entity`;
CREATE TABLE `north_macedonia_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `north_macedonia_entity` WRITE;
INSERT INTO `north_macedonia_entity` (description, region) VALUES
('Berovo','BE'),
('Bitola', 'BT'),
('Debar', 'DB'),
('Delčevo', 'DE'),
('Demir Hisar', 'DH'),
('Demir Kapija', 'DK'),
('Gevgelija', 'GE'),
('Gostivar', 'GV'),
('Kavadarci', 'KA'),
('Kičevo', 'KI'),
('Kočani', 'KO'),
('Kratovo','KR'),
('Kriva Palanka','KP'),
('Kruševo','KS'),
('Kumanovo','KU'),
('Makedonski Brod','MB'),
('Makedonska Kamenica','MK'),
('Negotino','NE'),
('Ohrid','OH'),
('Pehčevo','PE'),
('Prilep','PP'),
('Probištip','PS'),
('Radoviš','RA'),
('Resen','RE'),
('Skopje','SK'),
('Sveti Nikole','SN'),
('Struga','SU'),
('Strumica','SR'),
('Štip','ST'),
('Tetovo','TE'),
('Valandovo','VA'),
('Veles','VE'),
('Vinica','VI'),
('Vevčani','VV');
UNLOCK TABLES;

ALTER TABLE north_macedonia_entity ADD INDEX north_macedonia_entity (description, region);