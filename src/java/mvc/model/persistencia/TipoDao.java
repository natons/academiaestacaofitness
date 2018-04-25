package mvc.model.persistencia;

import mvc.model.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class TipoDao {

    public static int inserir(Tipo t) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO tipo (nome, urlImagem)"
                    + " values (?,?)");
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getUrlImagem());
            ret = pstm.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Tipo> listar() throws Exception {
        List<Tipo> tipos = new ArrayList<Tipo>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM tipo");
            tipos = new ArrayList<Tipo>();

            while (rs.next()) {
                Tipo t;
                t = new Tipo();
                t.setIdTipo(rs.getInt("idTipo"));
                t.setNome(rs.getString("nome"));
                t.setUrlImagem(rs.getString("urlImagem"));
                tipos.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return tipos;
    }

    public static Tipo listaUm(int id) throws Exception {
        Tipo t = new Tipo();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM tipo WHERE idTipo = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                t = new Tipo();
                t.setIdTipo(rs.getInt("idTipo"));
                t.setNome(rs.getString("nome"));
                t.setUrlImagem(rs.getString("urlImagem"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return t;
    }

    public static int alterar(Tipo t) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE tipo SET nome=?, urlImagem=? WHERE idTipo=?");
            pstm.setString(1, t.getNome());
            pstm.setString(2, t.getUrlImagem());

            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int deletar(int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("delete from tipo where idTipo = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
}
