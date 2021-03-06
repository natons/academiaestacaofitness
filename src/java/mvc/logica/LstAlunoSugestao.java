/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Sugestao;
import mvc.model.persistencia.SugestaoDao;

/**
 *
 * @author Natanael
 */
public class LstAlunoSugestao implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            AtualizaSession.atualizaSessionAlun(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            
            // Monta a lista de Estagiarios
            List<Sugestao> sugestoes = SugestaoDao.listaUmAlu(id);

            // Guarda a lista no request
            req.setAttribute("sugestoes", sugestoes);

            String mensagem = (String) req.getAttribute("mensagem");

            if (mensagem != null) {
                req.setAttribute("mensagem", mensagem);
            }
        }
      return "/WEB-INF/jsp/aluno-sugestao.jsp";
  }
}
