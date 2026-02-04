package model;

import Sessao.Sessao;
import util.Util;

public class Credenciais {

    private final String nome;
    private final int senha;

    public Credenciais(String nomeInput, int senhaInput) {
        this.nome = nomeInput;
        this.senha = senhaInput;
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }


    public static Credenciais obterCredenciais(Sessao sessao, Util util) {

        if (sessao.estaLogado()) {
            return new Credenciais(
                    sessao.getNomeUsuario(),
                    sessao.getSenhaUsuario()
            );
        }


        System.out.print("Nome: ");
        String nome = util.stringInput();

        System.out.print("Senha: ");
        int senha = util.intInput();

        return new Credenciais(nome, senha);
    }
}
