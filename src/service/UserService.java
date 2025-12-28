package service;

import dao.UserDAO;
import model.User;
import util.UserUtil;

public class UserService {

    private final UserDAO userDao = new UserDAO();

    public String criarUser(String userName, String emailUser, int senhaUser) {

        User userAux = new User(userName, emailUser, senhaUser);

        boolean isValid = UserUtil.userIsValid(userAux);

        if (isValid) {
            userDao.criarUser(userAux);
            return " Usuario Criado";
        }

        return "Alguma informação é nula ,TENTE NOVAMENTE! ";
    }

    public String removerUser(String userName, String emailUser, int senha) {

        User userInput = new User(userName, emailUser, senha);

        boolean isValid = UserUtil.userIsValid(userInput);
        boolean existe = userDao.userExite(userInput);

        if (isValid && existe) {
            userDao.removerUsuario(userInput);
            return " Usuario removido !";
        }

        return "Alguma coisa esta errada,TENTE NOVAMENTE! ";
    }

    public String mudarNome(String userName, String emailUser, int senha) {

        User userAux = new User(userName, emailUser, senha);

        if (UserUtil.userIsValid(userAux) && userDao.userExite(userAux)) {
            userDao.mudarNomeUser(userAux, userAux.getUserName());
            return " Seu nome foi alterado!";
        }

        return "O nome não pode ser alterado!";
    }







}
