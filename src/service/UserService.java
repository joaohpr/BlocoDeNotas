package service;

import dao.UserDAO;
import model.User;
import model.Credenciais;
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

    private boolean usuarioValido(Credenciais credenciais) {
        User user = userDao.retornaUser(
                credenciais.getNome(),
                credenciais.getSenha()
        );
        return util.userIsValid(user);
    }

    public boolean criarUser(String userName, String emailUser, int senhaUser) {
        User user = new User(userName, emailUser, senhaUser);
        if (!usuarioValido(user)) return false;
        return userDao.criarUser(user);
    }

    public boolean removerUser(Credenciais credenciais) {
        if (!usuarioValido(credenciais)) return false;
        User user = autenticar(
                credenciais.getNome(),
                credenciais.getSenha()
        );
        return userDao.removerUsuario(user);
    }

    public boolean alterarUserName(Credenciais credenciais, String novoNome) {
        if (!usuarioValido(credenciais) || novoNome == null || novoNome.isBlank())
            return false;

        User user = autenticar(
                credenciais.getNome(),
                credenciais.getSenha()
        );

        return userDao.mudarNomeUser(user, novoNome);
    }

    public boolean alterarEmailUser(Credenciais credenciais, String novoEmail) {
        if (!usuarioValido(credenciais) || novoEmail == null || novoEmail.isBlank())
            return false;

        User user = autenticar(
                credenciais.getNome(),
                credenciais.getSenha()
        );

        return userDao.mudarEmailUser(user, novoEmail);
    }
}

