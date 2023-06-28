package utils;

import java.util.Properties;

import static utils.FileUtils.getFile;

public class LangHandler {

    private static final Properties language = new Properties();

    public static String get(String key) {
        final String value = language.getProperty(key);
        if(value != null) {
            return value;
        } else {
            return key;
        }
    }

    public static void initializeLanguage(String lang) {
        try {
            language.load(getFile("lang/" + lang + ".properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
