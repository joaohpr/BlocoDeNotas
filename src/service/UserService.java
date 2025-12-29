package service;

import dao.UserDAO;
import model.User;
import util.UserUtil;

public class UserService {

    private final UserDAO userDao = new UserDAO();
    public final UserUtil userUtil = new UserUtil();

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

    public String mudarNome(String userName, String emailUser,String nomeSet ,int senha) {

        User userAux = new User(userName, emailUser, senha);

        if (UserUtil.userIsValid(userAux) && userDao.userExite(userAux)) {
            userDao.mudarNomeUser(userAux, nomeSet);
            return " Seu nome foi alterado!";
        }

        return "O nome não pode ser alterado!";
    }


    public String mudarEmail(String userName,String email,int senha,String emailSet){

        User userAux = new User(userName,email, senha);

        boolean valid = userUtil.userIsValid(userAux);
        boolean existe = userDao.userExite(userAux);

        if(valid && existe){
            userDao.mudarEmailUser(userAux,emailSet);
            return "Email alterado com sucesso!";
        }

        return "Não foi possivel alterar o email do usuario!";
    }











}
