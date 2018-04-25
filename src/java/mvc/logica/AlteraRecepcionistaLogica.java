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
import mvc.model.Recepcionista;
import mvc.model.Telefone;
import mvc.model.persistencia.RecepcionistaDao;

/**
 *
 * @author Luciana
 */
public class AlteraRecepcionistaLogica implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        Recepcionista recepcionista = new Recepcionista();

        recepcionista.setNome(req.getParameter("nome"));
        recepcionista.setCpf(req.getParameter("cpf"));

        recepcionista.setEndereco(req.getParameter("endereco"));
        String status = (String) req.getParameter("status");
        recepcionista.setStatus(status);
        
        recepcionista.setSenha(req.getParameter("senha"));

        List<Telefone> tel = new ArrayList<Telefone>();

        //Verificando alteração ou Inserçao
        String op = req.getParameter("idRecepcionista");
        switch (op) 
        {
            case "":
                recepcionista.setUrlFoto("painel/img/foto/sem-foto.jpg");
                Telefone t = new Telefone();
                t.setNumero(req.getParameter("telefone1"));
                Telefone t2 = new Telefone();
                t2.setNumero(req.getParameter("telefone2"));

                tel.add(t);
                tel.add(t2);
                recepcionista.setTelefones(tel);

                RecepcionistaDao.inserir(recepcionista);

                req.setAttribute("mensagem", "Recepcionista criado com Sucesso");
                break;

            default:

                int cont = Integer.parseInt(req.getParameter("contador"));

                for (int i = 1; i <= cont; i++) {
                    Telefone t1 = new Telefone();
                    t1.setNumero(req.getParameter("telefone" + i));
                    t1.setIdTelefone(Integer.parseInt(req.getParameter("id" + i)));
                    tel.add(t1);
                }
                recepcionista.setTelefones(tel);

                recepcionista.setIdRecepcionista(Integer.parseInt(req.getParameter("idRecepcionista")));
                RecepcionistaDao.alterar(recepcionista);

                req.setAttribute("mensagem", "Recepcionista Alterado com Sucesso");
                break;
        }

        return "mvc?logica=ListaRecepcionistaLogica";
    }
}
