import model.Notas;
import service.NotasService;

import service.UserService;
import util.Util;

import java.util.List;
import java.util.Scanner;


public class Main {

        public static void main(String[] args) throws InterruptedException {

            final UserService userService = new UserService();
            final NotasService notasService = new NotasService();
            final Util util = new Util();
            final Scanner sc =  new Scanner(System.in);


            int optionMain;
            String menuMain = "\n1)Usuario\n2)Notas\n3)Sair\n";

            String menuUser = "\n===== MENU USUÁRIO =====\n" +
                    "1 - Criar usuário\n" +
                    "2 - Remover usuário\n" +
                    "3 - Alterar nome do usuário\n" +
                    "4 - Alterar email do usuário\n" +
                    "5 - Sair\n" +
                    "========================\n";

            String menuNotes = "\n===== MENU NOTAS =====\n" +
                    "1 - Criar nota\n" +
                    "2 - Excluir nota por ID\n" +
                    "3 - Alterar texto da nota\n" +
                    "4 - Remover todas as notas do usuário\n" +
                    "5 - Listar todas as notas do usuário\n" +
                    "6 - Sair\n" +
                    "======================\n";


            do {
                System.out.println(menuMain);

                System.out.print("Entre com o dígito da opção : ");
                optionMain = util.leInteiro();

                switch (optionMain) {
                    case 1 -> {

                        System.out.println(menuUser);
                        System.out.print("Entre com o digito da opcao : ");
                        int optionUser = util.leInteiro();


                        do {
                            switch (optionUser) {

                                case 1 -> {
                                    System.out.println("==== CRIANDO USUARIO ====");

                                    System.out.print("Entre com seu nome : ");
                                    String nome = sc.next();

                                    System.out.print("\nEntre com seu email : ");
                                    String email = util.leString();

                                    System.out.print("\nEntre com uma senha de 6 digitos : ");
                                    int senha = util.leInteiro();

                                    if(userService.criarUser(nome, email, senha)){
                                        System.out.println("Usuario criado com sucesso!");
                                    }else{
                                        System.out.println("Não foi possivel criar o usuario!");
                                    }
                                    optionUser = 5;
                                }

                                case 2 -> {
                                    System.out.println("==== REMOVENDO USUARIO ====");

                                    System.out.print("Informe seu nome : ");
                                    String nomeRemove = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senhaRemove = util.leInteiro();

                                    if(userService.removerUser(nomeRemove, senhaRemove)){
                                        System.out.println("O usuario foi removido!");
                                    }else{
                                        System.out.println("Não foi possivel remover o usuario!");
                                    }
                                    optionUser = 5;


                                }

                                case 3 -> {
                                    System.out.println("==== ALTERAR NOME ====");

                                    System.out.print("Entre com seu nome atual : ");
                                    String nomeNow = util.leString();

                                    System.out.print("\nEntre com o nome que vai substituir o atual : ");
                                    String nomeSet = util.leString();

                                    System.out.print("\n Entre com seu email : ");
                                    String email = util.leString();

                                    System.out.print("\nConfirme sua senha para alterar : ");
                                    int senha = util.leInteiro();

                                    if(userService.mudarNome(nomeNow, nomeSet, senha)){
                                        System.out.println("Seu nome foi alterado com sucesso!");
                                    }else{
                                        System.out.println("Não foi possivel alterar o seu nome!");
                                    }
                                    optionUser = 5;

                                }

                                case 4 -> {
                                    System.out.println("==== ALTERAR EMAIL ====");

                                    System.out.print("Entre com seu nome :");
                                    String nome = util.leString();

                                    System.out.print("\n Confirme sua senha :");
                                    int senha = util.leInteiro();

                                    System.out.print("\nEntre com o email que ira substituir o atual :");
                                    String emailSet = util.leString();

                                    if(userService.mudarEmail(nome, senha, emailSet)){
                                        System.out.println("Email alterado com sucesso!");
                                    }else{
                                        System.out.println("Não foi possivel alterar o email!");
                                    }
                                    optionUser = 5;


                                }

                                case 5 -> {
                                    System.out.print("Saindo");
                                    String point = ".";
                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(1000);
                                        System.out.print(point);
                                    }
                                    System.out.println("");

                                    optionUser = 5;

                                }

                                default -> {
                                    System.out.println("Opção inválida!");
                                }

                            }

                        } while (optionUser != 5);

                    }


                    case 2 -> {


                        System.out.println(menuNotes);
                        System.out.println("Entre com o digito da opcao :");
                        int optionNote = util.leInteiro();

                        do{

                            switch (optionNote){

                                case 1 ->{
                                    System.out.println("==== CRIAR NOTA ====");

                                    System.out.print("Entre com seu nome : ");
                                    String nome = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senha = util.leInteiro();

                                    System.out.print("\nEntre com o Titulo da nota : ");
                                    String title = util.leString();

                                    System.out.print("\nEscreva o texto : ");
                                    String text = util.leString();
                                    if(notasService.criarNota(nome,senha,title,text)) {
                                        System.out.println("Nota criada com sucesso!");

                                    } else {
                                        System.out.println("ERRO!Não foi possivel criar a nota!");
                                    }
                                    optionNote = 6;

                                }


                                case 2 ->{
                                    System.out.println("==== EXCLUIR NOTA ====");

                                    System.out.print("\nEntre com seu nome : ");
                                    String nome = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senha = util.leInteiro();

                                    System.out.print("\nID da nota : ");
                                    int idNota = util.leInteiro();

                                    if(notasService.excluirNota(nome,senha,idNota)){
                                        System.out.println("Nota excluida com sucesso!");
                                    } else {
                                        System.out.println("ERRO!Não foi possivel excluir a nota!");
                                    }
                                    optionNote = 6;

                                }


                                case 3 ->{
                                    System.out.println("==== ALTERAR TEXTO DA NOTA ====");

                                    System.out.print("\nEntre com seu nome :");
                                    String nome = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senha = util.leInteiro();

                                    System.out.print("\nID da nota : ");
                                    int idNota = util.leInteiro();

                                    System.out.print("\nEscreva o novo texto : ");
                                    String newText = util.leString();

                                    if(notasService.alterarNota(nome,senha,idNota,newText)){
                                        System.out.println("A nota foi alterada!");
                                    } else {
                                        System.out.println("ERRO!Não foi possivel alterar o texto!");
                                    }
                                    optionNote = 6;

                                }


                                case 4 ->{
                                    System.out.println("==== REMOVER TODAS AS NOTAS ====");

                                    System.out.print("\nEntre com seu nome : ");
                                    String nome = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senha = util.leInteiro();

                                    if(notasService.removerTodasNotas(nome,senha)){

                                        System.out.println("Todas as notas foram excluidas");
                                    } else {
                                        System.out.println("ERRO!Não foi possivel excluir a notas!");
                                    }
                                    optionNote = 6;

                                }


                                case 5 ->{
                                    System.out.println("==== LISTAR TODAS AS NOTAS ====");

                                    System.out.print("Entre com seu nome : ");
                                    String nome = util.leString();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senha = util.leInteiro();

                                    if(notasService.listarTodasNotas(nome,senha) != null){
                                        System.out.println("Essas sao todas as notas !");

                                        List<Notas> notas =  notasService.listarTodasNotas(nome,senha);

                                        StringBuilder retorno = new StringBuilder();
                                        retorno.append("===== TODAS AS NOTAS =====\n\n");

                                        for (Notas nota : notas) {
                                            retorno.append("ID: ").append(nota.getId()).append("\n")
                                                    .append("Título: ").append(nota.getTitle()).append("\n")
                                                    .append("Texto:\n")
                                                    .append(nota.getNota()).append("\n\n")
                                                    .append("-------------------------\n\n");
                                        }

                                        System.out.println(retorno.toString());

                                    } else {
                                        System.out.println("Você não tem nenhuma nota criada!" );
                                    }
                                    optionNote = 6;

                                }


                                case 6 ->{
                                    System.out.print("Saindo");
                                    String point = ".";
                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(1000);
                                        System.out.print(point);
                                    }
                                    System.out.println("");
                                    optionNote = 6;

                                }

                                default -> {
                                    System.out.println("Opção inválida!");
                                }

                            }

                        }while(optionNote != 6);

                    }


                    case 3 -> {
                        System.out.print("Saindo");
                        String point = ".";
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(1000);
                            System.out.print(point);
                        }
                        System.out.println("");

                    }

                    default ->{
                        System.out.println("Opção inválida!");
                    }

                }

            }while (optionMain != 3) ;

        }

    }