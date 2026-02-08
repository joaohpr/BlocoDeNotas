package controller;

import sessao.Sessao;
import view.MenuMain;

public class MainController {

    private final LoginController loginController = new LoginController();
    private final NotasController notasController = new NotasController();
    private final UserController userController = new UserController();
    private final MenuMain menuMain = new MenuMain();

    private final Sessao sessao = new Sessao();

    public void runMainController() {

        boolean run = true;

        do {
            int option = menuMain.inputOptionMain();

            switch (option) {

                case 1 -> userController.runUserController(sessao);

                case 2 -> notasController.runNotasController(sessao);

                case 3 -> loginController.runLogin(sessao);

                case 4 -> run = false;

                default -> System.out.println("Opção inválida.");
            }

        } while (run);
    }
}
