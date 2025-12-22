package dao;

import bd.BancoDeDadosNotas;
import model.Notas;
import model.User;

import java.util.Random;
import java.util.Scanner;

public class NotasDAO {
    public BancoDeDadosNotas bancoNotaDAO = new BancoDeDadosNotas();

    Scanner teclado = new Scanner(System.in);
    Random aletorio = new Random();


    public void criarNota(User usuarioInput, String title, String nota) {


        int id = aletorio.nextInt(1000);

        usuarioInput.bancoDeDadosNotasUser.notas
                .add(new Notas(title,nota,id));
    }

    public void excluirNota(User usuarioInput, int idDaNota) {
        for (int i = 0; i < usuarioInput.bancoDeDadosNotasUser.notas.size(); i++) {
            Notas nota = usuarioInput.bancoDeDadosNotasUser.notas.get(i);

            if (nota.getId() == idDaNota) {
                usuarioInput.bancoDeDadosNotasUser.notas.remove(i);
                break;
            }
        }
    }


    public void adicionarNota(User usuario, Notas notaInput) {
        usuario.bancoDeDadosNotasUser.notas.add(notaInput);
    }



    public void alterarNota(User usuarioInput, int idNotaInput,String newTexto) {


        for (int i = 0; i < usuarioInput.bancoDeDadosNotasUser.notas.size(); i++) {
            Notas nota = usuarioInput.bancoDeDadosNotasUser.notas.get(i);

            if (nota.getId() == idNotaInput) {

                usuarioInput.bancoDeDadosNotasUser.notas.get(i).setNota(newTexto);
                break;
            }
        }
    }


    public void alterarTitulo(User usuarioInput,int idNota) {


        for (int i = 0; i < usuarioInput.bancoDeDadosNotasUser.notas.size(); i++) {
            Notas nota = usuarioInput.bancoDeDadosNotasUser.notas.get(i);

            if (nota.getId() == idNota) {
                String newTitle = teclado.next();
                usuarioInput.bancoDeDadosNotasUser.notas.get(i).setTitle(newTitle);
                break;
            }
        }
    }




}
