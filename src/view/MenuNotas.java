package view;

import util.Util;

public class MenuNotas {

    Util util = new Util();

    public static String showMenuNotas(){
        return  "\n===== MENU NOTAS =====\n" +
                "1 - Criar nota\n" +
                "2 - Excluir nota\n" +
                "3 - Alterar texto\n" +
                "4 - Remover todas\n" +
                "5 - Listar notas\n" +
                "6 - Voltar\n";
    }


    public int inputOption() {
        showMenuNotas();

        int outOption = util.intInput();

        return outOption;
    }


    public void showOptionOneNotas() {
        System.out.println("==== CRIAR NOTA ====");
    }

    public void showOptionTwoNotas() {
        System.out.println("==== EXCLUIR NOTA ====");
    }

    public void showOptionThreeNotas() {
        System.out.println("==== ALTERAR TEXTO ====");
    }

    public void showOptionFourNotas() {
        System.out.println("==== REMOVER TODAS AS NOTAS ====");
    }

    public void showOptionFiveNotas() {
        System.out.println("==== LISTAR NOTAS ====");
    }

    public void showOptionSixNotas() {
        System.out.println("==== VOLTAR ====");
    }


}
