package view;

import util.Util;

public class MenuLogin {

    Util util = new Util();

    public void showMenuLogin() {
        System.out.println(
                "1) Login\n" +
                        "2) Logout\n"
        );
    }

    public int inputOption() {
        showMenuLogin();
        return util.intInput();
    }

    public void showOptionOne() {
        System.out.println("===== LOGIN =====");
    }

    public void showOptionTwo() {
        System.out.println("===== LOGOUT =====");
    }
}
