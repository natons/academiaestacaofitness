/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Estagiario;
import mvc.model.persistencia.EstagiarioDao;

/**
 *
 * @author Luciana
 */
public class ListaEstagiarioLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            AtualizaSession.atualizaSessionRecep(req, res);
            
            // Monta a lista de Estagiarios
            List<Estagiario> estagiarios = EstagiarioDao.listar();

            // Guarda a lista no request
            req.setAttribute("estagiarios", estagiarios);

            String mensagem = (String) req.getAttribute("mensagem");

            if (mensagem != null) {
                req.setAttribute("mensagem", mensagem);
            }
        }
        return "/WEB-INF/jsp/estagiarios.jsp";
    }
}
