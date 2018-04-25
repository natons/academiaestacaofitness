package mvc.model.persistencia;

import mvc.model.Sugestao;
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
public class SugestaoDao extends Conexao {

    public static int inserir(Sugestao s) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO sugestao (data, descricao, areaSugestao, idAlunoFK)"
                    + " values (CURDATE(),?,?,?)");
            pstm.setString(1, s.getDescricao());
            pstm.setString(2, s.getAreaSugestao());
            pstm.setInt(3, s.getAluno().getIdAluno());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Sugestao> listar() throws Exception {
        List<Sugestao> sugestoes = new ArrayList<Sugestao>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM sugestao");
            sugestoes = new ArrayList<Sugestao>();

            while (rs.next()) {
                Sugestao s;
                s = new Sugestao();
                s.setIdSugestao(rs.getInt("idSugestao"));
                s.setAreaSugestao(rs.getString("areaSugestao"));
                s.setDescricao(rs.getString("descricao"));
                s.setData(rs.getDate("data"));
                sugestoes.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return sugestoes;
    }

    public static Sugestao listaUm(int id) throws Exception {
        Sugestao s = new Sugestao();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM sugestao WHERE idSugestao = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                s = new Sugestao();
                s.setIdSugestao(rs.getInt("idSugestao"));
                s.getAluno().setNome(rs.getString("nome"));
                s.setData(rs.getDate("data"));
                s.setDescricao(rs.getString("descricao"));
                s.setAreaSugestao(rs.getString("areaSugestao"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return s;
    }

    public static List<Sugestao> listaUmAlu(int id) throws Exception {
        List<Sugestao> sugestoes = new ArrayList<Sugestao>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM sugestao WHERE idAlunoFK = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Sugestao s;
                s = new Sugestao();
                s.setIdSugestao(rs.getInt("idSugestao"));
                s.setAreaSugestao(rs.getString("areaSugestao"));
                s.setDescricao(rs.getString("descricao"));
                s.setData(rs.getDate("data"));
                sugestoes.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return sugestoes;
    }
    
    public static List<Sugestao> listaTp(String areaSugestao) throws Exception {
        List<Sugestao> sugestoes = new ArrayList<Sugestao>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM sugestao WHERE areaSugestao = ? AND data = CURDATE()");
            pstm.setString(1, areaSugestao);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Sugestao s;
                s = new Sugestao();
                s.setIdSugestao(rs.getInt("idSugestao"));
                s.setAreaSugestao(rs.getString("areaSugestao"));
                s.setDescricao(rs.getString("descricao"));
                s.setData(rs.getDate("data"));
                sugestoes.add(s);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return sugestoes;
    }
    
    public static int listaQtdTp(String areaSugestao) throws Exception {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int cont = 0;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT COUNT(idSugestao) FROM sugestao WHERE areaSugestao = ?");
            pstm.setString(1, areaSugestao);
            rs = pstm.executeQuery();
            while (rs.next()) {
                cont = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return cont;
    }

    public static int alterar(Sugestao s) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE sugestao SET decricao=?, areaSugestao=?, idAlunoFK=? WHERE idSugestao=?");
            pstm.setString(1, s.getDescricao());
            pstm.setString(2, s.getAreaSugestao());
            pstm.setInt(3, s.getAluno().getIdAluno());

            ret = pstm.executeUpdate();
            con.close();

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
            pstm = con.prepareStatement("delete from sugestao where idSugestao = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Sugestao> listarNova() throws Exception {
        List<Sugestao> sugestoes = new ArrayList<Sugestao>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM sugestao WHERE data = CURDATE()");
            sugestoes = new ArrayList<Sugestao>();

            while (rs.next()) {
                Sugestao s;
                s = new Sugestao();
                s.setIdSugestao(rs.getInt("idSugestao"));
                s.setAreaSugestao(rs.getString("areaSugestao"));
                s.setDescricao(rs.getString("descricao"));
                s.setData(rs.getDate("data"));
                sugestoes.add(s);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, stm, rs);
        }
        return sugestoes;
    }

    public static int listarQtdNova() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
             con = Conexao.criaConexao();
             stm = con.createStatement();
             rs = stm.executeQuery("SELECT COUNT(idSugestao) FROM sugestao");

            while (rs.next()) {
                cont = rs.getInt(1);

            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, stm, rs);
        }
        return cont;
    }
}
