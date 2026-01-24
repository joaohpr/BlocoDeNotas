package service;

import dao.UserDAO;
import model.User;
import util.Util;

public class UserService {

    private final UserDAO userDao = new UserDAO();
    private final Util util = new Util();

    private User autenticar(String userName, int senha) {
        User user = userDao.retornaUser(userName, senha);
        return util.userIsValid(user) ? user : null;
    }

    private boolean usuarioValido(User user) {
        return util.userIsValid(user);
    }

    public boolean criarUser(String userName, String emailUser, int senhaUser) {
        User user = new User(userName, emailUser, senhaUser);
        if (!usuarioValido(user)) return false;
        return userDao.criarUser(user);
    }

    public boolean removerUser(User user) {
        if (!usuarioValido(user)) return false;
        return userDao.removerUsuario(user);
    }

    public boolean removerUser(String userName, int senha) {
        User user = autenticar(userName, senha);
        return removerUser(user);
    }

    public boolean mudarNome(User user, String novoNome) {
        if (!usuarioValido(user) || novoNome == null || novoNome.isBlank()) return false;
        return userDao.mudarNomeUser(user, novoNome);
    }

    public boolean mudarNome(String userName, String novoNome, int senha) {
        User user = autenticar(userName, senha);
        return mudarNome(user, novoNome);
    }

    public boolean mudarEmail(User user, String novoEmail) {
        if (!usuarioValido(user) || novoEmail == null || novoEmail.isBlank()) return false;
        return userDao.mudarEmailUser(user, novoEmail);
    }

    public boolean mudarEmail(String userName, int senha, String novoEmail) {
        User user = autenticar(userName, senha);
        return mudarEmail(user, novoEmail);
    }
}
