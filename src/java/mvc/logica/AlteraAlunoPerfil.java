/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Aluno;
import mvc.model.persistencia.AlunoDao;

/**
 *
 * @author Natanael
 */
public class AlteraAlunoPerfil implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Aluno aluno = new Aluno();
        int id = Integer.parseInt(req.getParameter("idAluno"));
        aluno.setSenha(req.getParameter("senha"));
        
        AlunoDao.alterarSenha(aluno, id);
                
        
        return "mvc?logica=LstAlunoPerfil&id="+id;
    }
    
    
}
