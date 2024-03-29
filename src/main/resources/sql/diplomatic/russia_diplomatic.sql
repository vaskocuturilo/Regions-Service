DROP TABLE IF EXISTS `russia_diplomatic_entity`;
CREATE TABLE `russia_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `russia_diplomatic_entity` WRITE;
INSERT INTO `russia_diplomatic_entity` (description, region) VALUES
('Соединенное Королевство Великобритании и Северной Ирландии','001'),
('Федеративная Республика Германия','002'),
('Канада','003'),
('Соединенные Штаты Америки','004'),
('Япония','005'),
('Королевство Испания','006'),
('Французская Республика','007'),
('Королевство Бельгии','008'),
('Греческая Республика','009'),
('Королевство Дания','010'),
('Итальянская Республика','011'),
('Великое Герцогство Люксембург','012'),
('Королевство Нидерландов','013'),
('Королевство Норвегия','014'),
('Турецкая Республика','015'),
('Австралия','016'),
('Австрийская Республика','017'),
('Алжирская Народная Демократическая Республика','018'),
('Арабская Республика Египет','019'),
('Руандийская Республика','020'),
('Аргентинская Республика','021'),
('Исламское Государство Афганистан','022'),
('Союз Мьянма','023'),
('Республика Боливия','024'),
('Федеративная Республика Бразилия','025'),
('Республика Бурунди','026'),
('Республика Гана','027'),
('Народная Республика Бангладеш','028'),
('Гвинейская Республика','029'),
('Республика Замбия','030'),
('Республика Перу','031'),
('Республика Индия','032'),
('Республика Индонезия','033'),
('Иорданское Хашимитское Королевство','034'),
('Республика Ирак','035'),
('Исламская Республика Иран','036'),
('Ирландия','037'),
('Республика Исландия','038'),
('Королевство Камбоджа','039'),
('Республика Кения','040'),
('Республика Кипр','041'),
('Республика Конго','042'),
('Республика Коста-Рика','043'),
('Государство Кувейт','044'),
('Лаосская Народно - Демократическая Республика','045'),
('Республика Либерия','046'),
('Ливанская Республика','047'),
('Социалистическая Народная Ливийская Арабская Джамахирия','048'),
('Республика Мали','049'),
('Королевство Марокко','050'),
('Мексиканские Соединенные Штаты','051'),
('Королевство Непал','052'),
('Федеративная Республика Нигерия','053'),
('Республика Венесуэла','054'),
('Новая Зеландия','055'),
('Исламская Республика Пакистан','056'),
('Буркина Фасо','057'),
('Республика Сенегал','058'),
('Сомалийская Демократическая Республика','060'),
('Республика Судан','061'),
('Республика Сьерра Леоне','062'),
('Королевство Таиланд','063'),
('Объединенная Республика Танзания','064'),
('Тунисская Республика','065'),
('Республика Уганда','066'),
('Восточная Республика Уругвай','067'),
('Республика Филиппины','068'),
('Финляндская Республика','069'),
('Демократическая Социалистическая Республика Шри-Ланка','070'),
('Республика Чад','071'),
('Швейцарская Конфедерация','072'),
('Королевство Швеция','073'),
('Республика Эквадор','074'),
('Федеративная Демократическая Республика Эфиопия','075'),
('Республика Ангола','076'),
('Демократическая Республика Конго','077'),
('Республика Колумбия','078'),
('Республика Камерун','079'),
('Республика Гвинея-Бисау','080'),
('Португальская Республика','081'),
('Республика Болгария','082'),
('Венгерская Республика','083'),
('Социалистическая Республика Вьетнам','084'),
('Республика Польша','086'),
('Корейская Народно - Демократическая Республика','087'),
('Республика Куба','088'),
('Монголия','089'),
('Китайская Народная Республика','090'),
('Румыния','091'),
('Союзная Республика Югославия','093'),
('Республика Бенин','094'),
('Габонская Республика','095'),
('Кооперативная Республика Гайана','096'),
('Исламская Республика Мавритания','097'),
('Республика Мадагаскар','098'),
('Малайзия','099'),
('Республика Нигер','100'),
('Республика Сингапур','101'),
('Тоголезская Республика','102'),
('Центральноафриканская Республика','103'),
('Ямайка','104'),
('Йеменская Республика','105'),
('Государство Палестина','107'),
('Республика Никарагуа','108'),
('Республика Мозамбик','109'),
('Республика Экваториальная Гвинея','110'),
('Суверенный Мальтийский Орден','111'),
('Мальта','112'),
('Республика Кабо-Верде','113'),
('Республика Зимбабве','115'),
('Объединенные Арабские Эмираты','116'),
('Республика Кот-д Ивуар','117'),
('Республика Намибия','118'),
('Султанат Оман','120'),
('Государство Катар','121'),
('Республика Корея','124'),
('Республика Чили','125'),
('Республика Панама','126'),
('Государство Израиль','127'),
('Республика Македония','128'),
('Республика Албания','129'),
('Святой Престол','131'),
('Литовская Республика','132'),
('Сирийская Арабская Республика','133'),
('Эстонская Республика','134'),
('Латвийская Республика','135'),
('Государство Бахрейн','136'),
('Южно-Африканская Республика','137'),
('Республика Армения','138'),
('Королевство Саудовская Аравия','140'),
('Республика Словения','141'),
('Республика Узбекистан','142'),
('Киргизская Республика','143'),
('Республика Хорватия','144'),
('Азербайджанская Республика','145'),
('Украина','146'),
('Республика Молдова','147'),
('Чешская Республика','148'),
('Словацкая Республика','149'),
('Республика Беларусь','150'),
('Республика Таджикистан','151'),
('Туркменистан','152'),
('Республика Казахстан','153'),
('Республика Гватемала','154'),
('Босния и Герцеговина','155'),
('Государство Эритрея','156'),
('Республика Парагвай','157'),
('Грузия','158'),
('Государство Бруней - Даруссалам','159'),
('Республика Гамбия','160'),
('Социалистическая Республика Вьетнам','161'),
('Республика Маврикий','162'),
('Доминиканская Республика','163'),
('Черногория','164'),
('Республика Южная Осетия','165'),
('Республика Абхазия','166'),
('Республика Джибути','167'),
('Республика Южный Судан','168'),
('Республика Эль-Сальвадор','169'),
('Гренада','170'),
('Комиссия Европейских сообществ','499'),
('Европейский банк реконструкции и развития','500'),
('Лига Арабских Государств','503'),
('Международный банк реконструкции и развития','504'),
('Международный валютный фонд','505'),
('Международная организация по миграции','506'),
('Международная федерация обществ Красного Креста и Красного Полумесяца','507'),
('Международный комитет Красного Креста','508'),
('Международная финансовая корпорация','509'),
('Организация Объединенных Наций по промышленному развитию','510'),
('Организация Объединенных Наций','511'),
('Организация Объединенных Наций по вопросам образования, науки и культуры','512'),
('Международный банк экономического сотрудничества','514'),
('Международный инвестиционный банк','515'),
('Международная организация космической связи Интерспутник','516'),
('Международный центр научной и технической информации','517'),
('Международный научно-технический центр','518'),
('Международная организация труда','520'),
('Международная организация по экономическому и научно - техническому сотрудничеству в области электротехнической промышленности Интерэлектро','521'),
('Координационный центр Межправительственной комиссии по сотрудничеству в области вычислительной техники','522'),
('Межгосударственный экономический Комитет Экономического союза','523'),
('Европейское космическое агентство в Российской Федерации','524'),
('Евразийская патентная организация','525'),
('Тайбэйско - Московская координационная Комиссия по экономическому и культурному сотрудничеству','526'),
('Штаб по координации военного сотрудничества государств-участников Содружества Независимых Государств','527');
UNLOCK TABLES;

ALTER TABLE russia_diplomatic_entity ADD INDEX russia_diplomatic_index (description, region);