/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Aluno;
import mvc.model.Estagiario;
import mvc.model.Nutricionista;
import mvc.model.Professor;
import mvc.model.Recepcionista;
import mvc.model.Sugestao;
import mvc.model.persistencia.AlunoDao;
import mvc.model.persistencia.AvaliacaoDao;
import mvc.model.persistencia.DietaDao;
import mvc.model.persistencia.EstagiarioDao;
import mvc.model.persistencia.LembreteDao;
import mvc.model.persistencia.NutricionistaDao;
import mvc.model.persistencia.ProfessorDao;
import mvc.model.persistencia.RecepcionistaDao;
import mvc.model.persistencia.SugestaoDao;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Natanael
 */
public class AtualizaSession {
    
    public static void atualizaSessionRecep(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
            //atualizando a session
            
            //dados do recepcionista
            Recepcionista recepcionista = (Recepcionista) req.getSession().getAttribute("usuario");
            recepcionista = RecepcionistaDao.listaUmMatricula(recepcionista.getMatricula());
            session.removeAttribute("usuario");
            session.setAttribute("usuario", recepcionista);
            
            //lembretes
            session.removeAttribute("qtdLembretes");
            int qtdLembretes = LembreteDao.listaQtdRecep(recepcionista.getIdRecepcionista());
            session.setAttribute("qtdLembretes", qtdLembretes);
                
            //sugestões
            session.removeAttribute("novasSugestoes");
            List<Sugestao> sugestoes = SugestaoDao.listarNova();
            session.setAttribute("novasSugestoes", sugestoes);
            
            //quantidade de sugestões
            session.removeAttribute("qtdNovasSugestoes");
            int qtdNovasSugestoes = SugestaoDao.listarQtdNova();
            session.setAttribute("qtdNovasSugestoes", qtdNovasSugestoes);
                
            //quantidade de usuários total
            session.removeAttribute("qtdUsuarios");
            int qtdUsuarios = RecepcionistaDao.qtdTodosUsu();
            session.setAttribute("qtdUsuarios", qtdUsuarios);
            
            //FIM DA ATUALIZAÇÃO
    }
    
    public static void atualizaSessionAlun(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        
        Aluno aluno = (Aluno) req.getSession().getAttribute("usuario");
        aluno = AlunoDao.listaUmMatricula(aluno.getMatricula());
        String proxAvaliacao = AvaliacaoDao.ultimAvaliacao(aluno.getIdAluno());
        
        Date dataPrim = AvaliacaoDao.ultmAval(aluno.getIdAluno());

        Date data = new Date();
        DateTime dataAtual = new DateTime(data);
        DateTime dataAnterior = new DateTime(dataPrim);

        int qtdDias = Days.daysBetween(dataAnterior, dataAtual).getDays();
        
        session.removeAttribute("proxAvaliacao");
        session.removeAttribute("usuario");
        session.removeAttribute("qtdDias");
        session.setAttribute("usuario", aluno);
        session.setAttribute("proxAvaliacao", proxAvaliacao);
        session.setAttribute("qtdDias", qtdDias);
        
    }
    
    public static void atualizaSessionProf(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        
        Professor professor = (Professor) req.getSession().getAttribute("usuario");
        professor = ProfessorDao.listaUm(professor.getIdProfessor());
        
        int qtdSugestoes = SugestaoDao.listaQtdTp("Professor");
        int qtdAluno = AlunoDao.listarQtd();
        
        session.removeAttribute("qtdSugestoes");
        session.removeAttribute("usuario");
        session.removeAttribute("qtdAluno");
        
        session.setAttribute("usuario", professor);
        session.setAttribute("qtdSugestoes", qtdSugestoes);
        session.setAttribute("qtdAluno", qtdAluno);
    }
    
    public static void atualizaSessionEsta(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        
        Estagiario estagiario = (Estagiario) req.getSession().getAttribute("usuario");
        estagiario = EstagiarioDao.listaUm(estagiario.getIdEstagiario());
        int qtdAluno = AlunoDao.listarQtd();
        
        session.removeAttribute("usuario");
        session.removeAttribute("qtdAluno");
        
        session.setAttribute("usuario", estagiario);
        session.setAttribute("qtdAluno", qtdAluno);
    }
    
    public static void atualizaSessionNutr(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession();
        
        Nutricionista nutricionista = (Nutricionista) req.getSession().getAttribute("usuario");
        nutricionista = NutricionistaDao.listaUm(nutricionista.getIdNutricionista());
        
        int qtdDietasVenc = DietaDao.listarQtdDieVenc(nutricionista.getIdNutricionista());
        int qtdAluno = AlunoDao.listarQtd();
        
        session.removeAttribute("usuario");
        session.removeAttribute("qtdAluno");
        session.removeAttribute("qtdDietasVenc");
        
        session.setAttribute("usuario", nutricionista);
        session.setAttribute("qtdAluno", qtdAluno);
        session.setAttribute("qtdDietasVenc", qtdDietasVenc);
    }
}
