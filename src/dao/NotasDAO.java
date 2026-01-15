package dao;

import bd.BancoDeDadosNotas;
import model.Notas;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class NotasDAO {

    private final Random random = new Random();

    public boolean criarNota(User usuario, String title, String texto) {


        Notas nota = new Notas(title,texto);
        nota.setId(random.nextInt(1000000));

        boolean adicionou = usuario.bancoDeDadosNotasUser.getNotas().add(nota);

        if (adicionou) {
            usuario.bancoDeDadosNotasUser.indice++;
        }

        return adicionou;
    }

    public boolean excluirNota(User usuario, int idNota) {
        Notas nota = buscarNotas(usuario, idNota);
        if (nota == null) return false;

        boolean removeu = usuario.bancoDeDadosNotasUser.getNotas().remove(nota);

        if (removeu) {
            usuario.bancoDeDadosNotasUser.setIndice(usuario.bancoDeDadosNotasUser.getIndice() - 1);
        }

        return removeu;
    }

    public boolean alterarNota(User usuario, int idNota, String novoTexto) {
        Notas nota = buscarNotas(usuario, idNota);
        if (nota == null) return false;

        nota.setNota(novoTexto);
        return true;
    }

    public boolean alterarTitulo(User usuario, int idNota, String novoTitulo) {
        Notas nota = buscarNotas(usuario, idNota);
        if (nota == null) return false;

        nota.setTitle(novoTitulo);
        return true;
    }

    public boolean removerTodasNotas(User usuario) {
        usuario.bancoDeDadosNotasUser.getNotas().clear();
        usuario.bancoDeDadosNotasUser.setIndice(0);
        return true;
    }

    public ArrayList<Notas> allNotes(User usuario) {

       return usuario.bancoDeDadosNotasUser.getNotas();
    }

    public Notas buscarNotas(User usuario, int idNota) {
        for (Notas nota : usuario.bancoDeDadosNotasUser.getNotas()) {
            if (nota.getId() == idNota) {
                return nota;
            }
        }
        return null;
    }
}