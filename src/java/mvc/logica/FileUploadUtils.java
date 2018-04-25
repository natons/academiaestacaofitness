/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author Natanael
 */
// Classe FileUploadUtils que le a imagem e salva em um diretório

public class FileUploadUtils {

        // CAMINHO DO DIRETÓRIO ONDE SALVa A IMAGEM
    private static final String DIRETORIO     = "E:\\Documentos\\NetBeansProjects\\EstacaoFitness\\web\\painel\\img\\foto";

    public static void inserImagemDiretorio(FileItem item) throws Exception{

        try {
            File diretorio  = new File(DIRETORIO);
            if(!diretorio.exists())
                diretorio.mkdir();

            String fileName = item.getName();
            String arq[] = fileName.split("\\\\");
            for (int i = 0; i < arq.length; i++) {
                fileName = arq[i];
            }

            File file = new File(diretorio,fileName);
            try (FileOutputStream out = new FileOutputStream(file)) {
                InputStream in = item.getInputStream();
                
                // Imagens de até 2 megas !!
                byte[] buffer = new byte[1024 * 8];
                int nLidos;
                while ((nLidos = in.read(buffer)) >= 0) {
                    out.write(buffer, 0, nLidos);
                }
                
                out.flush();
            }

        } catch (Exception e) {
            throw new Exception("Erro ao carregar imagem para o diretorio !!\n "
                    + "Error : "      + e.getMessage() 
                    + "\nCausa : " + e.getCause());
        }

    }
}
