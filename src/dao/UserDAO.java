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


    public void mudarSenhaUser(User user,int senhaSet){
        user.setSenhaUser(senhaSet);
    }




}
