/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.persistencia.SugestaoDao;

/**
 *
 * @author Natanael
 */
public class RemoveSugestaoLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {

        int id = Integer.parseInt(req.getParameter("id"));

        SugestaoDao.deletar(id);

        req.setAttribute("mensagem", "Sugestão Deletada com sucesso");

        return "mvc?logica=ListaSugestaoLogica";
    }
}
