DROP TABLE IF EXISTS `france_diplomatic_entity`;
CREATE TABLE `france_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `france_diplomatic_entity` WRITE;
INSERT INTO `france_diplomatic_entity` VALUES
(1,'South Africa','2'),
(2,'Algeria','4'),
(3,'Germany','5'),
(4,'United States','6'),
(5,'Egypt','7'),
(6,'Argentina','9'),
(7,'Austria','11'),
(8,'Belgium','12'),
(9,'Brazil','16'),
(10,'Cameroon','20'),
(11,'China','26'),
(12,'Colombia','28'),
(13,'Denmark','36'),
(14,'Spain','40'),
(15,'Gabon','43'),
(16,'United Kingdom','45'),
(17,'Greece','46'),
(18,'India','53'),
(19,'Indonesia','54'),
(20,'Israel','59'),
(21,'Italy','60'),
(22,'Japan','62'),
(23,'Jordan','63'),
(24,'Lebanon','67'),
(25,'Morocco','76'),
(26,'Mauritania','77'),
(27,'Mexico','78'),
(28,'Peru','91'),
(29,'Poland','93'),
(30,'Portugal','94'),
(31,'Romania','96'),
(32,'Senegal','100'),
(33,'Switzerland','105'),
(34,'Tunisia','113'),
(35,'Turkey','114'),
(36,'Russia','115'),
(37,'Yugoslavia','120'),
(38,'Eritrea','180'),
(39,'European Union','415'),
(40,'European Union Euratom','416'),
(41,'CERN','431'),
(42,'Organisation internationale de la Francophonie','433'),
(43,'International Bureau of Weights and Measures','434'),
(44,'European Molecular Biology Laboratory','435');
UNLOCK TABLES;