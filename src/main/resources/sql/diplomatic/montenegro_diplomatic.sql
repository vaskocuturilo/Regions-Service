DROP TABLE IF EXISTS `montenegro_diplomatic_entity`;
CREATE TABLE `montenegro_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `montenegro_diplomatic_entity` WRITE;
INSERT INTO `montenegro_diplomatic_entity` (description, region) VALUES
('Russia','10'),
('Turkey','11'),
('Albania','12'),
('Belgium','16'),
('Bosnia and Herzegovina','18'),
('China','20'),
('Bulgaria','25'),
('Czech Republic','26'),
('United Kingdom','30'),
('Finland','32'),
('Sweden','33'),
('Denmark','34'),
('France','35'),
('The Netherlands','36'),
('Germany','40'),
('Italy','41'),
('Switzerland','43'),
('Austria','44'),
('Greece','45'),
('Norway','53'),
('Hungary','55'),
('USA','60'),
('Slovakia','62'),
('Canada','63'),
('Poland','65'),
('Ukraine','69'),
('Serbia','70'),
('Romania','75'),
('Bosnia and Herzegovina','85'),
('Japan','86'),
('Croatia','90'),
('North Macedonia','95'),
('Georgia','96'),
('EU','100'),
('ECPD','101'),
('UNWFP','102'),
('EAR','105'),
('United Nations','110'),
('OSCE','111'),
('ICRC','112');
UNLOCK TABLES;

ALTER TABLE montenegro_diplomatic_entity ADD INDEX montenegro_diplomatic_index (description, region);