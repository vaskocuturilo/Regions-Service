DROP TABLE IF EXISTS `estonia_diplomatic_entity`;
CREATE TABLE `estonia_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `estonia_diplomatic_entity` WRITE;
INSERT INTO `estonia_diplomatic_entity` VALUES
(1,'Sweden','10'),
(2,'Germany','11'),
(3,'Iceland','12'),
(4,'Canada','13'),
(5,'Finland','14'),
(6,'France','15'),
(7,'Denmark','16'),
(8,'United Kingdom','17'),
(9,'Netherlands','18'),
(10,'Italy','19'),
(11,'Australia','20'),
(12,'Norway','21'),
(13,'Diplomatic Transport','22'),
(14,'Hungary','23'),
(15,'Spain','24'),
(16,'Latvia','25'),
(17,'New Zealand','26'),
(18,'Austria','27'),
(19,'Russia','28'),
(20,'Lithuania','29'),
(21,'USA','30'),
(22,'China','33'),
(23,'Poland','34'),
(24,'Japan','35'),
(25,'Ukraine','36'),
(26,'Georgia','39'),
(27,'Azerbaijan','43'),
(28,'Brazil','44'),
(29,'European Union','49'),
(30,'Nordic Council','50');
UNLOCK TABLES;

ALTER TABLE estonia_diplomatic_entity ADD INDEX estonia_diplomatic_index (description, region);