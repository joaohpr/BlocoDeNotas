package view;

import util.Util;

public class MenuMain {

    Util util = new Util();

    public  String showMenuMain(){
        return "\n===== MENU PRINCIPAL =====\n" +
                "1) Usuário\n" +
                "2) Notas\n" +
                "3) Login / Logout\n" +
                "4) Sair\n";
    }


    public int leOption(){
        showMenuMain();

        int optionOfReturn = util.intInput();

        return optionOfReturn;
    }

}
