package service;

import dao.UserDAO;
import model.User;
import sessao.Sessao;
import util.Util;

public class UserService {

    private final UserDAO userDao = new UserDAO();
    private final Util util = new Util();

    public void criarUser(String nome, String email, int senha) {

        boolean criado = userDao.criarUser(nome, email, senha);

        User user = new User(nome,email,senha);

        boolean isValid = util.userIsValid(user);


        if(criado == false && isValid == true) {
            System.out.println("Usuário criado com sucesso.");
        } else {
            System.out.println("Não foi possível criar o usuário (dados inválidos ou usuário já existe).");
            return;
        }

    }

    public void removerUser(Sessao sessao) {

        if (!sessao.estaLogado()) {
            System.out.println("Nenhum usuário logado.");
            return;
        }

        User user = sessao.getUser();

        boolean removido = userDao.removerUser(user);

        if (!removido) {
            System.out.println("Erro ao remover usuário.");
            return;
        }

        sessao.logOut();
        System.out.println("Usuário removido com sucesso.");
    }

    public void alterarUserName(Sessao sessao, String novoNome) {

        if (!sessao.estaLogado()) {
            System.out.println("Nenhum usuário logado.");
            return;
        }

        boolean alterado = userDao.alterarNome(sessao.getUser(), novoNome);

        if (!alterado) {
            System.out.println("Nome inválido.");
            return;
        }

        System.out.println("Nome alterado com sucesso.");
    }

    public void alterarEmailUser(Sessao sessao, String novoEmail) {

        if (!sessao.estaLogado()) {
            System.out.println("Nenhum usuário logado.");
            return;
        }

        boolean alterado = userDao.alterarEmail(sessao.getUser(), novoEmail);

        if (!alterado) {
            System.out.println("Email inválido.");
            return;
        }

        System.out.println("Email alterado com sucesso.");
    }
}
