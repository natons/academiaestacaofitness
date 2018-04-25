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
import mvc.model.persistencia.TelefoneDao;

/**
 *
 * @author Natanael
 */
public class MostraProfessor implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
        if (req.getParameter("id")!=null){
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Professor professor = ProfessorDao.listaUm(id);
            professor.setTelefones(TelefoneDao.listaUmProf(id));

            req.setAttribute("professor", professor);
        }
        
        return "/WEB-INF/jsp/mostra-professores.jsp";
    }
}
