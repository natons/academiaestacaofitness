/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Lembrete;
import mvc.model.persistencia.LembreteDao;

/**
 *
 * @author Natanael
 */
public class MostraLembrete implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
        if (req.getParameter("id")!=null){
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Lembrete lembrete = LembreteDao.listaUm(id);

            req.setAttribute("lembrete", lembrete);
        }
        
        return "/WEB-INF/jsp/mostra-lembretes.jsp";
    }
}
