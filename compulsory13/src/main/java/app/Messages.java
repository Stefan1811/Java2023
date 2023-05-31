package app;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {
    private static final String BASE_NAME = "res.Messages";
    private static ResourceBundle resourceBundle;

    static {
        // Set the default locale as the initial locale
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, Locale.getDefault(), Messages.class.getClassLoader());
    }

    public static void setLocale(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(BASE_NAME, locale, Messages.class.getClassLoader());
    }

    public static String getString(String key) {
        return resourceBundle.getString(key);
    }

    public static String getString(String key, Object... arguments) {
        return String.format(resourceBundle.getString(key), arguments);
    }
}
