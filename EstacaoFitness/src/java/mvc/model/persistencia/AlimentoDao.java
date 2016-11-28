package mvc.model.persistencia;

import mvc.model.Alimento;
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
public class AlimentoDao {

    public static int inserir(Alimento a) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO alimento (idAlimento, nome, urlImagem)"
                    + " values (?,?,?)");
            pstm.setInt(1, a.getIdAlimento());
            pstm.setString(2, a.getNome());
            pstm.setString(3, a.getUrlImagem());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Alimento> listar() throws Exception {
        List<Alimento> alimentos = new ArrayList<Alimento>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM alimento");
            alimentos = new ArrayList<Alimento>();

            while (rs.next()) {
                Alimento a;
                a = new Alimento();
                a.setIdAlimento(rs.getInt("idAlimento"));
                a.setNome(rs.getString("nome"));
                a.setUrlImagem(rs.getString("urlImagem"));
                a.setTipoAlimento(TipoAlimentoDao.listaUm(rs.getInt("idTipoAlimentoFK")));
                alimentos.add(a);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return alimentos;
    }

    public static Alimento listaUm(int id) throws Exception {
        Alimento a = new Alimento();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM alimento WHERE idAlimento = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Alimento();
                a.setIdAlimento(rs.getInt("idAlimento"));
                a.setNome(rs.getString("nome"));
                a.setUrlImagem(rs.getString("urlImagem"));
                a.setTipoAlimento(TipoAlimentoDao.listaUm(rs.getInt("idTipoAlimentoFK")));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a;
    }

    public static int alterar(Alimento a) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE alimento SET nome=?, urlImagem=? WHERE idAlimento=?");
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getUrlImagem());

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
            pstm = con.prepareStatement("delete from alimento where idAlimento = ?");
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
