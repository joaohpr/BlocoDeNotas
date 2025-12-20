package bd;


import model.Notas;

import java.util.ArrayList;

public class BancoDeDadosNotas {
    public int indice = 0;
    ArrayList<Notas> bancoDeDados = new ArrayList<>();

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getIndice() {
        return indice;
    }

    @Override
    public String toString() {
        String retorno = "";

        for (int i = 0; i < bancoDeDados.size(); i++) {
            retorno += bancoDeDados.get(i).toString() + "\n";
        }

        return retorno;
    }

}
