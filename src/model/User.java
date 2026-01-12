package model;

import bd.BancoDeDadosNotas;

public class User {
    private String userName;
    private String emailUser;
    private int senhaUser;
    public BancoDeDadosNotas bancoDeDadosNotasUser;


   public User(String nameInput,String emailInput,int senhaInput){
       this.userName = nameInput;
       this.emailUser = emailInput;
       this.senhaUser = senhaInput;
       bancoDeDadosNotasUser = new BancoDeDadosNotas();
   }


   public User(){

   }


   public String getUserName(){
       return this.userName;
   }


   public void setUserName(String nameInput){
       this.userName = nameInput;
   }


   public String getEmailUser(){
       return this.emailUser;
   }

   public void setEmailUser(String emailUserInput){
       this.emailUser = emailUserInput;
   }


   public int getSenhaUser(){
       return this.senhaUser;
   }


   public void setSenhaUser(int senhaInput){
       this.senhaUser = senhaInput;
   }


   @Override
   public String toString(){
      return " User \n Name : "+this.userName + " \n Email : "+this.emailUser+"\n Senha : "+this.senhaUser;
   }

}
