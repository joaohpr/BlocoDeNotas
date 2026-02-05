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

}
