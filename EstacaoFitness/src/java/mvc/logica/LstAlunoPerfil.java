/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Aluno;
import mvc.model.persistencia.AlunoDao;

/**
 *
 * @author Natanael
 */
public class LstAlunoPerfil implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            int id = Integer.parseInt(req.getParameter("id"));
            Aluno aluno = AlunoDao.listaUm(id);
            
            req.setAttribute("aluno", aluno);
            return "/WEB-INF/jsp/aluno-perfil.jsp";
        }
    }
    
    
}
