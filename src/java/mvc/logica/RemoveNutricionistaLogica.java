/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class RemoveNutricionistaLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));

        NutricionistaDao.deletar(id);

        req.setAttribute("mensagem", "Nutricionista Deletado com sucesso");

        return "mvc?logica=ListaNutricionistaLogica";
    }

}
