package dao;

import bd.BancoDeDadosUser;
import model.User;

import java.util.List;

public class UserDAO {

    private final BancoDeDadosUser usuarios;

    public UserDAO() {
        this.usuarios = BancoDeDadosUser.getInstancia();
    }

    public boolean criarUser(String nome, String email, int senha) {

        if (nome == null || nome.isBlank()) return false;
        if (email == null || email.isBlank()) return false;

        if (userExiste(nome, senha)) return false;

        User user = new User(nome, email, senha);
        usuarios.addUser(user);
        return true;
    }

    public boolean removerUser(User user) {

        if (user == null) return false;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.getUser(i).equals(user)) {
                usuarios.removeUser(i);
                return true;
            }
        }
        return false;
    }

    public boolean alterarNome(User user, String novoNome) {

        if (user == null || novoNome == null || novoNome.isBlank()) return false;

        user.setUserName(novoNome);
        return true;
    }

    public boolean alterarEmail(User user, String novoEmail) {

        if (user == null || novoEmail == null || novoEmail.isBlank()) return false;

        user.setEmailUser(novoEmail);
        return true;
    }

    public boolean userExiste(String nome, int senha) {
        return retornaUser(nome, senha) != null;
    }

    public User retornaUser(String nome, int senha) {

        List<User> lista = usuarios.getUsuarios();

        for (User u : lista) {
            if (u.getUserName().equals(nome) && u.getSenhaUser() == senha) {
                return u;
            }
        }
        return null;
    }
}
