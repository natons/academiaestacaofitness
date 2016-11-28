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
import mvc.model.Professor;
import mvc.model.Telefone;
import mvc.model.persistencia.ProfessorDao;

/**
 *
 * @author Luciana
 */
public class AlteraProfessorLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Professor professor = new Professor();
        
        professor.setMatricula(Integer.parseInt(req.getParameter("matricula")));
        professor.setNome(req.getParameter("nome"));
        professor.setCpf(req.getParameter("cpf"));
                
        professor.setEndereco(req.getParameter("endereco"));
        String status = (String)req.getParameter("status");
        professor.setStatus(status);
        
        professor.setSenha(req.getParameter("senha"));

        List<Telefone> tel = new ArrayList<Telefone>();
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idProfessor");
        switch (op){
            case "":
                professor.setUrlFoto("painel/img/foto/sem-foto.jpg");
                Telefone t = new Telefone();
                    t.setNumero(req.getParameter("telefone1"));
                Telefone t2 = new Telefone();
                    t2.setNumero(req.getParameter("telefone2"));
                
                tel.add(t);
                tel.add(t2);
                professor.setTelefones(tel);
                
                ProfessorDao.inserir(professor);
                
                req.setAttribute("mensagem", "Professor criado com Sucesso");
                break;
            
            default:
                
                int cont = Integer.parseInt(req.getParameter("contador"));
                
                for (int i = 1; i <= cont; i++) {
                    Telefone t1 = new Telefone();
                    t1.setNumero(req.getParameter("telefone" + i));
                    t1.setIdTelefone(Integer.parseInt(req.getParameter("id" + i)));
                    tel.add(t1);
                }
                professor.setTelefones(tel);
                
                
                professor.setIdProfessor(Integer.parseInt(req.getParameter("idProfessor")));
                ProfessorDao.alterar(professor);
                
                req.setAttribute("mensagem", "Professor Alterado com Sucesso");
                break;
        }
        
        
        
        return "mvc?logica=ListaProfessorLogica";
    }
}
