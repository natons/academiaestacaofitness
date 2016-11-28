/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Aluno;
import mvc.model.Avaliacao;
import mvc.model.Professor;
import mvc.model.persistencia.AvaliacaoDao;

/**
 *
 * @author Natanael
 */
public class AlteraProfessorAvaliacao implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            int idAlunoFK = Integer.parseInt(req.getParameter("idAlunoFK"));
            
            
            Avaliacao avaliacao = new Avaliacao();
            avaliacao.setValor(Double.parseDouble(req.getParameter("valor")));
            
            Aluno aluno = new Aluno();
            aluno.setIdAluno(idAlunoFK);
            avaliacao.setAluno(aluno);
            
            Professor professor = new Professor();
            professor.setIdProfessor(Integer.parseInt(req.getParameter("idProfessor")));
            avaliacao.setProfessor(professor);
            
            avaliacao.setResultado(req.getParameter("resultado"));
            
            
            //Recebendo Data e convertendo para gravar no bd
            java.util.Date d = new java.util.Date();

            String MyDate = req.getParameter("dataAvaliacao");
            SimpleDateFormat parseDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            d = parseDate.parse(MyDate);

            java.sql.Date dt = new java.sql.Date(d.getTime());
            avaliacao.setDataAvaliacao(dt);
            
            MyDate = req.getParameter("dataValidade");
            d = parseDate.parse(MyDate);
            dt = new java.sql.Date(d.getTime());
            avaliacao.setValidade(dt);
            //fim da conversão
            
            String op = req.getParameter("idAvaliacao");
            switch (op) {
                case "":
                    AvaliacaoDao.inserir(avaliacao);
                    
                    req.setAttribute("mensagem2", "Avaliação criada com Sucesso");
                    break;
                    
                default:
                    avaliacao.setIdAvaliacao(Integer.parseInt(req.getParameter("idAvaliacao")));
                    AvaliacaoDao.alterar(avaliacao);
                    
                    req.setAttribute("mensagem2", "Avaliação Alterada com Sucesso");
                    break;
            }
            
            return "mvc?logica=LstProfessorPrincipal";
        }
    }
    
}
