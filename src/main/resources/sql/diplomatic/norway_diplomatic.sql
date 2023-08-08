DROP TABLE IF EXISTS `norway_diplomatic_entity`;
CREATE TABLE `norway_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `norway_diplomatic_entity` WRITE;
INSERT INTO `norway_diplomatic_entity` VALUES
(1,'United States','10'),
(2,'Argentina','11'),
(3,'Afghanistan','12'),
(4,'Belgium','14'),
(5,'Brazil','15'),
(6,'United Kingdom','16'),
(7,'Bulgaria','17'),
(8,'Canada','20'),
(9,'Chile','21'),
(10,'Colombia','22'),
(11,'Cuba','23'),
(12,'Denmark','26'),
(13,'European Union','28'),
(14,'Egypt','29'),
(15,'Ecuador','30'),
(16,'Finland','33'),
(17,'France','34'),
(18,'Greece','37'),
(19,'India','40'),
(20,'Indonesia','41'),
(21,'Iran','42'),
(22,'Iceland','43'),
(23,'Israel','44'),
(24,'Italy','45'),
(25,'Japan','48'),
(26,'China','52'),
(27,'South Korea','53'),
(28,'North Korea','54'),
(29,'Mexico','57'),
(30,'Netherlands','60'),
(31,'Panama','63'),
(32,'Poland','64'),
(33,'Portugal','65'),
(34,'Romania','68'),
(35,'Russia','71'),
(36,'Spain','72'),
(37,'Switzerland','73'),
(38,'Sweden','74'),
(39,'South Africa','75'),
(40,'Thailand','76'),
(41,'Czech Republic','77'),
(42,'Turkey','78'),
(43,'Germany','80'),
(44,'Hungary','83'),
(45,'Venezuela','86'),
(46,'Austria','89');
UNLOCK TABLES;

ALTER TABLE norway_diplomatic_entity ADD INDEX norway_diplomatic_index (description, region);