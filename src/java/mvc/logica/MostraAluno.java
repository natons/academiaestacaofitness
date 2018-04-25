/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import mvc.model.Aluno;
import mvc.model.persistencia.AlunoDao;
import mvc.model.persistencia.TelefoneDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Natanael
 */
public class MostraAluno implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
        if (req.getParameter("id")!=null){
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            int id = Integer.parseInt(req.getParameter("id"));
            Aluno aluno = AlunoDao.listaUm(id);
            aluno.setTelefones(TelefoneDao.listaUmAlu(id));

            req.setAttribute("aluno", aluno);
        }
        
        return "/WEB-INF/jsp/mostra-alunos.jsp";
    }

    
    
}
