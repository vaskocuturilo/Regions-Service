DROP TABLE IF EXISTS `kyrgyzstan_diplomatic_entity`;
CREATE TABLE `kyrgyzstan_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kyrgyzstan_diplomatic_entity` WRITE;
INSERT INTO `kyrgyzstan_diplomatic_entity` (description, region) VALUES
('Turkey','01'),
('United States','02'),
('China','03'),
('Russia','04'),
('Germany','05'),
('Iran','06'),
('Kazakhstan','07'),
('India','08'),
('Belarus','09'),
('Pakistan','10'),
('Uzbekistan','11'),
('Ukraine','12'),
('Afghanistan','13'),
('Tajikistan','14'),
('Japan','15'),
('South Korea','16'),
('European Union','17'),
('France','18'),
('Azerbaijan','19'),
('EBRD','50'),
('IMF','51'),
('World Bank','52'),
('MIR TV','53'),
('Swiss Corporation Office','54'),
('GIZ','55'),
('IOM','56'),
('UK DfID','57'),
('OSCE','58'),
('SOS Children\'s Villages','59'),
('JICA','60'),
('ADB','61'),
('ICRC','62'),
('Aga Khan','63'),
('ISTC','64');
UNLOCK TABLES;

ALTER TABLE kyrgyzstan_diplomatic_entity ADD INDEX kyrgyzstan_diplomatic_index (description, region);