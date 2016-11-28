package mvc.model.persistencia;

import mvc.model.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class ExercicioTipoDao {

    public static int inserirPorExercicio(int id, List<Tipo> tipos) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;

        try {
            cn = Conexao.criaConexao();
            pstm = cn.prepareStatement(
                    "INSERT INTO exerciciotipo "
                    + "(idExercicioFK, idTipoFK) VALUES (?, ?)");
            pstm.setInt(1, id);
            for (Tipo t : tipos) {
                pstm.setInt(2, t.getIdTipo());
                ret = pstm.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally{
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }

    public static List<Tipo> listarPorExercicio(int id) throws Exception {
        List<Tipo> tipos = new ArrayList<Tipo>();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
             cn = Conexao.criaConexao();
             pstm = cn.prepareStatement(
                    "SELECT * FROM tipo p INNER JOIN "
                    + "exerciciotipo ep ON p.idTipo = ep.idTipoFK "
                    + "WHERE ep.idExercicioFK = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            tipos = new ArrayList<Tipo>();
            while (rs.next()) {
                Tipo t = new Tipo();
                t.setIdTipo(rs.getInt("idTipo"));
                t.setNome(rs.getString("nome"));
                t.setUrlImagem(rs.getString("urlImagem"));

                tipos.add(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally{
            Conexao.closeConnection(cn, pstm);
        }
        return tipos;
    }

    public static int alterarPorExercicio(int id, int idTipo, int novoIdTipo) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        
        try {
             cn = Conexao.criaConexao();
             pstm = cn.prepareStatement(
                    "UPDATE tipoexercicio SET"
                    + " idTipoFK = ? "
                    + " WHERE idExercicioFK = ? "
                    + " AND idTipoFK = ?");
            pstm.setInt(1, novoIdTipo);
            pstm.setInt(2, id);
            pstm.setInt(3, idTipo);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally{
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }

    public static int deletarPorExercicio(int id, int idTipo) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        
        try {
             cn = Conexao.criaConexao();
             pstm = cn.prepareStatement(
                    "DELETE FROM tipoexercicio WHERE idExercicioFK = ?"
                    + " and idTipoFK = ?");
            pstm.setInt(1, id);
            pstm.setInt(2, idTipo);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally{
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }
}
