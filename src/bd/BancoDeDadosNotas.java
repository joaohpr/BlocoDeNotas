package bd;


import model.Notas;

import java.util.ArrayList;

public class BancoDeDadosNotas {
    public int indice = 0;
    public ArrayList<Notas> notas = new ArrayList<>();

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < notas.size(); i++) {
            retorno += notas.get(i).toString() + "\n";
        }

        return retorno;
    }

}
