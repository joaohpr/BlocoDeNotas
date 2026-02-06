package controller;

import view.MenuLogin;
import view.MenuMain;
import view.MenuNotas;
import view.MenuUser;

public class Controller {

    MenuMain menuMain = new MenuMain();
    MenuUser menuUser = new MenuUser();
    MenuNotas menuNotas = new MenuNotas();
    MenuLogin menuLogin = new MenuLogin();

    LoginController loginController = new LoginController();
    NotasController notasController = new NotasController();
    UserController userController = new UserController();






}
