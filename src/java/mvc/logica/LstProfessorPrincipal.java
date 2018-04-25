/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Aluno;
import mvc.model.Avaliacao;
import mvc.model.Sugestao;
import mvc.model.Tipo;
import mvc.model.persistencia.AlunoDao;
import mvc.model.persistencia.AvaliacaoDao;
import mvc.model.persistencia.SugestaoDao;
import mvc.model.persistencia.TipoDao;

/**
 *
 * @author Luciana
 */
public class LstProfessorPrincipal implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {

            AtualizaSession.atualizaSessionProf(req, res);

            List<Sugestao> sugestoes = SugestaoDao.listaTp("Professor");
            req.setAttribute("sugestoes", sugestoes);

            List<Aluno> alunos = AlunoDao.listar();
            req.setAttribute("alunos", alunos);

            List<Tipo> tipos = TipoDao.listar();
            req.setAttribute("tipos", tipos);
            
            List<Avaliacao> avaliacoes = AvaliacaoDao.listar();
            req.setAttribute("avaliacoes", avaliacoes);
            
            if (req.getAttribute("mensagem") != null){
                String mensagem = (String) req.getAttribute("mensagem");
                req.setAttribute("mensagem", mensagem);
            }

            return "/WEB-INF/jsp/professor-principal.jsp";
        }
    }

}
