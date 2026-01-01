package service;

import dao.NotasDAO;
import dao.UserDAO;
import model.Notas;
import model.User;
import util.NotasUtil;
import util.UserUtil;

public class NotasServices {

    private final NotasDAO notasDao = new NotasDAO();
    public final NotasUtil notasUtil = new NotasUtil();
    public final UserDAO userDao = new UserDAO();
    public final UserUtil userUtil = new UserUtil();

    public String criarNota(String userName, int senhaUser, String title, String text) {

        User userAux = userDao.retornaUser(userName, senhaUser);
        Notas notaAux = new Notas(title, text);

        if (!userUtil.userIsValid(userAux) || !notasUtil.notaIsValid(notaAux)) {
            return "Dados inválidos!";
        }

        notasDao.criarNota(userAux, title, text);
        return "Nota criada com sucesso!";
    }

    public String excluirNota(String userName, int senhaUser, int idNota) {

        User userAux = userDao.retornaUser(userName, senhaUser);

        if (!userUtil.userIsValid(userAux) || idNota <= 0) {
            return "Não foi possível excluir a nota!";
        }

        Notas nota = notasDao.buscarNotas(userAux, idNota);

        if (nota == null) {
            return "Nota não encontrada!";
        }

        notasDao.excluirNota(userAux, idNota);
        return "Nota excluída com sucesso!";
    }

    public String alterarNota(String userName, int senhaUser, int idNota, String newText) {

        User userAux = userDao.retornaUser(userName, senhaUser);

        if (!userUtil.userIsValid(userAux) || idNota <= 0 || newText == null || newText.isBlank()) {
            return "Não foi possível alterar a nota!";
        }

        Notas nota = notasDao.buscarNotas(userAux, idNota);

        if (nota == null) {
            return "Nota não encontrada!";
        }

        notasDao.alterarNota(userAux, idNota, newText);
        return "Nota alterada com sucesso!";
    }

    public String removerTodasNotas(String userName, int senhaUser) {

        User usuario = userDao.retornaUser(userName, senhaUser);

        if (!userUtil.userIsValid(usuario)) {
            return "Usuário inválido!";
        }

        notasDao.removerTodasNotas(usuario);
        return "Todas as notas foram removidas com sucesso!";
    }

    public String listarTodasNotas(String userName, int senhaUser) {

        User usuario = userDao.retornaUser(userName, senhaUser);

        if (!userUtil.userIsValid(usuario)) {
            return "Usuário inválido!";
        }

        notasDao.allNotes(usuario);

       return "";
    }
}
