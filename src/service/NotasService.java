package service;

import dao.NotasDAO;
import dao.UserDAO;
import model.Notas;
import model.User;
import util.Util;

import java.util.List;

public class NotasService {

    private final NotasDAO notasDao = new NotasDAO();
    private final UserDAO userDao = new UserDAO();
    private final Util util = new Util();

    private User autenticar(String userName, int senhaUser) {
        User user = userDao.retornaUser(userName, senhaUser);
        return util.userIsValid(user) ? user : null;
    }

    public boolean criarNota(String userName, int senhaUser, String title, String text) {
        User user = autenticar(userName, senhaUser);
        if (user == null) return false;

        Notas nota = new Notas(title, text);
        if (!util.notaIsValid(nota)) return false;

        return notasDao.criarNota(user, title, text);
    }

    public boolean excluirNota(String userName, int senhaUser, int idNota) {
        User user = autenticar(userName, senhaUser);
        if (user == null || idNota <= 0) return false;

        return notasDao.excluirNota(user, idNota);
    }

    public boolean alterarNota(String userName, int senhaUser, int idNota, String newText) {
        User user = autenticar(userName, senhaUser);
        if (user == null || idNota <= 0 || newText == null || newText.isBlank()) {
            return false;
        }

        return notasDao.alterarNota(user, idNota, newText);
    }

    public boolean alterarTitulo(String userName, int senhaUser, int idNota, String newTitle) {
        User user = autenticar(userName, senhaUser);
        if (user == null || idNota <= 0 || newTitle == null || newTitle.isBlank()) {
            return false;
        }

        return notasDao.alterarTitulo(user, idNota, newTitle);
    }

    public boolean removerTodasNotas(String userName, int senhaUser) {
        User user = autenticar(userName, senhaUser);
        if (user == null) return false;

        return notasDao.removerTodasNotas(user);
    }

    public String listarTodasNotas(String userName, int senhaUser) {
        User user = autenticar(userName, senhaUser);
        if (user == null) return null;

        List<Notas> notas = user.bancoDeDadosNotasUser.getNotas();
        if (notas.isEmpty()) return null;

        StringBuilder retorno = new StringBuilder();
        retorno.append("===== TODAS AS NOTAS =====\n\n");

        for (Notas nota : notas) {
            retorno.append("ID: ").append(nota.getId()).append("\n")
                    .append("Título: ").append(nota.getTitle()).append("\n")
                    .append("Texto:\n")
                    .append(nota.getNota()).append("\n\n")
                    .append("-------------------------\n\n");
        }

        return retorno.toString();
    }

}
