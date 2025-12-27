package service;

import dao.UserDAO;
import model.User;



public class UserService {

    User user = new User();
    UserDAO userDao = new UserDAO();


    public boolean userIsValid(User userInput) {

        boolean userIsNull = false;
        boolean userNameIsPresent = false;
        boolean emailIsNull = false;
        boolean senhaIsValid = false;

        if (userInput == null) {
            userIsNull = true;
        } else {

            if (userInput.getUserName() != null) {
                userNameIsPresent = true;
            }

            if (userNameIsPresent) {
                if (userInput.getEmailUser() == null) {
                    emailIsNull = true;
                }
            }

            if (userNameIsPresent) {
                if (userInput.getSenhaUser() != 0) {
                    senhaIsValid = true;
                }
            }
        }

        if (userIsNull) {
            return true;
        }

        if (userNameIsPresent && (emailIsNull || senhaIsValid)) {
            return true;
        }

        return false;

    }


    public String criarUser(String userName, String emailUser, int senhaUser) {

        User userAux = new User(userName, emailUser, senhaUser);

        boolean isValid = userIsValid(userAux);

        if (isValid) {
            userDao.criarUser(userAux);
            return " Usuario Criado";
        }

        return "Alguma informação é nula ,TENTE NOVAMENTE! ";
    }


    public String removerUser(String userName,String emailUser,int senha) {

        User userInput = new User(userName,emailUser,senha);

        boolean isValid = userIsValid(userInput);
        boolean existe = userDao.userExite(userInput);

        if (isValid && existe) {

            userDao.removerUsuario(userInput);
            return " Usuario removido !";
        }
        return "Alguma coisa esta errada,TENTE NOVAMENTE! ";
    }


    public String mudarNome(String userName,String emailUser,int senha){

        User userAux = new User(userName,emailUser,senha);

        if(userIsValid(userAux) && userDao.userExite(userAux)){
            userDao.mudarNomeUser(userAux,userAux.getUserName());
            return " Seu nome foi alterado!";
        }
        return "O nome não pode ser alterado!";
    }


}



