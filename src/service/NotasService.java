package service;

import dao.NotasDAO;
import model.Notas;
import model.User;
import sessao.Sessao;

import java.util.List;

public class NotasService {

    private final NotasDAO notasDao = new NotasDAO();

    public void criarNota(Sessao sessao, String titulo, String texto) {

        if (!sessao.estaLogado()) {
            System.out.println("Usuário não está logado.");
            return;
        }

        if (titulo == null || titulo.isBlank() ||
                texto == null || texto.isBlank()) {
            System.out.println("Dados da nota inválidos.");
            return;
        }

        User user = sessao.getUser();
        notasDao.criarNota(user, titulo, texto);

        System.out.println("Nota criada com sucesso.");
    }

    public void excluirNota(Sessao sessao, int idNota) {

        if (!sessao.estaLogado()) {
            System.out.println("Usuário não está logado.");
            return;
        }

        if (idNota <= 0) {
            System.out.println("ID inválido.");
            return;
        }

        User user = sessao.getUser();
        boolean removida = notasDao.excluirNota(user, idNota);

        if (!removida) {
            System.out.println("Nota não encontrada.");
            return;
        }

        System.out.println("Nota removida com sucesso.");
    }

    public void alterarNota(Sessao sessao, int idNota, String novoTexto) {

        if (!sessao.estaLogado()) {
            System.out.println("Usuário não está logado.");
            return;
        }

        if (idNota <= 0 || novoTexto == null || novoTexto.isBlank()) {
            System.out.println("Dados inválidos.");
            return;
        }

        User user = sessao.getUser();
        boolean alterada = notasDao.alterarTexto(user, idNota, novoTexto);

        if (!alterada) {
            System.out.println("Nota não encontrada.");
            return;
        }

        System.out.println("Nota alterada com sucesso.");
    }

    public void removerTodasNotas(Sessao sessao) {

        if (!sessao.estaLogado()) {
            System.out.println("Usuário não está logado.");
            return;
        }

        User user = sessao.getUser();
        notasDao.removerTodas(user);

        System.out.println("Todas as notas foram removidas.");
    }

    public void listarTodasNotas(Sessao sessao) {

        if (!sessao.estaLogado()) {
            System.out.println("Usuário não está logado.");
            return;
        }

        User user = sessao.getUser();
        List<Notas> notas = notasDao.listarNotas(user);

        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota encontrada.");
            return;
        }

        for (Notas nota : notas) {
            System.out.println(nota);
        }
    }
}
