/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Natanael
 */
public class LstAlunoAvaliacao implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } 
        else {
            
            AtualizaSession.atualizaSessionAlun(req, res);
            
            return "/WEB-INF/jsp/aluno-avaliacao.jsp";
        }
    }
}
