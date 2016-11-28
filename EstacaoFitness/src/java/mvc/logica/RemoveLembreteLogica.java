/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Recepcionista;
import mvc.model.persistencia.LembreteDao;

/**
 *
 * @author Natanael
 */
public class RemoveLembreteLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
            throws Exception {
        Recepcionista recep = (Recepcionista) req.getSession().getAttribute("usuario");
       
        int id = Integer.parseInt(req.getParameter("id"));

        LembreteDao.deletar(id);

        req.setAttribute("mensagem", "Lembrete Deletado com sucesso");

        return "mvc?logica=ListaLembreteLogica&id="+ recep.getIdRecepcionista();
    }
}
