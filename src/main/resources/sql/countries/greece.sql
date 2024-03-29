DROP TABLE IF EXISTS `greece_entity`;

CREATE TABLE `greece_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `greece_entity` WRITE;
/*!40000 ALTER TABLE `greece_entity` DISABLE KEYS */;
INSERT INTO `greece_entity` (description, region) VALUES
('Achaia prefecture - Patras','AA'),
('Kavala prefecture - Kavala {motorcycles}','AB'),
('Lasithi prefecture - Agios Nikolaos','AE'),
('Achaia prefecture - Patras','AZ'),
('Xanthi prefecture - Xanthi','AH'),
('Xanthi prefecture - Xanthi','AHH'),
('Aitoloakarnania prefecture - Agrinio area.','AI'),
('Aitoloakarnania prefecture - Agrinio area.','AII'),
('Laconia prefecture - Sparti','AK'),
('Phokida prefecture - Amfissa','AM'),
('Lasithi prefecture - Agios Nikolaos','AN'),
('Achaia prefecture - Patras {motorcycles}','AO'),
('Argolis (Argolida) prefecture - Nafplio','AP'),
('Arta prefecture - Arta','AT'),
('Achaia prefecture - Patras {motorcycles}','AY'),
('Achaia prefecture - Patras','AX'),
('Magnesia prefecture - Volos {motorcycles}','BA'),
('Magnesia prefecture - Volos {motorcycles}','BB'),
('Piraeus prefecture {motorcycles}','BE'),
('Piraeus prefecture {motorcycles}','BZ'),
('Piraeus prefecture {motorcycles}','BH'),
('Boeotia (Viotia) prefecture - Livadeia','BI'),
('East Attica prefecture - Pallini','BK'),
('East Attica prefecture - Pallini','BM'),
('West Attica prefecture - Elefsina','BN'),
('Magnesia prefecture - Volos ','BO'),
('Pella Prefecture','BOP'),
('West Attica prefecture - Elefsina','BP'),
('Magnesia prefecture - Volos','BT'),
('Boeotia (Viotia) prefecture - Livadeia','BY'),
('Piraeus prefecture {motorcycles}','BX'),
('Dodecanese prefecture - Kos island {motorcycles}','EA'),
('Evros prefecture - Alexandroupoli','EB'),
('Evros prefecture - Alexandroupoli','EBB'),
('Pella Prefecture - Edessa','EE'),
('Pella Prefecture - Edessa','EEE'),
('Cyclades prefecture - Ermoupoli {motorcycles}','EZ'),
('Euboea (Evia) prefecture - Chalkida {motorcycles}','EH'),
('Euboea (Evia) prefecture - Chalkida {motorcycles}','EI'),
('Cyclades prefecture - Ermoupoli','EM'),
('Serres prefecture - Serres','EP'),
('Corfu (Kerkyra) prefecture - Corfu {motorcycles}','ET'),
('Lefkada prefecture - Lefkada ','EY'),
('Rodos Island','EYA'),
('tax free cars of offshore companies','EYY'),
('Kilkis prefecture - Kilkis','EX'),
('Zakynthos prefecture - Zakynthos','ZA'),
('Zakynthos prefecture - Zakynthos','ZB'),
('Thessaloniki prefecture','ZE'),
('Athens prefecture','ZZ'),
('Athens prefecture','ZH'),
('Thessaloniki prefecture','ZI'),
('Athens prefecture','ZK'),
('Athens prefecture','ZM'),
('Piraeus prefecture','ZN'),
('Thessaloniki prefecture','ZO'),
('Piraeus prefecture {motorcycles}','ZP'),
('West Attica prefecture - Elefsina {motorcycles}','ZT'),
('East Attica prefecture - Pallini','ZY'),
('East Attica prefecture - Pallini','ZX'),
('Ilia prefecture - Pyrgos','HA'),
('Athens prefecture {motorcycles}','HB'),
('Ilia prefecture - Pyrgos {motorcycles}','HE'),
('Heraklion prefecture - Heraklion','HZ'),
('Heraklion prefecture - Heraklion {motorcycles}','HH'),
('Heraklion prefecture - Heraklion {motorcycles}','HI'),
('Heraklion prefecture - Heraklion ','HK'),
('Chania Prefecture','HKH'),
('Chania Prefecture','HKZ'),
('Imathia prefecture - Veria','HM'),
('Thesprotia prefecture - Igoumenitsa','HN'),
('Xanthi prefecture - Xanthi {motorcycles}','HO'),
('Heraklion prefecture - Heraklion','HP'),
('Xanthi prefecture - Xanthi','HT'),
('Phthiotis (Fthiotida) prefecture - Lamia','HY'),
('Imathia prefecture - Veria','HX'),
('Athens prefecture','IB'),
('Athens prefecture','IE'),
('Athens prefecture','IZ'),
('Athens prefecture','IH'),
('Euboea Prefecture','IHA'),
('Ioannina prefecture - Ioannina','II'),
('Athens prefecture','IK'),
('Athens prefecture','IM'),
('Ioannina prefecture - Ioannina','IN'),
('Athens prefecture','IO'),
('Athens prefecture','IP'),
('Athens prefecture','IT'),
('Athens prefecture','IY'),
('Serres prefecture','IX'),
('Karditsa prefecture - Karditsa','KA'),
('Karditsa prefecture - Karditsa','KAA'),
('Kavala prefecture - Kavala ','KB'),
('Kavala prefecture - Kavala ','KBB'),
('Kefalonia and Ithaca prefecture - Argostoli','KE'),
('Kefalonia and Ithaca prefecture - Argostoli','KEE'),
('Kozani prefecture - Kozani','KZ'),
('Kozani prefecture - Kozani','KZZ'),
('Evrytania prefecture - Karpenisi','KH'),
('Kilkis prefecture - Kilkis','KI'),
('Messinia prefecture - Kalamata','KM'),
('Pieria prefecture - Katerini','KN'),
('Pieria prefecture - Katerini','KNZ'),
('Rhodope (Rodopi) prefecture - Komotini','KO'),
('Thessaloniki prefecture','KOH'),
('Thessaloniki prefecture','KOK'),
('Heraklio prefecture {motorcycles}','KOP'),
('Corinthia prefecture - Corinth (Korinthos)','KP'),
('Kastoria prefecture - Kastoria','KT'),
('Corfu (Kerkyra) prefecture - Corfu','KY'),
('Dodecanese prefecture - Kos island','KX'),
('Rodos Island','KXA'),
('Chalkidiki prefecture - Polygyros','MA'),
('Samos prefecture - Samos','MB'),
('Aitoloakarnania prefecture - Messolongi','ME'),
('Messinia prefecture - Kalamata {motorcycles}','MZ'),
('Lesvos prefecture - Myrina (Limnos island)','MH'),
('Phthiotis (Fthiotida) prefecture - Lamia','MI'),
('Karditsa prefecture - Karditsa','MK'),
('Pella Prefecture - Edessa','MM'),
('Kozani prefecture - Kozani','MN'),
('Samos prefecture - Samos','MO'),
('Rodos Island {motorcycles}','MOK'),
('Rodos Island {motorcycles}','MOM'),
('Rodos Island {motorcycles}','MOP'),
('Laconia prefecture - Sparti','MP'),
('Lesbos prefecture - Mytilini {motorcycles}','MT'),
('Lesbos (Lesvos) prefecture - Mytilini ','MY'),
('Rodos Island','MYZ'),
('Evros prefecture - Alexandroupoli','MX'),
('Thessaloniki prefecture - Thessaloniki','NA'),
('Thessaloniki prefecture - Thessaloniki','NB'),
('Thessaloniki prefecture - Thessaloniki','NE'),
('Thessaloniki prefecture - Thessaloniki','NZ'),
('Thessaloniki prefecture - Thessaloniki','NH'),
('Thessaloniki prefecture - Thessaloniki','NI'),
('Thessaloniki prefecture - Thessaloniki','NK'),
('Thessaloniki prefecture - Thessaloniki {motorcycles}','NM'),
('Thessaloniki prefecture - Thessaloniki {motorcycles}','NN'),
('Thessaloniki prefecture - Thessaloniki {motorcycles}','NO'),
('Thessaloniki prefecture {motorcycles}','NP'),
('Thessaloniki prefecture','NT'),
('Thessaloniki prefecture','NY'),
('Thessaloniki prefecture','NX'),
('Athens {motorcycles}','OA'),
('Athens {motorcycles}','OB'),
('Athens {motorcycles}','OE'),
('Athens {motorcycles}','OZ'),
('Athens {motorcycles}','OH'),
('Athens {motorcycles}','OI'),
('Athens {motorcycles}','OK'),
('Athens {motorcycles}','OM'),
('Athens {motorcycles}','ON'),
('Athens {motorcycles}','OO'),
('Evros prefecture - Orestiada area','OP'),
('Athens','OT'),
('Athens {motorcycles}','OY'),
('Athens ','OX'),
('Florina prefecture - Florina','PA'),
('Florina prefecture - Florina','PAA'),
('Corinthia prefecture - Corinth','PB'),
('Rethymno prefecture - Rethymno ','PE'),
('Rethymno prefecture - Rethymno ','PEE'),
('Preveza prefecture - Preveza ','PZ'),
('Preveza prefecture - Preveza ','PZB'),
('Rethymno prefecture - Rethymno {motorcycles}','PH'),
('Larissa prefecture - Larissa','PI'),
('Dodecanese prefecture - Rodos (Rhodes)','PK'),
('Drama prefecture - Drama','PM'),
('Drama prefecture - Drama','PMZ'),
('Grevena prefecture - Grevena','PN'),
('Dodecanese prefecture - Rhodes (Rodos)','PO'),
('Larissa prefecture - Larissa','PP'),
('Larissa prefecture - Larissa','PT'),
('Dodecanese prefecture - Rodos (Rhodes) {motorcycles}','PY'),
('Dodecanese prefecture - Rodos (Rhodes)','PX'),
('Corfu (Kerkyra) prefecture - Corfu {motorcycles}','TB'),
('Corfu (Kerkyra) prefecture - Corfu','TE'),
('Piraeus prefecture {motorcycles}','TZ'),
('Aitoloakarnania prefecture - Agrinio area','TH'),
('Pieria prefecture - Katerini','TI'),
('Trikala prefecture - Trikala','TK'),
('Argolis (Argolida) prefecture - Nafplio','TM'),
('Trikala prefecture - Trikala','TN'),
('Drama prefecture - Drama','TO'),
('Arcadia prefecture - Tripoli','TP'),
('Rhodope prefecture','TT'),
('Chania prefecture - Chania {motorcycles}','TY'),
('Preveza prefecture - Preveza','TX'),
('Athens prefecture','YA'),
('Athens prefecture','YB'),
('Athens prefecture','YE'),
('Athens prefecture','YZ'),
('Athens prefecture','YH'),
('Euboea Prefecture','YHA'),
('Piraeus prefecture','YI'),
('Piraeus prefecture','YK'),
('Piraeus prefecture','YM'),
('Piraeus prefecture','YN'),
('West Attica prefecture - Elefsina','YO'),
('West Attica prefecture - Elefsina','YP'),
('West Attica prefecture - Elefsina','YT'),
('East Attica prefecture - Pallini','YY'),
('East Attica prefecture - Pallini','YX'),
('Euboea (Evia) prefecture - Chalkida','XA'),
('Chania prefecture - Chania {motorcycles}','XB'),
('Athens prefecture {now used for both motorcycles and cars}','XE'),
('Athens prefecture {motorcycles}','XZ'),
('Athens prefecture {motorcycles}','XH'),
('Chios prefecture - Chios','XI'),
('Chalkidiki prefecture - Polygyros','XK'),
('Athens prefecture','XM'),
('Chania prefecture - Chania ','XN'),
('Chania prefecture - Chania {motorcycles} ','XNO'),
('Chios prefecture - Chios {motorcycles}','XO'),
('Athens prefecture {motorcycles}','XP'),
('Athens prefecture {motorcycles}','XT'),
('Athens prefecture {motorcycles}','XY'),
('Athens prefecture {motorcycles}','XX'),
('Athens International Airport service vehicles','AIA');
UNLOCK TABLES;

ALTER TABLE greece_entity ADD INDEX greece_index (description, region);