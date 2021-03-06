/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Estagiario;
import mvc.model.persistencia.EstagiarioDao;

/**
 *
 * @author Luciana
 */
public class MostraEstagiarioPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        int id = Integer.parseInt( req.getParameter("id") );
        Estagiario estagiario = new Estagiario();
        estagiario = EstagiarioDao.listaUm(id);
        
        req.setAttribute("estagiario", estagiario);
        
        return "/WEB-INF/jsp/estagiario-perfil-altera.jsp";
    }
    
}
  