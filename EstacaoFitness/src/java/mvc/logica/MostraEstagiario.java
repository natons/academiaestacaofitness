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
import mvc.model.persistencia.TelefoneDao;

/**
 *
 * @author Natanael
 */
public class MostraEstagiario implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
        if (req.getParameter("id")!=null){
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Estagiario estagiario = EstagiarioDao.listaUm(id);
            estagiario.setTelefones(TelefoneDao.listaUmEst(id));

            req.setAttribute("estagiario", estagiario);
        }
        
        return "/WEB-INF/jsp/mostra-estagiarios.jsp";
    }
}
