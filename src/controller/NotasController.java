package controller;

import model.Credenciais;
import service.NotasService;
import util.Util;
import sessao.Sessao;
import view.MenuNotas;

public class NotasController {

    private final MenuNotas menuNotas = new MenuNotas();
    private final NotasService notasService = new NotasService();
    private Credenciais credenciais = new Credenciais();
    private final Util util = new Util();

    public void runNotasController(Sessao sessaoInput) {
        boolean run = true;

        do {

            int option = menuNotas.inputOption();

            switch (option) {

                case 1 -> {
                    menuNotas.showOptionOneNotas();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    System.out.print("Escreva o titulo: ");
                    String title = util.stringInput();

                    System.out.print("Escreva o texto: ");
                    String text = util.stringInput();

                    notasService.criarNota(credenciais, title, text);
                }

                case 2 -> {
                    menuNotas.showOptionTwoNotas();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    System.out.print("Entre com o ID da nota: ");
                    int id = util.intInput();

                    notasService.excluirNota(credenciais, id);
                }

                case 3 -> {
                    menuNotas.showOptionThreeNotas();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    System.out.print("Entre com o ID da nota: ");
                    int idNota = util.intInput();

                    System.out.print("Entre com o novo texto: ");
                    String newText = util.stringInput();

                    notasService.alterarNota(credenciais, idNota, newText);
                }

                case 4 -> {
                    menuNotas.showOptionFourNotas();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    notasService.removerTodasNotas(credenciais);
                }

                case 5 -> {
                    menuNotas.showOptionFiveNotas();
                    credenciais = Credenciais.obterCredenciais(sessaoInput, util);

                    notasService.listarTodasNotas(credenciais);
                }

                case 6 -> {
                    run = false;
                }

                default -> {
                    System.out.println("Opção inválida");
                }
            }

        } while (run);
    }
}
