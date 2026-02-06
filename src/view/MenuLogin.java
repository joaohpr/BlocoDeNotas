package view;

import util.Util;
public class MenuLogin {

    Util util = new Util();

    public String showMenuLogin(){
        return "1) Login\n2) Logout\n";
    }


    public int inputOption(){
        showMenuLogin();

        return util.intInput();

    }

    public void showOptionOne(){
        System.out.println("===== LOGIN ====");
    }

    public void showOptionTwo() {
        System.out.println("==== LOGOUT ====");
    }


}
