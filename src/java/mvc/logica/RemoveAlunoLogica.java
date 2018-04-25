/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import mvc.model.persistencia.AlunoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Natanael
 */
public class RemoveAlunoLogica implements Logica {

  @Override
  public String executa(HttpServletRequest req, HttpServletResponse res)
      throws Exception {

    int id = Integer.parseInt(req.getParameter("id"));
    
    AlunoDao.deletar(id);
    
    req.setAttribute("mensagem", "Aluno Deletado com sucesso");
    

    return "mvc?logica=ListaAlunoLogica";
  }

}
