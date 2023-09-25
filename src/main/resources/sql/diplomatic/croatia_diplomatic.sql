DROP TABLE IF EXISTS `croatia_diplomatic_entity`;
CREATE TABLE `croatia_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `croatia_diplomatic_entity` WRITE;
INSERT INTO `croatia_diplomatic_entity` (description, region) VALUES
('Holy See','010'),
('Germany','011'),
('Austria','012'),
('Italy','013'),
('Hungary','014'),
('Sweden','015'),
('Slovenia','016'),
('Poland','017'),
('France','018'),
('United Kingdom','020'),
('Switzerland','021'),
('China','022'),
('Norway','023'),
('United States','024'),
('Bulgaria','025'),
('Iran','026'),
('Russia','027'),
('Czech Republic','028'),
('Slovakia','029'),
('Bosnia and Herzegovina','030'),
('Turkey','031'),
('Romania','032'),
('UNICEF','033'),
('WHO','034'),
('UNHCR','035'),
('Spain','039'),
('Malta','040'),
('Belgium','041'),
('Canada','043'),
('Albania','047'),
('Netherlands','048'),
('Serbia','049'),
('North Macedonia','050'),
('Malaysia','051'),
('Greece','053'),
('Ukraine','054'),
('Chile','055'),
('IMF (International Monetary Fund)','056'),
('India','057'),
('UNDP (United Nations Development Programme)','058'),
('European Union','059'),
('OSCE (Organization for Security and Co-operation in Europe)','063'),
('South Korea','064'),
('Finland','066'),
('Egypt','067'),
('World Bank','069'),
('Japan','070'),
('Israel','071'),
('Portugal','073'),
('Australia','074'),
('RACVIAC (Centre for Security Cooperation)','077'),
('Libya','078'),
('Denmark','079'),
('International Sava River Basin Commission','081'),
('Brazil','082'),
('United Nations','083'),
('Montenegro','084'),
('Algeria','085'),
('Kazakhstan','086'),
('Kosovo','087'),
('Azerbaijan','088'),
('Indonesia','089'),
('Morocco','090'),
('Qatar','091'),
('Lithuania','092'),
('Ireland','094'),
('Iraq','095');
UNLOCK TABLES;

ALTER TABLE croatia_diplomatic_entity ADD INDEX croatia_diplomatic_index (description, region);