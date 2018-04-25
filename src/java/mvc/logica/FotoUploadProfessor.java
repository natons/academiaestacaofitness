/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.model.persistencia.ProfessorDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Luciana
 */
public class FotoUploadProfessor implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception{
        
        int id = Integer.parseInt(req.getParameter("idProfessor"));

        @SuppressWarnings("deprecation")

        // AQUI VERIFICO SE A REQUISIÇÃO É MULTIPART/FORM-DATA NO QUAL FOI DEFINIDO NO FORM HTML
        boolean isMultipart = FileUpload.isMultipartContent(req);
        String nomeImagem = "painel/img/foto/";

        // CASO SEJA UM FORM MULTIPART/FORM-DATA         
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                List<FileItem> items = upload.parseRequest(req);
                Iterator<FileItem> it = items.iterator();

                while (it.hasNext()) {
                    FileItem item = (FileItem) it.next();

                  // AQUI EU VERIFICO SE É UM CAMPO NORMAL <input type> OU SE É UM CAMPO TIPO ARQUIVO <input type="file">
                    // CASO SEJA A 2º OPÇÃO EU CHAMO O MÉTODO QUE IRÁ SALVAR A IMAGEM NO DIRETÓRIO
                    if (!item.isFormField()) {
                        if (item.getName().length() > 0) {

                            // AQUI EU PEGO O NOME DA IMAGEM COM A EXTENSÃO DELA
                            nomeImagem = nomeImagem + item.getName();

                            // AQUI CHAMO UM MÉTODO STATIC DA CLASSE FileUploadUtils
                            FileUploadUtils.inserImagemDiretorio(item);
                        }
                    }
                    
                    
                }
                
                ProfessorDao.alterarFotoUrl(nomeImagem, id);
                
                }catch (Exception e) {
           }
        }
        
        
        return "mvc?logica=LstProfessorPerfil&id="+id;
    }   
}
