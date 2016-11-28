/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Professor;
import mvc.model.persistencia.ProfessorDao;

/**
 *
 * @author Luciana
 */
public class AlteraProfessorPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Professor professor = new Professor();
        int id = Integer.parseInt(req.getParameter("idProfessor"));
        professor.setSenha(req.getParameter("senha"));

        ProfessorDao.alterarSenha(professor, id);

        return "mvc?logica=LstProfessorPerfil&id=" + id;
    }

}
