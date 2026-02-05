package view;

import util.Util;
public class MenuLogin {

    Util util = new Util();

    public String showMenuLogin(){
        return "1) Login\n2) Logout\n";
    }


    public int leOption(){
        showMenuLogin();

        return util.intInput();

    }

    public void executar() {
        int option;
        boolean run;
        do{

            run = true;

            option = leOption();

        }while(run);
    }


}
