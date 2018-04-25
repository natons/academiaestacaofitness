/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import mvc.model.Aluno;
import mvc.model.Telefone;
import mvc.model.persistencia.AlunoDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Natanael
 */
public class AlteraAlunoLogica implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Aluno aluno = new Aluno();
        
        
        aluno.setNome(req.getParameter("nome"));
        aluno.setPeso(Double.parseDouble(req.getParameter("peso")));
        aluno.setMatricula(Integer.parseInt(req.getParameter("matricula")));
                
        //Recebendo Data e convertendo para gravar no bd
        java.util.Date d = new java.util.Date();  
        
        String MyDate = req.getParameter("dataNascimento");
        SimpleDateFormat parseDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
        d = parseDate.parse(MyDate);
        
        java.sql.Date dt = new java.sql.Date (d.getTime());
        aluno.setDataNascimento(dt);
        //fim da conversão
        
        String status = (String)req.getParameter("status");
        aluno.setStatus(status);
        aluno.setEndereco(req.getParameter("endereco"));
        aluno.setSenha(req.getParameter("senha"));
        

        List<Telefone> tel = new ArrayList<>();
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idAluno");
        switch (op){
            case "":
                aluno.setUrlFoto("painel/img/foto/sem-foto.jpg");
                
                Telefone t = new Telefone();
                    t.setNumero(req.getParameter("telefone1"));
                Telefone t2 = new Telefone();
                    t2.setNumero(req.getParameter("telefone2"));
                
                tel.add(t);
                tel.add(t2);
                aluno.setTelefones(tel);
                
                AlunoDao.inserir(aluno);
                
                req.setAttribute("mensagem", "Aluno criado com Sucesso");
                break;
            
            default:
                int cont = Integer.parseInt(req.getParameter("contador"));
                
                for (int i = 1; i <= cont; i++) {
                    Telefone t1 = new Telefone();
                    t1.setNumero(req.getParameter("telefone" + i));
                    t1.setIdTelefone(Integer.parseInt(req.getParameter("id" + i)));
                    tel.add(t1);
                }
                aluno.setTelefones(tel);
                
                
                aluno.setIdAluno(Integer.parseInt(req.getParameter("idAluno")));
                AlunoDao.alterar(aluno);
                
                req.setAttribute("mensagem", "Aluno Alterado com Sucesso");
                break;
        }
        
        
        
        return "mvc?logica=ListaAlunoLogica";
    }
}
