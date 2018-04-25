/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Lembrete;
import mvc.model.Recepcionista;
import mvc.model.persistencia.LembreteDao;

/**
 *
 * @author Natanael
 */
public class AlteraLembreteLogica implements Logica{
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Lembrete lembrete = new Lembrete();
        
        lembrete.setTitulo(req.getParameter("titulo"));
        lembrete.setCorpo(req.getParameter("corpo"));
        
        Recepcionista recep = new Recepcionista();
        recep.setIdRecepcionista(Integer.parseInt(req.getParameter("idRecepcionista")));
        lembrete.setRecepcionista(recep);
        
        
        //Verificando alteração ou Inserçao
        String op = req.getParameter("idLembrete");
        switch (op){
            case "":
                
                LembreteDao.inserir(lembrete);
                
                req.setAttribute("mensagem", "Lembrete criado com Sucesso");
                break;
            
            default:
                
                lembrete.setIdLembrete(Integer.parseInt(req.getParameter("idLembrete")));
                LembreteDao.alterar(lembrete);
                
                req.setAttribute("mensagem", "Lembrete Alterado com Sucesso");
                break;
        }
        
        
        
        return "mvc?logica=ListaLembreteLogica&id="+recep.getIdRecepcionista();
    }
}
