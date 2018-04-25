package mvc.logica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mvc.model.Alimento;
import mvc.model.Aluno;
import mvc.model.Avaliacao;
import mvc.model.Dieta;
import mvc.model.Estagiario;
import mvc.model.Lembrete;
import mvc.model.Nutricionista;
import mvc.model.Professor;
import mvc.model.Recepcionista;
import mvc.model.Sugestao;
import mvc.model.Tipo;
import mvc.model.persistencia.AlimentoDao;
import mvc.model.persistencia.AlunoDao;
import mvc.model.persistencia.AvaliacaoDao;
import mvc.model.persistencia.DietaDao;
import mvc.model.persistencia.EstagiarioDao;
import mvc.model.persistencia.LembreteDao;
import mvc.model.persistencia.NutricionistaDao;
import mvc.model.persistencia.ProfessorDao;
import mvc.model.persistencia.RecepcionistaDao;
import mvc.model.persistencia.SugestaoDao;
import mvc.model.persistencia.TipoDao;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 *
 * @author Natanael
 */
public class LoginLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        HttpSession session = req.getSession(); //obtem a sessao do usuario, caso exista
        
        //instanciando objetos que são usados como usuários
        Aluno aluno = null;
        Recepcionista recepcionista = null;
        Professor professor = null;
        Nutricionista nutricionista = null;
        Estagiario estagiario = null;
        
        int login_form = Integer.parseInt(req.getParameter("matricula")); // Pega a matricula vindo do formulario
        String senha_form = req.getParameter("senha"); //Pega a senha vinda do formulario

        try {
            
            if (AlunoDao.existeAluno(login_form, senha_form) == true){
                aluno = AlunoDao.listaUmMatricula(login_form);
                String proxAvaliacao = AvaliacaoDao.ultimAvaliacao(aluno.getIdAluno());
                Date dataPrim = AvaliacaoDao.ultmAval(aluno.getIdAluno());
                
                Date data = new Date();
                DateTime dataAtual = new DateTime(data);
                DateTime dataAnterior = new DateTime(dataPrim);
                
                int qtdDias = Days.daysBetween(dataAnterior, dataAtual).getDays();
                
                session.setAttribute("usuario", aluno);
                session.setAttribute("proxAvaliacao", proxAvaliacao);
                session.setAttribute("qtdDias", qtdDias);
                return "mvc?logica=LstAlunoPrincipal";
            } 
            else 
            if (RecepcionistaDao.existeRecepcionista(login_form, senha_form) == true){
                recepcionista = RecepcionistaDao.listaUmMatricula(login_form);
                
                //puxando dados do bd
                List<Aluno> alunos = AlunoDao.listarUltimos();
                List<Lembrete> lembretes = LembreteDao.listaUltiRecep(recepcionista.getIdRecepcionista());
                int qtdLembretes = LembreteDao.listaQtdRecep(recepcionista.getIdRecepcionista());
                List<Sugestao> sugestoes = SugestaoDao.listarNova();
                int qtdNovasSugestoes = SugestaoDao.listarQtdNova();
                int qtdUsuarios = RecepcionistaDao.qtdTodosUsu();
                int qtdProfessor = ProfessorDao.listarQtd();
                int qtdRecepcionista = RecepcionistaDao.listarQtd();
                int qtdAluno = AlunoDao.listarQtd();
                int qtdEstagiario = EstagiarioDao.listarQtd();
                int qtdNutricionista = NutricionistaDao.listarQtd();
                
                //guardando no request e session os dados vindouros do bd, será usados na página do recepcionista
                session.setAttribute("usuario", recepcionista);
                req.setAttribute("alunos", alunos);
                req.setAttribute("lembretes", lembretes);
                req.setAttribute("alunAtivos", porcAlunosAtivados());
                req.setAttribute("alunInativos", porcAlunosDesativados());
                req.setAttribute("qtdProfessor", qtdProfessor);
                req.setAttribute("qtdRecepcionista", qtdRecepcionista);
                req.setAttribute("qtdAluno", qtdAluno);
                req.setAttribute("qtdEstagiario", qtdEstagiario);
                req.setAttribute("qtdNutricionista", qtdNutricionista);
                
                session.setAttribute("qtdLembretes", qtdLembretes);
                session.setAttribute("novasSugestoes", sugestoes);
                session.setAttribute("qtdNovasSugestoes", qtdNovasSugestoes);
                session.setAttribute("qtdUsuarios", qtdUsuarios);
                
                return "mvc?logica=LstRecepcionistaPrincipal";
                
            } else 
            if (ProfessorDao.existeProfessor(login_form, senha_form)){
                
                professor = ProfessorDao.listaUmMatricula(login_form);
                List<Sugestao> sugestoes = SugestaoDao.listaTp("Professor");
                List<Aluno> alunos = AlunoDao.listar();
                List<Tipo> tipos = TipoDao.listar();
                List<Avaliacao> avaliacoes = AvaliacaoDao.listar();
                
                int qtdSugestoes = SugestaoDao.listaQtdTp("Professor");
                int qtdAluno = AlunoDao.listarQtd();
                
                session.setAttribute("usuario", professor);
                session.setAttribute("qtdSugestoes", qtdSugestoes);
                session.setAttribute("qtdAluno", qtdAluno);
                req.setAttribute("avaliacoes", avaliacoes);
                req.setAttribute("sugestoes", sugestoes);
                req.setAttribute("alunos", alunos);
                req.setAttribute("tipos", tipos);
                
                return "mvc?logica=LstProfessorPrincipal";
            } else
            if (NutricionistaDao.existeNutricionista(login_form, senha_form)){
                nutricionista = NutricionistaDao.listaUmMatricula(login_form);
                List<Dieta> dietasVenc = DietaDao.listarDieVenc(nutricionista.getIdNutricionista());
                List<Aluno> alunos = AlunoDao.listar();
                List<Alimento> alimentos = AlimentoDao.listar();
                
                int qtdDietasVenc = DietaDao.listarQtdDieVenc(nutricionista.getIdNutricionista());
                int qtdAluno = AlunoDao.listarQtd();
                
                session.setAttribute("usuario", nutricionista);
                session.setAttribute("qtdAluno", qtdAluno);
                session.setAttribute("qtdDietasVenc", qtdDietasVenc);
                
                req.setAttribute("dietasVenc", dietasVenc);
                req.setAttribute("alunos", alunos);
                req.setAttribute("alimentos", alimentos);
                
                return "mvc?logica=LstNutricionistaPrincipal";
            }else if (EstagiarioDao.existeEstagiario(login_form, senha_form)){
                estagiario = EstagiarioDao.listaUmMatricula(login_form);
                List<Aluno> alunos = AlunoDao.listar();
                List<Tipo> tipos = TipoDao.listar();
                List<Professor> professores = ProfessorDao.listar();
                
                int qtdSugestoes = SugestaoDao.listaQtdTp("Professor");
                int qtdAluno = AlunoDao.listarQtd();
                
                session.setAttribute("usuario", estagiario);
                session.setAttribute("qtdSugestoes", qtdSugestoes);
                session.setAttribute("qtdAluno", qtdAluno);
                req.setAttribute("alunos", alunos);
                req.setAttribute("tipos", tipos);
                req.setAttribute("professores", professores);
                
                return "mvc?logica=LstEstagiarioPrincipal";
            }
            
        } catch (Exception e) {
            e.getMessage();
        } 
            
        return "mvc?logica=LoginInvalidaLogica";
    
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
