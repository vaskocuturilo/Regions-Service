DROP TABLE IF EXISTS `norway_diplomatic_entity`;
CREATE TABLE `norway_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `norway_diplomatic_entity` WRITE;
INSERT INTO `norway_diplomatic_entity` VALUES
('United States','10'),
('Argentina','11'),
('Afghanistan','12'),
('Belgium','14'),
('Brazil','15'),
('United Kingdom','16'),
('Bulgaria','17'),
('Canada','20'),
('Chile','21'),
('Colombia','22'),
('Cuba','23'),
('Denmark','26'),
('European Union','28'),
('Egypt','29'),
('Ecuador','30'),
('Finland','33'),
('France','34'),
('Greece','37'),
('India','40'),
('Indonesia','41'),
('Iran','42'),
('Iceland','43'),
('Israel','44'),
('Italy','45'),
('Japan','48'),
('China','52'),
('South Korea','53'),
('North Korea','54'),
('Mexico','57'),
('Netherlands','60'),
('Panama','63'),
('Poland','64'),
('Portugal','65'),
('Romania','68'),
('Russia','71'),
('Spain','72'),
('Switzerland','73'),
('Sweden','74'),
('South Africa','75'),
('Thailand','76'),
('Czech Republic','77'),
('Turkey','78'),
('Germany','80'),
('Hungary','83'),
('Venezuela','86'),
('Austria','89');
UNLOCK TABLES;

ALTER TABLE norway_diplomatic_entity ADD INDEX norway_diplomatic_index (description, region);