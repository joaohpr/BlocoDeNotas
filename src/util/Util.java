package util;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Supplier;

public class Util {

    private static final Scanner SC = new Scanner(System.in);

    private static <T> T lerComTratamento(Supplier<T> leitor) {
        while (true) {
            try {
                return leitor.get();
            } catch (Exception e) {
                System.out.println("Erro ao digitar. Tente novamente.");
                SC.nextLine();
            }
        }
    }

    public static int leInteiro() {
        return lerComTratamento(SC::nextInt);
    }

    public static float leFloat() {
        return lerComTratamento(SC::nextFloat);
    }

    public static String leString() {
        return lerComTratamento(SC::nextLine);
    }

    public static char leChar() {
        return lerComTratamento(() -> SC.next().charAt(0));
    }

    public static Date stringParaDate(String dt) {
        try {
            return DateFormat.getDateInstance().parse(dt);
        } catch (Exception e) {
            return null;
        }
    }

    public static String dateParaString(Date dt) {
        try {
            return DateFormat.getDateInstance().format(dt);
        } catch (Exception e) {
            return null;
        }
    }
}
