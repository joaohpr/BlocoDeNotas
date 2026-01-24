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

    private boolean usuarioValido(User user) {
        return util.userIsValid(user);
    }

    public boolean criarNota(User user, String title, String text) {
        if (!usuarioValido(user)) return false;

        Notas nota = new Notas(title, text);
        if (!util.notaIsValid(nota)) return false;

        return notasDao.criarNota(user, title, text);
    }

    public boolean criarNota(String userName, int senhaUser, String title, String text) {
        User user = autenticar(userName, senhaUser);
        return criarNota(user, title, text);
    }

    public boolean excluirNota(User user, int idNota) {
        if (!usuarioValido(user) || idNota <= 0) return false;
        return notasDao.excluirNota(user, idNota);
    }

    public boolean excluirNota(String userName, int senhaUser, int idNota) {
        User user = autenticar(userName, senhaUser);
        return excluirNota(user, idNota);
    }

    public boolean alterarNota(User user, int idNota, String newText) {
        if (!usuarioValido(user) || idNota <= 0 || newText == null || newText.isBlank()) {
            return false;
        }
        return notasDao.alterarNota(user, idNota, newText);
    }

    public boolean alterarNota(String userName, int senhaUser, int idNota, String newText) {
        User user = autenticar(userName, senhaUser);
        return alterarNota(user, idNota, newText);
    }

    public boolean alterarTitulo(User user, int idNota, String newTitle) {
        if (!usuarioValido(user) || idNota <= 0 || newTitle == null || newTitle.isBlank()) {
            return false;
        }
        return notasDao.alterarTitulo(user, idNota, newTitle);
    }

    public boolean alterarTitulo(String userName, int senhaUser, int idNota, String newTitle) {
        User user = autenticar(userName, senhaUser);
        return alterarTitulo(user, idNota, newTitle);
    }

    public boolean removerTodasNotas(User user) {
        if (!usuarioValido(user)) return false;
        return notasDao.removerTodasNotas(user);
    }

    public boolean removerTodasNotas(String userName, int senhaUser) {
        User user = autenticar(userName, senhaUser);
        return removerTodasNotas(user);
    }

    public List<Notas> listarTodasNotas(User user) {
        if (!usuarioValido(user)) return null;

        List<Notas> notas = user.bancoDeDadosNotasUser.getNotas();
        return notas.isEmpty() ? null : notas;
    }

    public List<Notas> listarTodasNotas(String userName, int senhaUser) {
        User user = autenticar(userName, senhaUser);
        return listarTodasNotas(user);
    }
}
