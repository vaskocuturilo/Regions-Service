DROP TABLE IF EXISTS `france_diplomatic_entity`;
CREATE TABLE `france_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `france_diplomatic_entity` WRITE;
INSERT INTO `france_diplomatic_entity` (description, region) VALUES
('South Africa','2'),
('Algeria','4'),
('Germany','5'),
('United States','6'),
('Egypt','7'),
('Argentina','9'),
('Austria','11'),
('Belgium','12'),
('Brazil','16'),
('Cameroon','20'),
('China','26'),
('Colombia','28'),
('Denmark','36'),
('Spain','40'),
('Gabon','43'),
('United Kingdom','45'),
('Greece','46'),
('India','53'),
('Indonesia','54'),
('Israel','59'),
('Italy','60'),
('Japan','62'),
('Jordan','63'),
('Lebanon','67'),
('Morocco','76'),
('Mauritania','77'),
('Mexico','78'),
('Peru','91'),
('Poland','93'),
('Portugal','94'),
('Romania','96'),
('Senegal','100'),
('Switzerland','105'),
('Tunisia','113'),
('Turkey','114'),
('Russia','115'),
('Yugoslavia','120'),
('Eritrea','180'),
('European Union','415'),
('European Union Euratom','416'),
('CERN','431'),
('Organisation internationale de la Francophonie','433'),
('International Bureau of Weights and Measures','434'),
('European Molecular Biology Laboratory','435');
UNLOCK TABLES;

ALTER TABLE france_diplomatic_entity ADD INDEX france_diplomatic_index (description, region);