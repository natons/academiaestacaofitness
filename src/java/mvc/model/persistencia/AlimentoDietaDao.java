package mvc.model.persistencia;

import mvc.model.Alimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mvc.model.TipoAlimento;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class AlimentoDietaDao {

    public static int inserirPorDieta(int id, List<Alimento> alimentos) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = Conexao.criaConexao();
            pstm = cn.prepareStatement(
                    "INSERT INTO alimentodieta "
                    + "(idDietaFK, idAlimentoFK) VALUES (?, ?)");
            pstm.setInt(1, id);
            for (Alimento a : alimentos) {
                pstm.setInt(2, a.getIdAlimento());
                ret = pstm.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }

    public static List<Alimento> listarPorDieta(int id) throws Exception {
        List<Alimento> alimentos = new ArrayList<Alimento>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cn = Conexao.criaConexao();
            pstm = cn.prepareStatement(
                    "SELECT * FROM alimento p INNER JOIN "
                    + "alimentodieta ep ON p.idAlimento = ep.idAlimentoFK "
                    + "WHERE ep.idDietaFK = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            alimentos = new ArrayList<Alimento>();
            while (rs.next()) {
                Alimento a = new Alimento();
                a.setIdAlimento(rs.getInt("idAlimento"));
                a.setNome(rs.getString("nome"));
                a.setUrlImagem(rs.getString("urlImagem"));

                int idTipoAlimento = rs.getInt("idTipoAlimentoFK");

                TipoAlimento ta = TipoAlimentoDao.listaUm(idTipoAlimento);

                a.setTipoAlimento(ta);
                alimentos.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(cn, pstm, rs);
        }
        return alimentos;
    }

    public static int alterarPorDieta(int id, int idAlimento, int novoIdAlimento) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;

        try {
            cn = Conexao.criaConexao();
            pstm = cn.prepareStatement(
                    "UPDATE alimentodieta SET"
                    + " idAlimentoFK = ? "
                    + " WHERE idDietaFK = ? "
                    + " AND idAlimentoFK = ?");
            pstm.setInt(1, novoIdAlimento);
            pstm.setInt(2, id);
            pstm.setInt(3, idAlimento);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally {
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }

    public static int deletarPorDieta(int id, int idAlimento) throws Exception {
        int ret = 0;
        Connection cn = null;
        PreparedStatement pstm = null;

        try {
            cn = Conexao.criaConexao();
            pstm = cn.prepareStatement(
                    "DELETE FROM alimentodieta WHERE idDietaFK = ?"
                    + " and idAlimentoFK = ?");
            pstm.setInt(1, id);
            pstm.setInt(2, idAlimento);
            ret = pstm.executeUpdate();
            cn.close();

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
        } finally{
            Conexao.closeConnection(cn, pstm);
        }
        return ret;
    }

}
