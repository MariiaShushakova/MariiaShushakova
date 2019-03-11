package hw10.core;

public class YandexSpellerConstants {

    //useful constants for API under test
    public static final String YANDEX_SPELLER_API_URI = "https://speller.yandex.net/services/spellservice.json/checkText";
    public static final String PARAM_TEXT = "text";
    public static final String PARAM_OPTIONS = "options";
    public static final String PARAM_LANG = "lang";
    public static final String WRONG_WORD_UK = "питаня";
    public static final String WORD_WITH_WRONG_CAPITAL = "moscow";
    public static final String WORD_WITH_LEADING_DIGITS = "11" + SimpleWord.BROTHER.corrVer;
    public static final String QUOTES = "\"";


    public enum SimpleWord{
        MOTHER("mother", "mottherr"),
        BROTHER("brother", "bbrother");

        private String corrVer;
        private String wrongVer;

        private SimpleWord(String corrVer, String wrongVer){
            this.corrVer = corrVer;
            this.wrongVer = wrongVer;
        }

        public String getCorrectVersion(){return corrVer;}
        public String getWrongVersion(){return wrongVer;}
    }

    public enum Language {
        RU("ru"),
        UK("uk"),
        EN("en");
        private String languageCode;

        Language(String lang) {
            this.languageCode = lang;
        }

        public String getLangCode(){
            return languageCode;
        }
    }

    public enum SoapAction {
        CHECK_TEXT("checkText", "CheckTextRequest"),
        CHECK_TEXTS("checkTexts", "CheckTextsRequest");

        private String method;
        private String reqName;

        SoapAction(String action, String reqName) {
            this.method = action;
            this.reqName = reqName;
        }

        public String getMethod() {
            return method;
        }

        public String getReqName() {
            return reqName;
        }

    }

    public enum Options {
        IGNORE_DIGITS(2),
        IGNORE_URLS(4),
        FIND_REPEAT_WORDS(8),
        IGNORE_CAPITALIZATION(512);

        private int value;

        Options(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
