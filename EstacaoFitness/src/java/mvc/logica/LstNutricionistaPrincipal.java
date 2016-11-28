/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Alimento;
import mvc.model.Dieta;
import mvc.model.Nutricionista;
import mvc.model.persistencia.AlimentoDao;
import mvc.model.persistencia.DietaDao;

/**
 *
 * @author Luciana
 */
public class LstNutricionistaPrincipal implements Logica {
@Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            
            AtualizaSession.atualizaSessionNutr(req, res);
            
            Nutricionista nutricionista = (Nutricionista) req.getSession().getAttribute("usuario");
            
            List<Dieta> dietasVenc = DietaDao.listarDieVenc(nutricionista.getIdNutricionista());
            
            List<Alimento> alimentos = AlimentoDao.listar();
            
            req.setAttribute("dietasVenc", dietasVenc);
            req.setAttribute("alimentos", alimentos);
            
            return "/WEB-INF/jsp/nutricionista-principal.jsp";
        }
    }
    
}

    
