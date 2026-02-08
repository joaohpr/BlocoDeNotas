package view;

import util.Util;

public class MenuMain {

    Util util = new Util();

    public void showMenuMain() {
        System.out.println(
                "\n===== MENU PRINCIPAL =====\n" +
                        "1) Usuário\n" +
                        "2) Notas\n" +
                        "3) Login / Logout\n" +
                        "4) Sair\n"
        );
    }

    public int inputOptionMain() {
        showMenuMain();
        return util.intInput();
    }
}
