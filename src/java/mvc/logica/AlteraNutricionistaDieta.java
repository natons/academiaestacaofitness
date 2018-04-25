/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Alimento;
import mvc.model.Aluno;
import mvc.model.Dieta;
import mvc.model.Nutricionista;
import mvc.model.persistencia.AlimentoDietaDao;
import mvc.model.persistencia.DietaDao;

/**
 *
 * @author Natanael
 */
public class AlteraNutricionistaDieta implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            
            int idAluno = Integer.parseInt(req.getParameter("idAluno"));
            int idNutricionista = Integer.parseInt(req.getParameter("idNutricionista"));
            
            DietaDao.deletarAlun(idAluno);
            
            Aluno aluno = new Aluno();
            aluno.setIdAluno(idAluno);
            
            
            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setIdNutricionista(idNutricionista);
            
            
            
            Dieta dieta1 = new Dieta();
            dieta1.setAluno(aluno);

            dieta1.setNutricionista(nutricionista);

            dieta1.setDescricao(req.getParameter("descricao"));
            
            
            //validade
            java.util.Date d = new java.util.Date();

            String MyDate = req.getParameter("validade");
            SimpleDateFormat parseDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            d = parseDate.parse(MyDate);

            java.sql.Date dt = new java.sql.Date(d.getTime());
            dieta1.setValidade(dt);
            //////
            
            DietaDao.inserir(dieta1);
            
            //Café da manhã
            List<Alimento> listAlimentos1 = new ArrayList<Alimento>();
            String[] alimentos1 = req.getParameterValues("cafedamanha");
            if (alimentos1 != null) {
                for (int i = 0; i < alimentos1.length; i++) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(Integer.parseInt(alimentos1[i]));
                    listAlimentos1.add(alimento);
                }
            }
            
            AlimentoDietaDao.inserirPorDieta(DietaDao.restauraId(), listAlimentos1);
            
            //Almoço
            List<Alimento> listAlimentos2 = new ArrayList<Alimento>();
            String[] alimentos2 = req.getParameterValues("almoco");
            if (alimentos2 != null) {
                for (int i = 0; i < alimentos2.length; i++) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(Integer.parseInt(alimentos2[i]));
                    listAlimentos2.add(alimento);
                }
            }
            
            AlimentoDietaDao.inserirPorDieta(DietaDao.restauraId(), listAlimentos2);
            
            //Café da Tarde
            List<Alimento> listAlimentos3 = new ArrayList<Alimento>();
            String[] alimentos3 = req.getParameterValues("cafedatarde");
            if (alimentos3 != null) {
                for (int i = 0; i < alimentos3.length; i++) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(Integer.parseInt(alimentos3[i]));
                    listAlimentos3.add(alimento);
                }
            }
            
            AlimentoDietaDao.inserirPorDieta(DietaDao.restauraId(), listAlimentos3);
            
            //Janta
            List<Alimento> listAlimentos4 = new ArrayList<Alimento>();
            String[] alimentos4 = req.getParameterValues("janta");
            if (alimentos4 != null) {
                for (int i = 0; i < alimentos4.length; i++) {
                    Alimento alimento = new Alimento();
                    alimento.setIdAlimento(Integer.parseInt(alimentos4[i]));
                    listAlimentos4.add(alimento);
                }
            }
            
            AlimentoDietaDao.inserirPorDieta(DietaDao.restauraId(), listAlimentos4);
            
        }
        
        req.setAttribute("mensagem", "Exercícios cadastrados com sucesso!");
        
        return "mvc?logica=LstNutricionistaPrincipal";
    }
    
}
