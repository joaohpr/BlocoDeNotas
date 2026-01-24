import Sessao.Sessao;
import model.Notas;
import service.NotasService;
import service.UserService;
import util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final UserService userService = new UserService();
        final NotasService notasService = new NotasService();
        final Util util = new Util();
        final Sessao sessao = new Sessao();

        int optionMain;

        String menuMain =
                "\n===== MENU PRINCIPAL =====\n" +
                        "1) Usuário\n" +
                        "2) Notas\n" +
                        "3) Login / Logout\n" +
                        "4) Sair\n";

        String menuUser =
                "\n===== MENU USUÁRIO =====\n" +
                        "1 - Criar usuário\n" +
                        "2 - Remover usuário\n" +
                        "3 - Alterar nome\n" +
                        "4 - Alterar email\n" +
                        "5 - Voltar\n";

        String menuNotes =
                "\n===== MENU NOTAS =====\n" +
                        "1 - Criar nota\n" +
                        "2 - Excluir nota\n" +
                        "3 - Alterar texto\n" +
                        "4 - Remover todas\n" +
                        "5 - Listar notas\n" +
                        "6 - Voltar\n";

        do {
            System.out.println(menuMain);
            optionMain = util.intInput();

            switch (optionMain) {

                case 3 -> {
                    System.out.print("1) Login\n2) Logout\n");
                    int opLogin = util.intInput();

                    switch (opLogin) {
                        case 1 -> {
                            if (sessao.estaLogado()) {
                                System.out.println("Já existe um usuário logado.");
                                break;
                            }

                            System.out.print("Nome: ");
                            String nome = util.stringInput();

                            System.out.print("Senha (6 dígitos): ");
                            int senha = util.intInput();

                            if (sessao.login(nome, senha)) {
                                System.out.println("Login realizado com sucesso.");
                            } else {
                                System.out.println("Nome ou senha inválidos.");
                            }
                        }

                        case 2 -> {
                            sessao.logOut();
                            System.out.println("Logout realizado.");
                        }

                        default -> System.out.println("Opção inválida.");
                    }
                }

                case 1 -> {
                    System.out.println(menuUser);
                    int optionUser = util.intInput();

                    do {
                        switch (optionUser) {

                            case 1 -> {
                                System.out.print("Nome: ");
                                String nome = util.stringInput();

                                System.out.print("Email: ");
                                String email = util.stringInput();

                                System.out.print("Senha (6 dígitos): ");
                                int senha = util.intInput();

                                if (userService.criarUser(nome, email, senha)) {
                                    System.out.println("Usuário criado com sucesso.");
                                } else {
                                    System.out.println("Erro ao criar usuário.");
                                }
                                optionUser = 5;
                            }

                            case 2 -> {
                                String nome;
                                int senha;

                                if (sessao.estaLogado()) {
                                    nome = sessao.getNomeUsuario();
                                    senha = sessao.getSenhaUsuario();
                                } else {
                                    System.out.print("Nome: ");
                                    nome = util.stringInput();

                                    System.out.print("Senha: ");
                                    senha = util.intInput();
                                }

                                if (userService.removerUser(nome, senha)) {
                                    System.out.println("Usuário removido.");
                                    sessao.logOut();
                                } else {
                                    System.out.println("Erro ao remover usuário.");
                                }
                                optionUser = 5;
                            }

                            case 3 -> {
                                String nome;
                                int senha;

                                if (sessao.estaLogado()) {
                                    nome = sessao.getNomeUsuario();
                                    senha = sessao.getSenhaUsuario();
                                } else {
                                    System.out.print("Nome atual: ");
                                    nome = util.stringInput();

                                    System.out.print("Senha: ");
                                    senha = util.intInput();
                                }

                                System.out.print("Novo nome: ");
                                String novoNome = util.stringInput();

                                if (userService.mudarNome(nome, novoNome, senha)) {
                                    System.out.println("Nome alterado.");
                                } else {
                                    System.out.println("Erro ao alterar nome.");
                                }
                                optionUser = 5;
                            }

                            case 4 -> {
                                String nome;
                                int senha;

                                if (sessao.estaLogado()) {
                                    nome = sessao.getNomeUsuario();
                                    senha = sessao.getSenhaUsuario();
                                } else {
                                    System.out.print("Nome: ");
                                    nome = util.stringInput();

                                    System.out.print("Senha: ");
                                    senha = util.intInput();
                                }

                                System.out.print("Novo email: ");
                                String email = util.stringInput();

                                if (userService.mudarEmail(nome, senha, email)) {
                                    System.out.println("Email alterado.");
                                } else {
                                    System.out.println("Erro ao alterar email.");
                                }
                                optionUser = 5;
                            }

                            case 5 -> optionUser = 5;

                            default -> {
                                System.out.println("Opção inválida.");
                                optionUser = 5;
                            }
                        }
                    } while (optionUser != 5);
                }

                case 2 -> {
                    System.out.println(menuNotes);
                    int optionNote = util.intInput();

                    do {
                        switch (optionNote) {

                            case 1 -> {
                                String nome;
                                int senha;

                                if (sessao.estaLogado()) {
                                    nome = sessao.getNomeUsuario();
                                    senha = sessao.getSenhaUsuario();
                                } else {
                                    System.out.print("Nome: ");
                                    nome = util.stringInput();

                                    System.out.print("Senha: ");
                                    senha = util.intInput();
                                }

                                System.out.print("Título: ");
                                String titulo = util.stringInput();

                                System.out.print("Texto: ");
                                String texto = util.stringInput();

                                if (notasService.criarNota(nome, senha, titulo, texto)) {
                                    System.out.println("Nota criada.");
                                } else {
                                    System.out.println("Erro ao criar nota.");
                                }
                                optionNote = 6;
                            }

                            case 5 -> {
                                String nome;
                                int senha;

                                if (sessao.estaLogado()) {
                                    nome = sessao.getNomeUsuario();
                                    senha = sessao.getSenhaUsuario();
                                } else {
                                    System.out.print("Nome: ");
                                    nome = util.stringInput();

                                    System.out.print("Senha: ");
                                    senha = util.intInput();
                                }

                                List<Notas> notas = notasService.listarTodasNotas(nome, senha);

                                if (notas == null || notas.isEmpty()) {
                                    System.out.println("Nenhuma nota encontrada.");
                                } else {
                                    for (Notas n : notas) {
                                        System.out.println(
                                                "\nID: " + n.getId() +
                                                        "\nTítulo: " + n.getTitle() +
                                                        "\nTexto:\n" + n.getNota()
                                        );
                                    }
                                }
                                optionNote = 6;
                            }

                            case 6 -> optionNote = 6;

                            default -> {
                                System.out.println("Opção inválida.");
                                optionNote = 6;
                            }
                        }
                    } while (optionNote != 6);
                }

                case 4 -> System.out.println("Encerrando sistema...");

                default -> System.out.println("Opção inválida.");
            }

        } while (optionMain != 4);
    }
}
