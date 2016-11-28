/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Estagiario;
import mvc.model.persistencia.EstagiarioDao;

/**
 *
 * @author Luciana
 */
public class LstEstagiarioPerfil implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            int id = Integer.parseInt(req.getParameter("id"));
            Estagiario estagiario = EstagiarioDao.listaUm(id);
            
            req.setAttribute("estagiario", estagiario);
            return "/WEB-INF/jsp/estagiario-perfil.jsp";
        }
    }
    
    
}

    