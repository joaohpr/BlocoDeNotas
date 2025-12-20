package model;

public class Notas {
    private String title;
    private String nota;
    private int id;

    public Notas(String titleInput,String notaInput,int idInput){
        this.id = idInput;
        this.nota = notaInput;
        this.title = titleInput;
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