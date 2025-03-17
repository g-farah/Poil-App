package tests.LanguageScreen;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguagesScreenStrings {
    private static final String BUNDLE_NAME = LanguagesScreenStrings.class.getPackageName() + ".languagesscreenstrings";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private LanguagesScreenStrings() {

    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
