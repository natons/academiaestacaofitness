/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Natanael
 */
public interface Logica {
    
    /**
     *
     * @param req
     * @param res
     * @return
     * @throws Exception
     */
    String executa(HttpServletRequest req,
            HttpServletResponse res) throws Exception;
    
    
}
