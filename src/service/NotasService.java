package service;

import dao.NotasDAO;
import dao.UserDAO;
import model.Notas;
import model.User;
import model.Credenciais;
import util.Util;

import java.util.List;

public class NotasService {

    private final NotasDAO notasDao = new NotasDAO();
    private final UserDAO userDao = new UserDAO();
    private final Util util = new Util();

    private User autenticar(Credenciais credenciais) {
        User user = userDao.retornaUser(
                credenciais.getNome(),
                credenciais.getSenha()
        );
        return util.userIsValid(user) ? user : null;
    }

    public boolean criarNota(Credenciais credenciais, String title, String text) {
        User user = autenticar(credenciais);
        if (user == null) return false;

        Notas nota = new Notas(title, text);
        if (!util.notaIsValid(nota)) return false;

        return notasDao.criarNota(user, title, text);
    }

    public boolean excluirNota(Credenciais credenciais, int idNota) {
        User user = autenticar(credenciais);
        if (user == null || idNota <= 0) return false;

        return notasDao.excluirNota(user, idNota);
    }

    public boolean alterarNota(Credenciais credenciais, int idNota, String newText) {
        User user = autenticar(credenciais);
        if (user == null || idNota <= 0 || newText == null || newText.isBlank()) {
            return false;
        }
        return notasDao.alterarNota(user, idNota, newText);
    }


    public boolean removerTodasNotas(Credenciais credenciais) {
        User user = autenticar(credenciais);
        if (user == null) return false;

        return notasDao.removerTodasNotas(user);
    }

    public List<Notas> listarTodasNotas(Credenciais credenciais) {
        User user = autenticar(credenciais);
        if (user == null) return null;

        List<Notas> notas = user.bancoDeDadosNotasUser.getNotas();
        return notas.isEmpty() ? null : notas;
    }
}
