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
import mvc.model.Nutricionista;
import mvc.model.Telefone;
import mvc.model.persistencia.NutricionistaDao;

/**
 *
 * @author Luciana
 */
public class AlteraNutricionistaLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Nutricionista nutricionista = new Nutricionista();
        
        nutricionista.setMatricula(Integer.parseInt(req.getParameter("matricula")));
        nutricionista.setNome(req.getParameter("nome"));
        nutricionista.setCpf(req.getParameter("cpf"));
                
        nutricionista.setEndereco(req.getParameter("endereco"));
        String status = (String)req.getParameter("status");
        nutricionista.setStatus(status);
        
        nutricionista.setSenha(req.getParameter("senha"));

        List<Telefone> tel = new ArrayList<>();
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idNutricionista");
        switch (op){
            case "":
                nutricionista.setUrlFoto("painel/img/foto/sem-foto.jpg");
                Telefone t = new Telefone();
                    t.setNumero(req.getParameter("telefone1"));
                Telefone t2 = new Telefone();
                    t2.setNumero(req.getParameter("telefone2"));
                
                tel.add(t);
                tel.add(t2);
                nutricionista.setTelefones(tel);
                
                NutricionistaDao.inserir(nutricionista);
                
                req.setAttribute("mensagem", "Nutricionista criado com Sucesso");
                break;
            
            default:
                
                int cont = Integer.parseInt(req.getParameter("contador"));
                
                for (int i = 1; i <= cont; i++) {
                    Telefone t1 = new Telefone();
                    t1.setNumero(req.getParameter("telefone" + i));
                    t1.setIdTelefone(Integer.parseInt(req.getParameter("id" + i)));
                    tel.add(t1);
                }
                nutricionista.setTelefones(tel);
                
                
                nutricionista.setIdNutricionista(Integer.parseInt(req.getParameter("idNutricionista")));
                NutricionistaDao.alterar(nutricionista);
                
                req.setAttribute("mensagem", "Nutricionista Alterado com Sucesso");
                break;
        }
        
        return "mvc?logica=ListaNutricionistaLogica";
    }
}
