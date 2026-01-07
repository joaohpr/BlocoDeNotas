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

    public String removerUser(String userName, int senha) {

        User userInput = userDao.retornaUser(userName,senha);

        boolean isValid = UserUtil.userIsValid(userInput);
        boolean existe = userDao.userExite(userInput.getUserName(),userInput.getSenhaUser());

        if (isValid && existe) {
            userDao.removerUsuario(userInput);
            return " Usuario removido !";
        }

        return "Alguma coisa esta errada,TENTE NOVAMENTE! ";
    }

    public String mudarNome(String userName,String nomeSet ,int senha) {

        User userAux = userDao.retornaUser(userName,senha);

        if (UserUtil.userIsValid(userAux) && userDao.userExite(userAux.getUserName(),userAux.getSenhaUser())) {
            userDao.mudarNomeUser(userAux, nomeSet);
            return " Seu nome foi alterado!";
        }

        return "O nome não pode ser alterado!";
    }


    public String mudarEmail(String userName,int senha,String emailSet){

        User userAux = userDao.retornaUser(userName,senha);

        boolean valid = userUtil.userIsValid(userAux);
        boolean existe = userDao.userExite(userAux.getUserName(),userAux.getSenhaUser());

        if(valid && existe){
            userDao.mudarEmailUser(userAux,emailSet);
            return "Email alterado com sucesso!";
        }

        return "Não foi possivel alterar o email do usuario!";
    }










}
