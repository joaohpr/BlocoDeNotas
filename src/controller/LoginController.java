package controller;

import model.Credenciais;
import view.MenuLogin;
import sessao.Sessao;
import util.Util;

public class LoginController {

    private final Util util = new Util();
    private Credenciais credenciais = new Credenciais();
    private final MenuLogin menuLogin = new MenuLogin();

    public void runLogin(Sessao sessaoInput) {

        boolean run = true;

        do {
            int option = menuLogin.inputOption();

            switch (option) {

                case 1 -> {
                    menuLogin.showOptionOne();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    boolean sucesso = sessaoInput.login(
                            credenciais.getNome(),
                            credenciais.getSenha()
                    );

                    if (sucesso) {
                        System.out.println("Login realizado com sucesso!");
                        run = false;
                    } else {
                        System.out.println("Usuário ou senha inválidos.");
                    }
                }

                case 2 -> {
                    menuLogin.showOptionTwo();

                    if (!sessaoInput.estaLogado()) {
                        System.out.println("Nenhum usuário está logado.");
                        break;
                    }

                    System.out.println("Tem certeza? [s/n]");
                    String resposta = util.stringInput();

                    if (resposta.equalsIgnoreCase("s")) {
                        sessaoInput.logOut();
                        System.out.println("Logout realizado.");
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
