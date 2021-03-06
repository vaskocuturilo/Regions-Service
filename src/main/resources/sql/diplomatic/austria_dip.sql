DROP TABLE IF EXISTS `austria_dip_entity`;
CREATE TABLE `austria_dip_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `austria_dip_entity` WRITE;
INSERT INTO `austria_dip_entity` VALUES
(1,'Vatican City','1'),
(2,'South Africa','2'),
(3,'Albania','3'),
(4,'Germany','4'),
(5,'United States','5'),
(6,'Saudi Arabia','6'),
(7,'Egypt','7'),
(8,'Argentina','8'),
(9,'Australia','9'),
(10,'Belgium','11'),
(11,'Brazil','12'),
(12,'Bulgaria','13'),
(13,'Canada','14'),
(14,'Chile','15'),
(15,'Colombia','16'),
(16,'South Korea','17'),
(17,'Cuba','18'),
(18,'Denmark','19'),
(19,'Luxembourg (formerly  El Salvador?)','21'),
(20,'Spain','22'),
(21,'Finland','23'),
(22,'France','24'),
(23,'United Kingdom','25'),
(24,'Greece','26'),
(25,'Hungary','27'),
(26,'India','28'),
(27,'Indonesia','29'),
(28,'Iraq','31'),
(29,'Iran','32'),
(30,'Israel','33'),
(31,'Italy','34'),
(32,'Japan','35'),
(33,'Lebanon','36'),
(34,'Mexico','37'),
(35,'Norway','38'),
(36,'Sovereign Military Order of Malta','39'),
(37,'Pakistan','41'),
(38,'Panama','42'),
(39,'Netherlands','43'),
(40,'Peru','44'),
(41,'Poland','45'),
(42,'Portugal','46'),
(43,'Romania','47'),
(44,'Sweden','48'),
(45,'Switzerland','49'),
(46,'Czech Republic','51'),
(47,'Thailand','52'),
(48,'Turkey','53'),
(49,'Russia','54'),
(50,'Ukraine','55'),
(51,'Venezuela','56'),
(52,'Serbia (formerly  Serbia and Montenegro?)','57'),
(53,'Ecuador','58'),
(54,'Tunisia','59'),
(55,'Morocco','61'),
(56,'Democratic Republic of the Congo (formerly  Zaire)','62'),
(57,'Algeria (formerly  Gabon?)','63'),
(58,'China','64'),
(59,'Syria','65'),
(60,'Libya','66'),
(61,'Costa Rica','67'),
(62,'Comprehensive Nuclear-Test-Ban Treaty Organization (formerly  East Germany)','68'),
(63,'Guatemala','69'),
(64,'Ivory Coast','71'),
(65,'Malaysia','72'),
(66,'New Zealand','73'),
(67,'Philippines','74'),
(68,'Nigeria','75'),
(69,'Oman','76'),
(70,'Ireland','77'),
(71,'North Korea','78'),
(72, 'Qatar','79'),
(73,'International Atomic Energy Agency','81'),
(74,'United Nations United Nations Industrial Development Organization','82'),
(75,'United Nations United Nations High Commissioner for Refugees','83'),
(76,'UNCB','84'),
(77,'United Nations United Nations Relief and Works Agency for Palestine Refugees in the Near East','85'),
(78,'Nicaragua','86'),
(79,'International Atomic Energy Agency','87'),
(80,'Kuwait','88'),
(81,'United Nations United Nations Industrial Development Organization','89'),
(82,'Organization of the Petroleum Exporting Countries','91'),
(83,'International Organization for Migration','92'),
(84,'United Arab Emirates','93'),
(85,'Senegal','94'),
(86,'Jordan','95'),
(87,'OPEC Fund for International Development','96'),
(88,'Arab League','97'),
(89,'European Union','98'),
(90,'Organization for Security and Co-operation in Europe','247'),
(91,'Slovakia','515'),
(92,'Organization for Security and Co-operation in Europe','532'),
(93,'Vietnam','551'),
(94,'Kenya','622'),
(95,'Azerbaijan/  Namibia/  Zimbabwe?','623'),
(96,'Cape Verde','624'),
(97,'Ethiopia','677'),
(98,'Armenia','678'),
(99,'Slovenia','712'),
(100,'North Macedonia','718'),
(101,'Montenegro','723'),
(102,'Estonia','726'),
(103,'Latvia','728'),
(104,'Malta','846'),
(105,'Tajikistan','853'),
(106,'Kazakhstan','858'),
(107,'Georgia','859'),
(108,'China','872'),
(109,'Angola','891'),
(110,'Cyprus','982'),
(111,'Bolivia','995');
UNLOCK TABLES;