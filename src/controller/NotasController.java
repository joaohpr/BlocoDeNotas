package controller;

import service.NotasService;
import sessao.Sessao;
import util.Util;
import view.MenuNotas;

public class NotasController {

    private final MenuNotas menuNotas = new MenuNotas();
    private final NotasService notasService = new NotasService();
    private final Util util = new Util();

    public void runNotasController(Sessao sessao) {

        if (!sessao.estaLogado()) {
            System.out.println("É necessário estar logado para acessar as notas.");
            return;
        }

        boolean run = true;

        do {
            int option = menuNotas.inputOption();

            switch (option) {

                case 1 -> {
                    menuNotas.showOptionOneNotas();

                    System.out.print("Escreva o título: ");
                    String title = util.stringInput();

                    System.out.print("Escreva o texto: ");
                    String text = util.stringInput();

                    notasService.criarNota(sessao, title, text);
                }

                case 2 -> {
                    menuNotas.showOptionTwoNotas();

                    System.out.print("Entre com o ID da nota: ");
                    int id = util.intInput();

                    notasService.excluirNota(sessao, id);
                }

                case 3 -> {
                    menuNotas.showOptionThreeNotas();

                    System.out.print("Entre com o ID da nota: ");
                    int idNota = util.intInput();

                    System.out.print("Entre com o novo texto: ");
                    String newText = util.stringInput();

                    notasService.alterarNota(sessao, idNota, newText);
                }

                case 4 -> {
                    menuNotas.showOptionFourNotas();
                    notasService.removerTodasNotas(sessao);
                }

                case 5 -> {
                    menuNotas.showOptionFiveNotas();
                    notasService.listarTodasNotas(sessao);
                }

                case 6 -> run = false;

                default -> System.out.println("Opção inválida");
            }

        } while (run);
    }
}
