/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Professor;
import mvc.model.persistencia.ProfessorDao;

/**
 *
 * @author Luciana
 */
public class LstProfessorPerfil implements Logica{
 
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            AtualizaSession.atualizaSessionProf(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Professor professor = ProfessorDao.listaUm(id);
            
            req.setAttribute("professor", professor);
            return "/WEB-INF/jsp/professor-perfil.jsp";
        }
    }
    
    
}

    