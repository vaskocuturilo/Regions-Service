DROP TABLE IF EXISTS `kyrgyzstan_dip_entity`;
CREATE TABLE `kyrgyzstan_dip_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `kyrgyzstan_dip_entity` WRITE;
INSERT INTO `kyrgyzstan_dip_entity` VALUES
(1,'Turkey','01'),
(2,'United States','02'),
(3,'China','03'),
(4,'Russia','04'),
(5,'Germany','05'),
(6,'Iran','06'),
(7,'Kazakhstan','07'),
(8,'India','08'),
(9,'Belarus','09'),
(10,'Pakistan','10'),
(11,'Uzbekistan','11'),
(12,'Ukraine','12'),
(13,'Afghanistan','13'),
(14,'Tajikistan','14'),
(15,'Japan','15'),
(16,'South Korea','16'),
(17,'European Union','17'),
(18,'France','18'),
(19,'Azerbaijan','19'),
(20,'EBRD','50'),
(21,'IMF','51'),
(22,'World Bank','52'),
(23,'MIR TV','53'),
(24,'Swiss Corporation Office','54'),
(25,'GIZ','55'),
(26,'IOM','56'),
(27,'UK DfID','57'),
(28,'OSCE','58'),
(29,'SOS Children\'s Villages','59'),
(30,'JICA','60'),
(31,'ADB','61'),
(32,'ICRC','62'),
(33,'Aga Khan','63'),
(34,'ISTC','64');
UNLOCK TABLES;