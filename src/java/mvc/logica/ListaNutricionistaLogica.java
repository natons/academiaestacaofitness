/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Nutricionista;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class ListaNutricionistaLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            // Monta a lista de Nutricionistas
            List<Nutricionista> nutricionistas = NutricionistaDao.listar();

            // Guarda a lista no request
            req.setAttribute("nutricionistas", nutricionistas);

            String mensagem = (String) req.getAttribute("mensagem");

            if (mensagem != null) {
                req.setAttribute("mensagem", mensagem);
            }
        }
      return "/WEB-INF/jsp/nutricionistas.jsp";
  }
}
