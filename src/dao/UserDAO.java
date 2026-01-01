package dao;

import bd.BancoDeDadosUser;
import model.User;

import java.util.ArrayList;

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


    public boolean userExite(String nome,int senha){

        boolean retorno = false;

        for(int i = 0;i < usuarios.size();i++){

            User userAux = usuarios.getUser(i);

            if(userAux.getUserName().equals(nome) && userAux.getSenhaUser() == senha){
                retorno = true;
                break;
            }
        }

        return retorno;
    }


    public User retornaUser(String nome,int senha){

        ArrayList<User> usersAux = new ArrayList<>();
        usersAux = (ArrayList<User>) usuarios.getUsuarios();

        for(int i = 0;i < usersAux.size();i++){
            User userOut = usersAux.get(i);
            if(userOut.getUserName().equals(nome) && userOut.getSenhaUser() ==  senha){
                return userOut;
            }
        }
        return null;
    }





}
