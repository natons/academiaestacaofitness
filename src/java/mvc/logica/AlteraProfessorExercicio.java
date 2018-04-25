/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Aluno;
import mvc.model.Exercicio;
import mvc.model.Professor;
import mvc.model.Tipo;
import mvc.model.persistencia.ExercicioDao;
import mvc.model.persistencia.ExercicioTipoDao;

/**
 *
 * @author Natanael
 */
public class AlteraProfessorExercicio implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            int idAluno = Integer.parseInt(req.getParameter("idAluno"));
            int idProfessor = Integer.parseInt(req.getParameter("idProfessor"));
            
            ExercicioDao.deletarTodos(idAluno);
            
            Aluno aluno = new Aluno();
            aluno.setIdAluno(idAluno);
            
            
            Professor professor = new Professor();
            professor.setIdProfessor(idProfessor);
            
            
            //Exercício 1
            Exercicio exercicio1 = new Exercicio();
            exercicio1.setAluno(aluno);

            exercicio1.setProfessor(professor);

            exercicio1.setDescricao(req.getParameter("descricao1"));

            ExercicioDao.inserir(exercicio1);

            List<Tipo> listTipos1 = new ArrayList<Tipo>();
            String[] tipos1 = req.getParameterValues("Exercicio1Tipo");
            if (tipos1 != null) {
                for (int i = 0; i < tipos1.length; i++) {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(Integer.parseInt(tipos1[i]));
                    listTipos1.add(tipo);
                }
            }
            
            ExercicioTipoDao.inserirPorExercicio(ExercicioDao.restauraId(), listTipos1);
            
            //Exercício 2
            Exercicio exercicio2 = new Exercicio();
            exercicio2.setAluno(aluno);

            exercicio2.setProfessor(professor);

            exercicio2.setDescricao(req.getParameter("descricao2"));
            ExercicioDao.inserir(exercicio2);

            List<Tipo> listTipos2 = new ArrayList<Tipo>();
            String[] tipos2 = req.getParameterValues("Exercicio2Tipo");
            if (tipos2 != null) {
                for (int i = 0; i < tipos2.length; i++) {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(Integer.parseInt(tipos2[i]));
                    listTipos2.add(tipo);
                }
            }
            
            ExercicioTipoDao.inserirPorExercicio(ExercicioDao.restauraId(), listTipos2);
            
            //Exercício 3
            Exercicio exercicio3 = new Exercicio();
            exercicio3.setAluno(aluno);

            exercicio3.setProfessor(professor);

            exercicio3.setDescricao(req.getParameter("descricao3"));
            ExercicioDao.inserir(exercicio3);

            List<Tipo> listTipos3 = new ArrayList<Tipo>();
            String[] tipos3 = req.getParameterValues("Exercicio3Tipo");
            if (tipos3 != null) {
                for (int i = 0; i < tipos3.length; i++) {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(Integer.parseInt(tipos3[i]));
                    listTipos3.add(tipo);
                }
            }
            
            ExercicioTipoDao.inserirPorExercicio(ExercicioDao.restauraId(), listTipos3);
            
            //Exercício 3
            Exercicio exercicio4 = new Exercicio();
            exercicio4.setAluno(aluno);

            exercicio4.setProfessor(professor);

            exercicio4.setDescricao(req.getParameter("descricao4"));
            ExercicioDao.inserir(exercicio4);

            List<Tipo> listTipos4 = new ArrayList<Tipo>();
            String[] tipos4 = req.getParameterValues("Exercicio4Tipo");
            if (tipos4 != null) {
                for (int i = 0; i < tipos4.length; i++) {
                    Tipo tipo = new Tipo();
                    tipo.setIdTipo(Integer.parseInt(tipos4[i]));
                    listTipos4.add(tipo);
                }
            }
            
            ExercicioTipoDao.inserirPorExercicio(ExercicioDao.restauraId(), listTipos4);
        }
        
        req.setAttribute("mensagem", "Exercícios cadastrados com sucesso!");
        
        return "mvc?logica=LstProfessorPrincipal";
    }
    
}
