package dao;

import bd.BancoDeDadosNotas;
import model.Notas;
import model.User;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class NotasDAO {

    private final BancoDeDadosNotas bancoNotaDAO = new BancoDeDadosNotas();
    private final AtomicInteger idGenerator = new AtomicInteger(1);

    public boolean criarNota(User usuario, String title, String texto) {


        Notas nota = new Notas(title,texto);

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

    public String allNotes(User usuario) {
        List<Notas> notas = usuario.bancoDeDadosNotasUser.getNotas();

        if (notas.isEmpty()) {
            return "Nenhuma nota cadastrada.";
        }

        StringBuilder retorno = new StringBuilder();
        retorno.append("===== TODAS AS NOTAS =====\n");

        for (Notas nota : notas) {
            retorno.append("ID: ").append(nota.getId()).append("\n")
                    .append("Título: ").append(nota.getTitle()).append("\n")
                    .append("Texto:\n").append(nota.getNota()).append("\n")
                    .append("-------------------------\n");
        }

        return retorno.toString();
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