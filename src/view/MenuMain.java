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


    public int inputOptionMain(){
        showMenuMain();

        int optionOfReturn = util.intInput();

        return optionOfReturn;
    }

    public void showOptionOneMain() {
        System.out.println("==== USUÁRIO ====");
    }

    public void showOptionTwoMain() {
        System.out.println("==== NOTAS ====");
    }

    public void showOptionThreeMain() {
        System.out.println("==== LOGIN / LOGOUT ====");
    }

    public void showOptionFourMain() {
        System.out.println("==== SAIR ====");
    }


}
