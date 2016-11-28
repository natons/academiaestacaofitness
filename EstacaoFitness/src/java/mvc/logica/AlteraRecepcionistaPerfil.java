/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Recepcionista;
import mvc.model.persistencia.RecepcionistaDao;

/**
 *
 * @author Luciana
 */
public class AlteraRecepcionistaPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Recepcionista recepcionista = new Recepcionista();
        int id = Integer.parseInt(req.getParameter("idRecepcionista"));
        recepcionista.setSenha(req.getParameter("senha"));

        RecepcionistaDao.alterarSenha(recepcionista, id);

        return "mvc?logica=LstRecepcionistaPerfil&id=" + id;
    }
}
