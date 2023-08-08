DROP TABLE IF EXISTS `montenegro_diplomatic_entity`;
CREATE TABLE `montenegro_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `montenegro_diplomatic_entity` WRITE;
INSERT INTO `montenegro_diplomatic_entity` VALUES
(1,'Russia','10'),
(2,'Turkey','11'),
(3,'Albania','12'),
(4,'Belgium','16'),
(5,'Bosnia and Herzegovina','18'),
(6,'China','20'),
(7,'Bulgaria','25'),
(8,'Czech Republic','26'),
(9,'United Kingdom','30'),
(10,'Finland','32'),
(11,'Sweden','33'),
(12,'Denmark','34'),
(13,'France','35'),
(14,'The Netherlands','36'),
(15,'Germany','40'),
(16,'Italy','41'),
(17,'Switzerland','43'),
(18,'Austria','44'),
(19,'Greece','45'),
(20,'Norway','53'),
(21,'Hungary','55'),
(22,'USA','60'),
(23,'Slovakia','62'),
(24,'Canada','63'),
(25,'Poland','65'),
(26,'Ukraine','69'),
(27,'Serbia','70'),
(28,'Romania','75'),
(29,'Bosnia and Herzegovina','85'),
(30,'Japan','86'),
(31,'Croatia','90'),
(32,'North Macedonia','95'),
(33,'Georgia','96'),
(34,'EU','100'),
(35,'ECPD','101'),
(36,'UNWFP','102'),
(37,'EAR','105'),
(38,'United Nations','110'),
(39,'OSCE','111'),
(40,'ICRC','112');
UNLOCK TABLES;

ALTER TABLE montenegro_diplomatic_entity ADD INDEX montenegro_diplomatic_index (description, region);