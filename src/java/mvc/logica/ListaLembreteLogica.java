/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Lembrete;
import mvc.model.persistencia.LembreteDao;

/**
 *
 * @author Natanael
 */
public class ListaLembreteLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            // Monta a lista de Lembretes
            List<Lembrete> lembretes = LembreteDao.listaUmRecep(id);

            // Guarda a lista no request
            req.setAttribute("lembretes", lembretes);

            String mensagem = (String) req.getAttribute("mensagem");

            if (mensagem != null) {
                req.setAttribute("mensagem", mensagem);
            }
        }
      return "/WEB-INF/jsp/lembretes.jsp";
    }
}
