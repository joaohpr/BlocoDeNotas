package sessao;

import dao.UserDAO;
import model.User;

public class Sessao {

    private User usuario;
    private boolean isLogado = false;
    private final UserDAO userDao = new UserDAO();

    public boolean estaLogado() {
        return isLogado;
    }

    public boolean login(String nome, int senha) {

        User user = userDao.retornaUser(nome, senha);

        if (user == null) {
            return false;
        }

        this.usuario = user;
        this.isLogado = true;
        return true;
    }

    public void logOut() {
        this.usuario = null;
        this.isLogado = false;
    }



    public String getNomeUsuario() {
        return isLogado ? usuario.getUserName() : null;
    }

    public int getSenhaUsuario() {
        return isLogado ? usuario.getSenhaUser() : -1;
    }

    @Override
    public String toString() {
        if (!isLogado) {
            return "Nao ha login de nenhum usuario!";
        }

        return "Usuario logado\n" +
                "Nome: " + usuario.getUserName() + "\n" +
                "Email: " + usuario.getEmailUser();
    }
}
