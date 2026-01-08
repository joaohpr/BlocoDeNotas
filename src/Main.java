import service.UserService;
import java.util.Scanner;
    public class Main {
        public static void main(String[] args) throws InterruptedException {

            UserService userService = new UserService();

            Scanner sc = new Scanner(System.in);

            int optionMain;
            String menuMain = "1)Usuario\n2)Notas\n3)Sair\n";
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
                    "6 - Voltar / Sair\n" +
                    "======================\n";


            do {
                System.out.println(menuMain);

                System.out.print("Entre com o dígito da opção : ");
                optionMain = sc.nextInt();

                switch (optionMain) {
                    case 1 -> {

                        System.out.println(menuUser);
                        int optionUser = sc.nextInt();


                        do {
                            switch (optionUser) {

                                case 1 -> {
                                    System.out.println("==== CRIANDO USUARIO ====");

                                    System.out.print("Entre com seu nome : ");
                                    String nome = sc.next();

                                    System.out.print("\nEntre com seu email : ");
                                    String email = sc.next();

                                    System.out.print("\nEntre com uma senha de 6 digitos : ");
                                    int senha = sc.nextInt();

                                    userService.criarUser(nome, email, senha);
                                    break;

                                }

                                case 2 -> {
                                    System.out.println("==== REMOVENDO USUARIO ====");

                                    System.out.print("Informe seu nome : ");
                                    String nomeRemove = sc.next();

                                    System.out.print("\nEntre com seu email : ");
                                    String emailRemove = sc.next();

                                    System.out.print("\nEntre com sua senha : ");
                                    int senhaRemove = sc.nextInt();

                                    userService.removerUser(nomeRemove, senhaRemove);
                                    break;

                                }

                                case 3 -> {
                                    System.out.println("==== ALTERAR NOME ====");

                                    System.out.print("Entre com seu nome atual : ");
                                    String nomeNow = sc.next();

                                    System.out.print("\nEntre com o nome que vai substituir o atual : ");
                                    String nomeSet = sc.next();

                                    System.out.print("\n Entre com seu email : ");
                                    String email = sc.next();

                                    System.out.print("\nConfirme sua senha para alterar : ");
                                    int senha = sc.nextInt();

                                    userService.mudarNome(nomeNow, nomeSet, senha);
                                    break;

                                }

                                case 4 -> {
                                    System.out.println("==== ALTERAR EMAIL ====");

                                    System.out.print("Entre com seu nome :");
                                    String nome = sc.next();

                                    System.out.print("\n Confirme sua senha :");
                                    int senha = sc.nextInt();

                                    System.out.print("\nEntre com o email que ira substituir o atual :");
                                    String emailSet = sc.next();

                                    userService.mudarEmail(nome, senha, emailSet);
                                    break;

                                }

                                case 5 -> {
                                    System.out.print("Saindo");
                                    String point = ".";
                                    for (int i = 0; i < 3; i++) {
                                        Thread.sleep(1000);
                                        System.out.print(point);
                                    }
                                    System.out.println("");

                                    break;
                                }

                                default -> {
                                    System.out.println("Opção inválida!");
                                }

                            }

                        } while (optionUser != 5);


                    }


                    case 2 -> {

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