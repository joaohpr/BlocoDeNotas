package util;

import model.Notas;
import model.User;

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
                SC.nextLine(); // limpa o buffer
            }
        }
    }

    public static int leInteiro() {
        return lerComTratamento(() -> {
            int v = SC.nextInt();
            SC.nextLine(); // consome o \n deixado pelo Enter
            return v;
        });
    }

    public static float leFloat() {
        return lerComTratamento(() -> {
            float v = SC.nextFloat();
            SC.nextLine(); // consome o \n
            return v;
        });
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


    public static boolean notaIsValid(Notas nota) {
        if (nota == null) return false;

        return nota.getTitle() != null && !nota.getTitle().isBlank()
                && nota.getNota()  != null && !nota.getNota().isBlank();
    }

    public static boolean userIsValid(User user) {
        if (user == null) return false;

        return user.getUserName()  != null && !user.getUserName().isBlank()
                && user.getEmailUser() != null && !user.getEmailUser().isBlank();
    }



}
