class Translator {
    static cyrillicToLatinMap = {
        "а": "a", "А": "A", "б": "b", "Б": "B", "в": "v", "В": "V", "г": "g", "Г": "G",
        "Ґ": "G", "ґ": "g", "д": "d", "Д": "D", "е": "e", "Е": "E", "ё": "yo", "Ё": "YO",
        "є": "ie", "Є": "Ye", "ж": "zh", "Ж": "ZH", "з": "z", "З": "Z", "и": "i", "И": "I",
        "і": "i", "І": "I", "ї": "i", "Ї": "Yi", "й": "i", "Й": "I", "к": "k", "К": "K",
        "л": "l", "Л": "L", "м": "m", "М": "M", "н": "n", "Н": "N", "о": "o", "О": "O",
        "п": "p", "П": "P", "р": "r", "Р": "R", "с": "s", "С": "S", "т": "t", "Т": "T",
        "у": "u", "У": "U", "ф": "f", "Ф": "F", "х": "h", "Х": "H", "ц": "ts", "Ц": "TS",
        "ч": "ch", "Ч": "CH", "ш": "sh", "Ш": "SH", "щ": "sch", "Щ": "SCH", "ъ": "'", "Ъ": "'",
        "ы": "i", "Ы": "I", "ь": "'", "Ь": "'", "э": "e", "Э": "E", "ю": "yu", "Ю": "YU",
        "я": "ya", "Я": "Ya"
    };

    static containsCyrillic(str) {
        return /[а-яА-ЯЁё]/.test(str);
    }

    static translate(str) {
        return str.split("")
            .map(char => this.cyrillicToLatinMap[char] || char)
            .join("");
    }
}

export default Translator;