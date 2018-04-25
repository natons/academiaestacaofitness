/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Nutricionista;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class MostraNutricionistaPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        int id = Integer.parseInt( req.getParameter("id") );
        Nutricionista nutricionista = new Nutricionista();
        nutricionista = NutricionistaDao.listaUm(id);
        
        req.setAttribute("nutricionista", nutricionista);
        
        return "/WEB-INF/jsp/nutricionista-perfil-altera.jsp";
    }
    
}

