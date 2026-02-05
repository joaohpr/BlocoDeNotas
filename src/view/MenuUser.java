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

}
