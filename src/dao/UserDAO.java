package dao;

import bd.BancoDeDadosUser;
import model.User;

public class UserDAO {

    public UserDAO(){
        this.usuarios = BancoDeDadosUser.getInstancia();
    }

   private final BancoDeDadosUser usuarios;


    public void criarUser(User user){
        usuarios.addUser(user);
    }


    public void removerUsuario(User userInput){
        for(int i = 0;i < usuarios.size();i++){

            User userComparar = usuarios.getUser(i);

            if(userComparar.equals( userInput)){
                usuarios.removeUser(i);
                break;
            }
        }
    }


    public void mudarNomeUser(User user,String nomeSet){
        user.setUserName(nomeSet);
    }


    public void mudarEmailUser(User user,String emailSet){
        user.setEmailUser(emailSet);
    }


    public boolean userExite(User userInput){

        boolean retorno = false;

        for(int i = 0;i < usuarios.size();i++){

            User userAux = usuarios.getUser(i);

            if(userAux.equals(userInput)){
                retorno = true;
                break;
            }
        }

        return retorno;
    }


}
