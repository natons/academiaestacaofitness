/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Nutricionista;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class AlteraNutricionistaPerfil implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Nutricionista nutricionista = new Nutricionista();
        int id = Integer.parseInt(req.getParameter("idNutricionista"));
        nutricionista.setSenha(req.getParameter("senha"));

        NutricionistaDao.alterarSenha(nutricionista, id);

        return "mvc?logica=LstNutricionistaPerfil&id=" + id;
    }

}
