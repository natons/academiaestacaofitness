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
import mvc.model.Sugestao;
import mvc.model.persistencia.EstagiarioDao;
import mvc.model.persistencia.SugestaoDao;

/**
 *
 * @author Natanael
 */
public class AlteraAlunoSugestao implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Sugestao sugestao = new Sugestao();
        
        sugestao.setDescricao(req.getParameter("descricao"));
        sugestao.setAreaSugestao(req.getParameter("areaSugestao"));
        
        Aluno aluno = new Aluno();
        aluno.setIdAluno(Integer.parseInt(req.getParameter("idAlunoFK")));
        
        sugestao.setAluno(aluno);
        
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idSugestao");
        switch (op){
            case "":
                
                SugestaoDao.inserir(sugestao);
                
                req.setAttribute("mensagem", "Sugestão criada com Sucesso");
                break;
            
            default:
                
                sugestao.setIdSugestao(Integer.parseInt(req.getParameter("idSugestao")));
                SugestaoDao.alterar(sugestao);
                
                req.setAttribute("mensagem", "Sugestão Alterado com Sucesso");
                break;
        }
        
        
        
        return "mvc?logica=LstAlunoSugestao&id="+aluno.getIdAluno();
    }
    
}
