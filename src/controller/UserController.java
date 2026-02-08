package controller;

import sessao.Sessao;
import service.UserService;
import util.Util;
import view.MenuUser;

public class UserController {

    private final UserService userService = new UserService();
    private final MenuUser menuUser = new MenuUser();
    private final Util util = new Util();

    public void runUserController(Sessao sessao) {

        boolean run = true;

        do {
            int option = menuUser.outOption();

            switch (option) {

                case 1 -> {
                    menuUser.showOptionOneUser();

                    System.out.print("Digite o nome: ");
                    String nome = util.stringInput();

                    System.out.print("Digite o email: ");
                    String email = util.stringInput();

                    System.out.print("Digite a senha: ");
                    int senha = util.intInput();

                    userService.criarUser(nome, email, senha);
                }

                case 2 -> {
                    if (!sessao.estaLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }

                    menuUser.showOptionTwoUser();
                    userService.removerUser(sessao);
                }

                case 3 -> {
                    if (!sessao.estaLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }

                    menuUser.showOptionThreeUser();

                    System.out.print("Digite o novo nome: ");
                    String novoNome = util.stringInput();

                    userService.alterarUserName(sessao, novoNome);
                }

                case 4 -> {
                    if (!sessao.estaLogado()) {
                        System.out.println("É necessário estar logado.");
                        break;
                    }

                    menuUser.showOptionFourUser();

                    System.out.print("Digite o novo email: ");
                    String novoEmail = util.stringInput();

                    userService.alterarEmailUser(sessao, novoEmail);
                }

                case 5 -> run = false;

                default -> System.out.println("Opção inválida");
            }

        } while (run);
    }
}
