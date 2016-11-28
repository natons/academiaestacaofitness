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
public class AlteraEstagiarioPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
    {

        Estagiario estagiario = new Estagiario();
        int id = Integer.parseInt(req.getParameter("idEstagiario"));
        estagiario.setSenha(req.getParameter("senha"));

        EstagiarioDao.alterarSenha(estagiario, id);

        return "mvc?logica=LstEstagiarioPerfil&id=" + id;
        
    }

}
