package dao;

import model.Notas;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NotasDAO {

    private final Random random = new Random();

    public void criarNota(User usuario, String titulo, String texto) {

        if (usuario == null) return;

        Notas nota = new Notas(titulo, texto);
        nota.setId(random.nextInt(1_000_000));

        usuario.bancoDeDadosNotasUser.getNotas().add(nota);
        usuario.bancoDeDadosNotasUser.setIndice(
                usuario.bancoDeDadosNotasUser.getIndice() + 1
        );
    }

    public boolean excluirNota(User usuario, int idNota) {

        Notas nota = buscarNota(usuario, idNota);
        if (nota == null) return false;

        boolean removeu = usuario.bancoDeDadosNotasUser.getNotas().remove(nota);

        if (removeu) {
            usuario.bancoDeDadosNotasUser.setIndice(
                    usuario.bancoDeDadosNotasUser.getIndice() - 1
            );
        }

        return removeu;
    }

    public boolean alterarTexto(User usuario, int idNota, String novoTexto) {

        Notas nota = buscarNota(usuario, idNota);
        if (nota == null) return false;

        nota.setNota(novoTexto);
        return true;
    }

    public boolean alterarTitulo(User usuario, int idNota, String novoTitulo) {

        Notas nota = buscarNota(usuario, idNota);
        if (nota == null) return false;

        nota.setTitle(novoTitulo);
        return true;
    }

    public void removerTodas(User usuario) {

        usuario.bancoDeDadosNotasUser.getNotas().clear();
        usuario.bancoDeDadosNotasUser.setIndice(0);
    }

    public List<Notas> listarNotas(User usuario) {

        return new ArrayList<>(usuario.bancoDeDadosNotasUser.getNotas());
    }

    private Notas buscarNota(User usuario, int idNota) {

        for (Notas nota : usuario.bancoDeDadosNotasUser.getNotas()) {
            if (nota.getId() == idNota) {
                return nota;
            }
        }
        return null;
    }
}
