DROP TABLE IF EXISTS `russia_diplomatic_entity`;
CREATE TABLE `russia_diplomatic_entity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `region` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

LOCK TABLES `russia_diplomatic_entity` WRITE;
INSERT INTO `russia_diplomatic_entity` (region, description) VALUES
('001','Соединенное Королевство Великобритании и Северной Ирландии'),
('002','Федеративная Республика Германия'),
('003','Канада'),
('004','Соединенные Штаты Америки'),
('005','Япония'),
('006','Королевство Испания'),
('007','Французская Республика'),
('008','Королевство Бельгии'),
('009','Греческая Республика'),
('010','Королевство Дания'),
('011','Итальянская Республика'),
('012','Великое Герцогство Люксембург'),
('013','Королевство Нидерландов'),
('014','Королевство Норвегия'),
('015','Турецкая Республика'),
('016','Австралия'),
('017','Австрийская Республика'),
('018','Алжирская Народная Демократическая Республика'),
('019','Арабская Республика Египет'),
('020','Руандийская Республика'),
('021','Аргентинская Республика'),
('022','Исламское Государство Афганистан'),
('023','Союз Мьянма'),
('024','Республика Боливия'),
('025','Федеративная Республика Бразилия'),
('026','Республика Бурунди'),
('027','Республика Гана'),
('028','Народная Республика Бангладеш'),
('029','Гвинейская Республика'),
('030','Республика Замбия'),
('031','Республика Перу'),
('032','Республика Индия'),
('033','Республика Индонезия'),
('034','Иорданское Хашимитское Королевство'),
('035','Республика Ирак'),
('036','Исламская Республика Иран'),
('037','Ирландия'),
('038','Республика Исландия'),
('039','Королевство Камбоджа'),
('040','Республика Кения'),
('041','Республика Кипр'),
('042','Республика Конго'),
('043','Республика Коста-Рика'),
('044','Государство Кувейт'),
('045','Лаосская Народно - Демократическая Республика'),
('046','Республика Либерия'),
('047','Ливанская Республика'),
('048','Социалистическая Народная Ливийская Арабская Джамахирия'),
('049','Республика Мали'),
('050','Королевство Марокко'),
('051','Мексиканские Соединенные Штаты'),
('052','Королевство Непал'),
('053','Федеративная Республика Нигерия'),
('054','Республика Венесуэла'),
('055','Новая Зеландия'),
('056','Исламская Республика Пакистан'),
('057','Буркина Фасо'),
('058','Республика Сенегал'),
('060','Сомалийская Демократическая Республика'),
('061','Республика Судан'),
('062','Республика Сьерра Леоне'),
('063','Королевство Таиланд'),
('064','Объединенная Республика Танзания'),
('065','Тунисская Республика'),
('066','Республика Уганда'),
('067','Восточная Республика Уругвай'),
('068','Республика Филиппины'),
('069','Финляндская Республика'),
('070','Демократическая Социалистическая Республика Шри-Ланка'),
('071','Республика Чад'),
('072','Швейцарская Конфедерация'),
('073','Королевство Швеция'),
('074','Республика Эквадор'),
('075','Федеративная Демократическая Республика Эфиопия'),
('076','Республика Ангола'),
('077','Демократическая Республика Конго'),
('078','Республика Колумбия'),
('079','Республика Камерун'),
('080','Республика Гвинея-Бисау'),
('081','Португальская Республика'),
('082','Республика Болгария'),
('083','Венгерская Республика'),
('084','Социалистическая Республика Вьетнам'),
('086','Республика Польша'),
('087','Корейская Народно - Демократическая Республика'),
('088','Республика Куба'),
('089','Монголия'),
('090','Китайская Народная Республика'),
('091','Румыния'),
('093','Союзная Республика Югославия'),
('094','Республика Бенин'),
('095','Габонская Республика'),
('096','Кооперативная Республика Гайана'),
('097','Исламская Республика Мавритания'),
('098','Республика Мадагаскар'),
('099','Малайзия'),
('100','Республика Нигер'),
('101','Республика Сингапур'),
('102','Тоголезская Республика'),
('103','Центральноафриканская Республика'),
('104','Ямайка'),
('105','Йеменская Республика'),
('107','Государство Палестина'),
('108','Республика Никарагуа'),
('109','Республика Мозамбик'),
('110','Республика Экваториальная Гвинея'),
('111','Суверенный Мальтийский Орден'),
('112','Мальта'),
('113','Республика Кабо-Верде'),
('115','Республика Зимбабве'),
('116','Объединенные Арабские Эмираты'),
('117','Республика Кот-д''Ивуар'),
('118','Республика Намибия'),
('120','Султанат Оман'),
('121','Государство Катар'),
('124','Республика Корея'),
('125','Республика Чили'),
('126','Республика Панама'),
('127','Государство Израиль'),
('128','Республика Македония'),
('129','Республика Албания'),
('131','Святой Престол'),
('132','Литовская Республика'),
('133','Сирийская Арабская Республика'),
('134','Эстонская Республика'),
('135','Латвийская Республика'),
('136','Государство Бахрейн'),
('137','Южно-Африканская Республика'),
('138','Республика Армения'),
('140','Королевство Саудовская Аравия'),
('141','Республика Словения'),
('142','Республика Узбекистан'),
('143','Киргизская Республика'),
('144','Республика Хорватия'),
('145','Азербайджанская Республика'),
('146','Украина'),
('147','Республика Молдова'),
('148','Чешская Республика'),
('149','Словацкая Республика'),
('150','Республика Беларусь'),
('151','Республика Таджикистан'),
('152','Туркменистан'),
('153','Республика Казахстан'),
('154','Республика Гватемала'),
('155','Босния и Герцеговина'),
('156','Государство Эритрея'),
('157','Республика Парагвай'),
('158','Грузия'),
('159','Государство Бруней - Даруссалам'),
('160','Республика Гамбия'),
('161','Социалистическая Республика Вьетнам'),
('162','Республика Маврикий'),
('163','Доминиканская Республика'),
('164','Черногория'),
('165','Республика Южная Осетия'),
('166','Республика Абхазия'),
('167','Республика Джибути'),
('168','Республика Южный Судан'),
('169','Республика Эль-Сальвадор'),
('170','Гренада'),
('499','Комиссия Европейских сообществ'),
('500','Европейский банк реконструкции и развития'),
('503','Лига Арабских Государств'),
('504','Международный банк реконструкции и развития'),
('505','Международный валютный фонд'),
('506','Международная организация по миграции'),
('507','Международная федерация обществ Красного Креста и Красного Полумесяца'),
('508','Международный комитет Красного Креста'),
('509','Международная финансовая корпорация'),
('510','Организация Объединенных Наций по промышленному развитию'),
('511','Организация Объединенных Наций'),
('512','Организация Объединенных Наций по вопросам образования, науки и культуры'),
('514','Международный банк экономического сотрудничества'),
('515','Международный инвестиционный банк'),
('516','Международная организация космической связи Интерспутник'),
('517','Международный центр научной и технической информации'),
('518','Международный научно-технический центр'),
('520','Международная организация труда'),
('521','Международная организация по экономическому и научно - техническому сотрудничеству в области электротехнической промышленности Интерэлектро'),
('522','Координационный центр Межправительственной комиссии по сотрудничеству в области вычислительной техники'),
('523','Межгосударственный экономический Комитет Экономического союза'),
('524','Европейское космическое агентство в Российской Федерации'),
('525','Евразийская патентная организация'),
('526','Тайбэйско - Московская координационная Комиссия по экономическому и культурному сотрудничеству'),
('527','Штаб по координации военного сотрудничества государств-участников Содружества Независимых Государств');
UNLOCK TABLES;

ALTER TABLE russia_diplomatic_entity ADD INDEX russia_diplomatic_index (description, region);