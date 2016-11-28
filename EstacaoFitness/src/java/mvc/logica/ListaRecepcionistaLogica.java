package mvc.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.Recepcionista;
import mvc.model.persistencia.RecepcionistaDao;

/**
 *
 * @author Luciana
 */
public class ListaRecepcionistaLogica implements Logica{
    
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res)
        throws Exception {
        if (req.getSession().getAttribute("usuario") == null) {
            return "mvc?logica=LoginInvalidaLogica";
        } else {
            
            AtualizaSession.atualizaSessionRecep(req, res);
            
            // Monta a lista de Recepcionistas
            List<Recepcionista> recepcionistas = RecepcionistaDao.listar();

            // Guarda a lista no request
            req.setAttribute("recepcionistas", recepcionistas);

            String mensagem = (String) req.getAttribute("mensagem");

            if (mensagem != null) {
                req.setAttribute("mensagem", mensagem);
            }
        }
      return "/WEB-INF/jsp/recepcionistas.jsp";
  }
}

    