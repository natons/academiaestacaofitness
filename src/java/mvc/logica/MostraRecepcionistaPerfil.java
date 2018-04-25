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
public class MostraRecepcionistaPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));
        Recepcionista recepcionista = new Recepcionista();
        recepcionista = RecepcionistaDao.listaUm(id);

        req.setAttribute("recepcionista", recepcionista);

        return "/WEB-INF/jsp/recepcionista-perfil-altera.jsp";
    }

}

