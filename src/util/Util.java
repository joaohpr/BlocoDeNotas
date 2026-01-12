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

    public static boolean userIsValid(User userInput) {

        boolean userIsNull = false;
        boolean userNameIsPresent = false;
        boolean emailIsNull = false;
        boolean senhaIsValid = false;

        if (userInput == null) {
            userIsNull = true;
        } else {

            if (userInput.getUserName() != null) {
                userNameIsPresent = true;
            }

            if (userNameIsPresent) {
                if (userInput.getEmailUser() == null) {
                    emailIsNull = true;
                }
            }

            if (userNameIsPresent) {
                if (userInput.getSenhaUser() != 0  && ( userInput.getSenhaUser() >= 100000 && userInput.getSenhaUser() <= 999999)) {
                    senhaIsValid = true;
                }
            }
        }

        if (userIsNull) {
            return true;
        }

        if (userNameIsPresent && emailIsNull && senhaIsValid) {
            return true;
        }

        return false;

    }


    public static boolean notaIsValid(Notas nota) {
        if (nota == null) return false;

        return nota.getTitle() != null
                && nota.getNota() != null;
    }

}
