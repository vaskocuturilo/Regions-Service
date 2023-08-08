DROP TABLE IF EXISTS `lithuania_diplomatic_entity`;
CREATE TABLE `lithuania_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `lithuania_diplomatic_entity` WRITE;
INSERT INTO `lithuania_diplomatic_entity` VALUES
(1,'Sweden','01'),
(2,'Germany','02'),
(3,'France','03'),
(4,'Latvia','04'),
(5,'Denmark','05'),
(6,'Canada','06'),
(7,'United Kingdom','07'),
(8,'Italy','08'),
(9,'Norway','09'),
(10,'Finland','10'),
(11,'Holy See','11'),
(12,'Turkey','12'),
(13,'Czech Republic','13'),
(14,'United States','14'),
(15,'China','15'),
(16,'Poland','16'),
(17,'Poland','17'),
(18,'Estonia','18'),
(19,'Russia','19'),
(20,'Russia','20'),
(21,'Romania','21'),
(22,'Ukraine','22'),
(23,'Belarus','23'),
(24,'Kazakhstan','24'),
(25,'Georgia','25'),
(26,'Japan','26'),
(27,'Austria','27'),
(28,'Belgium','28'),
(29,'Netherlands','29'),
(30,'Hungary','30'),
(31,'Spain','31'),
(32,'Sovereign Military Order of Malta','32'),
(33,'Democratic Republic of Congo','33'),
(34,'Ireland','34'),
(35,'Portugal','35'),
(36,'Moldova','36'),
(37,'Azerbaijan','37'),
(38,'Bulgaria','38'),
(39,'Armenia','39'),
(40,'Croatia','40'),
(41,'Israel','41'),
(42,'Nordic Council of Ministers','80'),
(43,'International Bank for Reconstruction and Development','81'),
(44,'European Bank for Reconstruction and Development','82'),
(45,'World Health Organization','83'),
(46,'United Nations United Nations Development Program','84'),
(47,'International Organization for Migration','85'),
(48,'European Union European Commission','86'),
(49,'United Nations','87'),
(50,'European Institute for Gender Equality','88'),
(51,'NATO Energy Security Centre of Excellence','89');
UNLOCK TABLES;

ALTER TABLE lithuania_diplomatic_entity ADD INDEX lithuania_diplomatic_index (description, region);