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


        int id = aletorio.nextInt(100000);

        usuarioInput.bancoDeDadosNotasUser.notas
                .add(new Notas(title,nota));
        usuarioInput.bancoDeDadosNotasUser.setIndice(bancoNotaDAO.getIndice()+1);    }

    public void excluirNota(User usuarioInput, int idDaNota) {
        for (int i = 0; i < usuarioInput.bancoDeDadosNotasUser.notas.size(); i++) {
            Notas nota = usuarioInput.bancoDeDadosNotasUser.notas.get(i);

            if (nota.getId() == idDaNota) {
                usuarioInput.bancoDeDadosNotasUser.notas.remove(i);
                break;
            }
        }
        usuarioInput.bancoDeDadosNotasUser.setIndice(bancoNotaDAO.getIndice() - 1);
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


    public void removerTodasNotas(User usuario){
       for(int i = 0;i < usuario.bancoDeDadosNotasUser.getIndice();i++) {

           usuario.bancoDeDadosNotasUser.notas.add(i, null);
       }
    }

    public String allNotes(User usuario) {

        StringBuilder retorno = new StringBuilder();

        retorno.append("===== TODAS AS NOTAS =====\n");

        // for-each para percorrer as notas
        for (Notas nota : usuario.bancoDeDadosNotasUser.notas) {

            retorno.append("Título: ")
                    .append(nota.getTitle())
                    .append("\n");

            retorno.append("Texto:\n")
                    .append(nota.getNota())
                    .append("\n");

            retorno.append(" Id : ")
                    .append(nota.getId())
                    .append("\n");

            retorno.append("-------------------------\n");
        }

        return retorno.toString();
    }

    public Notas buscarNotas(User userInput,int idNota){

        Notas retorno;

        for(int i = 0;i < userInput.bancoDeDadosNotasUser.notas.size();i++){

            Notas notaAux = userInput.bancoDeDadosNotasUser.notas.get(i);

            if(notaAux.getId() == idNota){
               retorno = notaAux;
               return retorno;
            }
        }
        return null;
    }



}





