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
import mvc.model.persistencia.TelefoneDao;

/**
 *
 * @author Natanael
 */
public class MostraNutricionista implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
        if (req.getParameter("id")!=null){
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Nutricionista nutricionista = NutricionistaDao.listaUm(id);
            nutricionista.setTelefones(TelefoneDao.listaUmNutr(id));

            req.setAttribute("nutricionista", nutricionista);
        }
        
        return "/WEB-INF/jsp/mostra-nutricionistas.jsp";
    }
}
