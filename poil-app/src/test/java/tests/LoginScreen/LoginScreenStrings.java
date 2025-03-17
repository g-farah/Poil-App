package tests.LoginScreen;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LoginScreenStrings {
    private static final String BUNDLE_NAME = LoginScreenStrings.class.getPackageName() + ".loginscreenstrings";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private LoginScreenStrings() {

    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
