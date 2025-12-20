package bd;

import model.User;
import java.util.ArrayList;
import java.util.List;

public final class BancoDeDadosUser {

    // instância única
    private static BancoDeDadosUser instancia;

    // armazenamento interno
    private final List<User> usuarios;

    // construtor privado
    private BancoDeDadosUser() {
        this.usuarios = new ArrayList<>();
    }

    // acesso único (thread-safe simples)
    public static synchronized BancoDeDadosUser getInstancia() {
        if (instancia == null) {
            instancia = new BancoDeDadosUser();
        }
        return instancia;
    }

    // adiciona usuário com proteção
    public synchronized void addUser(User user) {
        if (user == null) {
            return;
        }
        usuarios.add(user);
    }

    // retorna usuário por índice (seguro)
    public synchronized User getUser(int index) {
        if (index < 0 || index >= usuarios.size()) {
            return null;
        }
        return usuarios.get(index);
    }

    // remove usuário por índice (seguro)
    public synchronized void removeUser(int index) {
        if (index < 0 || index >= usuarios.size()) {
            return;
        }
        usuarios.remove(index);
    }

    // tamanho da lista
    public synchronized int size() {
        return usuarios.size();
    }

    // acesso controlado (cópia)
    public synchronized List<User> getUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
