package controller;

import controller.LoginController;
import model.Credenciais;
import service.NotasService;
import util.Util;
import sessao.Sessao;
import view.MenuNotas;

public class NotasController {

    MenuNotas menuNotas = new MenuNotas();
    NotasService notasService = new NotasService();
    Credenciais credenciais = new Credenciais();
    Util util = new Util();


    public void runNotasController(Sessao sessaoInput) {
        boolean run = true;

        do{

            int option = menuNotas.inputOption();

            switch(option) {
                case 1 -> {
                    menuNotas.showOptionOneNotas();
                    credenciais = credenciais.obterCredenciais(sessaoInput,util);
                    if(sessaoInput.getUser() != null) {

                    }


                }
                default -> throw new IllegalStateException("Unexpected value: " + option);
            }



        }while(run);
    }





}
