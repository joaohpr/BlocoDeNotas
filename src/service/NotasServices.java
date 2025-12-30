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

    public String criarNota(User userInput, String title, String text){

        Notas notaAUX = new Notas(title,text);

        boolean validN = notasUtil.notaIsValid(notaAUX);
        boolean validU = userDao.userExite(userInput.getUserName(), userInput.getSenhaUser());

        if(validN && validU){
            notasDao.criarNota(userInput,title,text);
            return "Nota criada com sucesso!";
        }
        return "Há algum erro TENTE NOVAMENTE!";
    }


    public String excluirNota(User userInput,int idNota){

        boolean existe = userDao.userExite(userInput.getUserName(),userInput.getSenhaUser());
        boolean validU = userUtil.userIsValid(userInput);
        Notas notaExcluir;

        if (existe && validU && idNota != 0){
            notaExcluir = notasDao.buscarNotas(userInput,idNota);
            notasDao.excluirNota(userInput,idNota);

            return "Nota excluida com sucesso!";
        }
        return "Não foi possivel excluir a nota!";
    }







}