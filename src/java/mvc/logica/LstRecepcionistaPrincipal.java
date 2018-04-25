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
import mvc.model.Lembrete;
import mvc.model.Recepcionista;
import mvc.model.persistencia.AlunoDao;
import mvc.model.persistencia.EstagiarioDao;
import mvc.model.persistencia.LembreteDao;
import mvc.model.persistencia.NutricionistaDao;
import mvc.model.persistencia.ProfessorDao;
import mvc.model.persistencia.RecepcionistaDao;

/**
 *
 * @author Luciana
 */
public class LstRecepcionistaPrincipal implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            Recepcionista recepcionista = (Recepcionista) req.getSession().getAttribute("usuario");
            
            List<Aluno> alunos = AlunoDao.listarUltimos();
            List<Lembrete> lembretes = LembreteDao.listaUltiRecep(recepcionista.getIdRecepcionista());
            int qtdProfessor = ProfessorDao.listarQtd();
            int qtdRecepcionista = RecepcionistaDao.listarQtd();
            int qtdAluno = AlunoDao.listarQtd();
            int qtdEstagiario = EstagiarioDao.listarQtd();
            int qtdNutricionista = NutricionistaDao.listarQtd();
            
            req.setAttribute("alunos", alunos);
            req.setAttribute("qtdProfessor", qtdProfessor);
            req.setAttribute("lembretes", lembretes);
            req.setAttribute("alunAtivos", porcAlunosAtivados());
            req.setAttribute("alunInativos", porcAlunosDesativados());
            req.setAttribute("qtdRecepcionista", qtdRecepcionista);
            req.setAttribute("qtdAluno", qtdAluno);
            req.setAttribute("qtdEstagiario", qtdEstagiario);
            req.setAttribute("qtdNutricionista", qtdNutricionista);

            return "/WEB-INF/jsp/recepcionista-principal.jsp";
        }
    }
    
    private Double porcAlunosAtivados() throws Exception{
        double qtdStatusAtiv = AlunoDao.listarStaAtiv();
        double qtdStatusDesa = AlunoDao.listarStaDesa();
        
        double total = qtdStatusAtiv + qtdStatusDesa;
        
        Double porc = (qtdStatusAtiv/total) * 100;
        
        return porc;
    }
    
    private Double porcAlunosDesativados() throws Exception{
        double qtdStatusAtiv = AlunoDao.listarStaAtiv();
        double qtdStatusDesa = AlunoDao.listarStaDesa();
        
        double total = qtdStatusAtiv + qtdStatusDesa;
        
        Double porc = (qtdStatusDesa/total) * 100;
        
        return porc;
    }

}
