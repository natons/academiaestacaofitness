/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Nutricionista;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class LstNutricionistaPerfil implements Logica{
 
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            
            AtualizaSession.atualizaSessionNutr(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Nutricionista nutricionista = NutricionistaDao.listaUm(id);
            
            req.setAttribute("nutricionista", nutricionista);
            return "/WEB-INF/jsp/nutricionista-perfil.jsp";
        }
    }
    
    
}

    