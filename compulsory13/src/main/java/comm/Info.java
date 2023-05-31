package comm;

import app.Messages;

import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;

public class Info {
    public static void execute(String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        System.out.println(Messages.getString("info", locale));

        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));
        System.out.println("Currency: " + Currency.getInstance(locale).getCurrencyCode() + " (" + Currency.getInstance(locale).getDisplayName() + ")");
        System.out.println("Week Days: " + String.join(", ", DateFormatSymbols.getInstance(locale).getWeekdays()));
        System.out.println("Months: " + String.join(", ", DateFormatSymbols.getInstance(locale).getMonths()));
        System.out.println("Today: " + DateFormatSymbols.getInstance(locale).getLocalPatternChars());
    }
}
