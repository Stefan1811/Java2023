package app;

import comm.DisplayLocales;
import comm.Info;
import comm.SetLocale;

import java.util.Scanner;

public class LocaleExplore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println(Messages.getString("prompt"));
            String command = scanner.nextLine();

            switch (command) {
                case "locales":
                    DisplayLocales.execute();
                    break;
                case "set":
                    System.out.println(Messages.getString("prompt"));
                    String languageTag = scanner.nextLine();
                    SetLocale.execute(languageTag);
                    break;
                case "info":
                    System.out.println(Messages.getString("prompt"));
                    languageTag = scanner.nextLine();
                    Info.execute(languageTag);
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    System.out.println(Messages.getString("invalid"));
                    break;
            }
        }

        scanner.close();
    }
}
