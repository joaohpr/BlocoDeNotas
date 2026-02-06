package controller;

import model.Credenciais;
import view.MenuLogin;
import sessao.Sessao;
import util.Util;

public class LoginController {

    public Util util = new Util();
    public Credenciais credenciais = new Credenciais();
    public MenuLogin menuLogin = new MenuLogin();

    public  void runLogin(Sessao sessaoInput) {

        boolean run = true;

        do {
            int option = menuLogin.inputOption();

            switch (option) {

                case 1 -> {
                    menuLogin.showOptionOne();
                    credenciais = credenciais.obterCredenciais(sessaoInput,util);
                    sessaoInput.login(credenciais.getNome(), credenciais.getSenha());
                    run = false;
                }

                case 2 -> {
                    menuLogin.showOptionTwo();
                    System.out.println("Tem certeza? [s/n]");
                    String resposta = util.stringInput();

                    if (resposta.equalsIgnoreCase("s")) {
                        sessaoInput.logOut();
                        run = false;
                    }
                }

                default -> {
                    System.out.println("Opção inválida.");
                }
            }

        } while (run);
    }
}
