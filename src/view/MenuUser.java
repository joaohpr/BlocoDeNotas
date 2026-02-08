package view;

import util.Util;

public class MenuUser {

    Util util = new Util();

    public String showMenuUser() {

        return   "\n===== MENU USUÁRIO =====\n" +
                "1 - Criar usuário\n" +
                "2 - Remover usuário\n" +
                "3 - Alterar nome\n" +
                "4 - Alterar email\n" +
                "5 - Voltar\n";

    }

    public int outOption() {
        showMenuUser();

        int option = util.intInput();

        return  option;
    }


    public void showOptionOneUser() {
        System.out.println("==== CRIAR USUARIO ==== ");
    }

    public void showOptionTwoUser() {
        System.out.println("==== REMOVER USUARIO ====");
    }

    public void showOptionThreeUser() {
        System.out.println("==== ALTERAR NOME ====");
    }

    public void showOptionFourUser() {
        System.out.println("==== ALTERAR EMAIL ====");
    }

    public void showOptionFiveUser() {
        System.out.println("==== VOLTANDO ====");
    }

}
