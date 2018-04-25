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
import mvc.model.Estagiario;
import mvc.model.Telefone;
import mvc.model.persistencia.EstagiarioDao;

/**
 *
 * @author Luciana
 */
public class AlteraEstagiarioLogica implements Logica{
 
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Estagiario estagiario = new Estagiario();
        
        estagiario.setMatricula(Integer.parseInt(req.getParameter("matricula")));
        estagiario.setNome(req.getParameter("nome"));
        estagiario.setCpf(req.getParameter("cpf"));
                
        estagiario.setEndereco(req.getParameter("endereco"));
        String status = (String)req.getParameter("status");
        estagiario.setStatus(status);
        
        estagiario.setSenha(req.getParameter("senha"));

        List<Telefone> tel = new ArrayList<>();
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idEstagiario");
        switch (op){
            case "":
                
                estagiario.setUrlFoto("painel/img/foto/sem-foto.jpg");
                
                Telefone t = new Telefone();
                    t.setNumero(req.getParameter("telefone1"));
                Telefone t2 = new Telefone();
                    t2.setNumero(req.getParameter("telefone2"));
                
                tel.add(t);
                tel.add(t2);
                estagiario.setTelefones(tel);
                
                EstagiarioDao.inserir(estagiario);
                
                req.setAttribute("mensagem", "Estagiário criado com Sucesso");
                break;
            
            default:
                
                int cont = Integer.parseInt(req.getParameter("contador"));
                
                for (int i = 1; i <= cont; i++) {
                    Telefone t1 = new Telefone();
                    t1.setNumero(req.getParameter("telefone" + i));
                    t1.setIdTelefone(Integer.parseInt(req.getParameter("id" + i)));
                    tel.add(t1);
                }
                estagiario.setTelefones(tel);
                
                
                estagiario.setIdEstagiario(Integer.parseInt(req.getParameter("idEstagiario")));
                EstagiarioDao.alterar(estagiario);
                
                req.setAttribute("mensagem", "Estagiário Alterado com Sucesso");
                break;
        }
        
        
        
        return "mvc?logica=ListaEstagiarioLogica";
    }
}

    