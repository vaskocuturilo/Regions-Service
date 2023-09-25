DROP TABLE IF EXISTS `estonia_diplomatic_entity`;
CREATE TABLE `estonia_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `estonia_diplomatic_entity` WRITE;
INSERT INTO `estonia_diplomatic_entity` (description, region) VALUES
('Sweden','10'),
('Germany','11'),
('Iceland','12'),
('Canada','13'),
('Finland','14'),
('France','15'),
('Denmark','16'),
('United Kingdom','17'),
('Netherlands','18'),
('Italy','19'),
('Australia','20'),
('Norway','21'),
('Diplomatic Transport','22'),
('Hungary','23'),
('Spain','24'),
('Latvia','25'),
('New Zealand','26'),
('Austria','27'),
('Russia','28'),
('Lithuania','29'),
('USA','30'),
('China','33'),
('Poland','34'),
('Japan','35'),
('Ukraine','36'),
('Georgia','39'),
('Azerbaijan','43'),
('Brazil','44'),
('European Union','49'),
('Nordic Council','50');
UNLOCK TABLES;

ALTER TABLE estonia_diplomatic_entity ADD INDEX estonia_diplomatic_index (description, region);