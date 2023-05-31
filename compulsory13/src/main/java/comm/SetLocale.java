package comm;

import app.Messages;

import java.util.Locale;

public class SetLocale {
    public static void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
        System.out.println(Messages.getString("locale.set", locale));
    }
}
