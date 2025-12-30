package model;

import java.util.Random;

public class Notas {
    private String title;
    private String nota;
    private int id;


    Random aleatorio = new Random();

    public Notas(String titleInput,String notaInput){
        this.nota = notaInput;
        this.title = titleInput;
        this.id =  aleatorio.nextInt(100000);
    }

    public Notas(){

    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String titleInput){
        this.title = titleInput;
    }


    public String getNota(){
        return this.nota;
    }

    public void setNota(String notaInput){
        this.nota = notaInput;
    }


    public int getId(){
        return this.id;
    }

    public void setId(int idInput){
        this.id = idInput;
    }



    @Override
    public String toString(){
        return "Nota \n Titulo : " + this.title + " Nota :  "+this.nota + " Identificação : "+this.id;
    }

}