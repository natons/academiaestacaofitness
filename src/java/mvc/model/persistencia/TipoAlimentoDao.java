/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import mvc.model.TipoAlimento;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Natanael
 */
public class TipoAlimentoDao {

    public static TipoAlimento listaUm(int id) throws Exception {
        TipoAlimento ta = new TipoAlimento();
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM tipoalimento WHERE idTipoAlimento = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                ta = new TipoAlimento();
                ta.setIdTipoAlimento(id);
                ta.setNome(rs.getString("tipo"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ta;
    }
    
}
