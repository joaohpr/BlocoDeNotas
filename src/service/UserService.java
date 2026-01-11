package service;

import dao.UserDAO;
import model.User;
import util.UserUtil;

public class UserService {

    private final UserDAO userDao = new UserDAO();
    private final UserUtil userUtil = new UserUtil();

    private User autenticar(String userName, int senha) {
        User user = userDao.retornaUser(userName, senha);
        return userUtil.userIsValid(user) ? user : null;
    }

    public boolean criarUser(String userName, String emailUser, int senhaUser) {
        User user = new User(userName, emailUser, senhaUser);

        if (!userUtil.userIsValid(user)) {
            return false;
        }

        return userDao.criarUser(user);
    }

    public boolean removerUser(String userName, int senha) {
        User user = autenticar(userName, senha);
        if (user == null) return false;

        return userDao.removerUsuario(user);
    }

    public boolean mudarNome(String userName, String novoNome, int senha) {
        User user = autenticar(userName, senha);
        if (user == null || novoNome == null || novoNome.isBlank()) return false;

        return userDao.mudarNomeUser(user, novoNome);
    }

    public boolean mudarEmail(String userName, int senha, String novoEmail) {
        User user = autenticar(userName, senha);
        if (user == null || novoEmail == null || novoEmail.isBlank()) return false;

        return userDao.mudarEmailUser(user, novoEmail);
    }
}
