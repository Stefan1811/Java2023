package comm;

import app.Messages;

import java.util.Locale;

public class DisplayLocales {
    public static void execute() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        System.out.println(Messages.getString("locales"));

        for (Locale locale : availableLocales) {
            System.out.println(locale);
        }
    }
}
