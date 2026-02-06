package service;

import dao.NotasDAO;
import dao.UserDAO;
import model.Notas;
import model.User;
import util.Util;
import model.Credenciais;

import java.util.List;

public class NotasService {

    private final NotasDAO notasDao = new NotasDAO();
    private final UserDAO userDao = new UserDAO();
    private final Util util = new Util();


    private User autenticar(Credenciais credenciais) {
        User user = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());
        return util.userIsValid(user) ? user : null;
    }

    private boolean usuarioValido(User user) {
        return util.userIsValid(user);
    }

    public boolean criarNota(Credenciais credenciais, String title, String text) {
        User userIn = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());
        if (!usuarioValido(userIn)) return false;

        Notas nota = new Notas(title, text);
        if (!util.notaIsValid(nota)) return false;

        return notasDao.criarNota(userIn, title, text);
    }


    public boolean excluirNota(Credenciais credenciaisInput, int idNota) {

        User user = userDao.retornaUser(credenciaisInput.getNome(), credenciaisInput.getSenha() );

        if (!usuarioValido(user) || idNota <= 0) return false;
        return notasDao.excluirNota(user, idNota);
    }




    public boolean alterarNota(Credenciais credenciais, int idNota, String newText) {

        User user = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());

        if (!usuarioValido(user) || idNota <= 0 || newText == null || newText.isBlank()) {
            return false;
        }
        return notasDao.alterarNota(user, idNota, newText);
    }



    public boolean alterarTitulo(Credenciais credenciais, int idNota, String newTitle) {

        User user = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());

        if (!usuarioValido(user) || idNota <= 0 || newTitle == null || newTitle.isBlank()) {
            return false;
        }
        return notasDao.alterarTitulo(user, idNota, newTitle);
    }



    public boolean removerTodasNotas(Credenciais credenciais ){

        User user = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());

        if (!usuarioValido(user)) return false;
        return notasDao.removerTodasNotas(user);
    }



    public List<Notas> listarTodasNotas( Credenciais credenciais) {

        User user = userDao.retornaUser(credenciais.getNome(), credenciais.getSenha());

        if (!usuarioValido(user)) return null;

        List<Notas> notas = user.bancoDeDadosNotasUser.getNotas();
        return notas.isEmpty() ? null : notas;
    }


}
