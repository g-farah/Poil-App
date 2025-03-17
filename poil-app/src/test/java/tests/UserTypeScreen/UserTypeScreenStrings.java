package tests.UserTypeScreen;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class UserTypeScreenStrings {
    private static final String BUNDLE_NAME = UserTypeScreenStrings.class.getPackageName() + ".usertypesscreenstrings";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private UserTypeScreenStrings(){}

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}
