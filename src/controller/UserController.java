package controller;

import util.Util;
import sessao.Sessao;
import service.UserService;
import model.Credenciais;
import view.MenuUser;

public class UserController {

    private final UserService userService = new UserService();
    private final MenuUser menuUser = new MenuUser();
    private final Util util = new Util();
    private Credenciais credenciais = new Credenciais();

    public void runUserController(Sessao sessaoInput) {
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
                    menuUser.showOptionTwoUser();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    userService.removerUser(credenciais);
                }

                case 3 -> {
                    menuUser.showOptionThreeUser();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    System.out.print("Digite o novo nome: ");
                    String novoNome = util.stringInput();

                    userService.alterarUserName(credenciais, novoNome);
                }

                case 4 -> {
                    menuUser.showOptionFourUser();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    System.out.print("Digite o novo email: ");
                    String novoEmail = util.stringInput();

                    userService.alterarEmailUser(credenciais, novoEmail);
                }

                case 5 -> {
                    run = false;
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }

        } while (run);
    }
}
