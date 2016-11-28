package mvc.model.persistencia;

import static com.sun.tools.xjc.reader.Ring.add;
import mvc.model.Dieta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Alimento;
import mvc.model.Aluno;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class DietaDao extends Conexao {

    public static int inserir(Dieta di) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO dieta (validade, descricao, idNutricionistaFK, idAlunoFK) "
                    + "values(?,?,?,?)");
            pstm.setDate(1, new java.sql.Date(di.getValidade().getTime()));
            pstm.setString(2, di.getDescricao());
            pstm.setInt(3, di.getNutricionista().getIdNutricionista());
            pstm.setInt(4, di.getAluno().getIdAluno());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;

    }

    public static List<Dieta> listar() throws Exception {
        List<Dieta> dietas = new ArrayList<Dieta>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM dieta");
            dietas = new ArrayList<Dieta>();

            while (rs.next()) {
                Dieta di;
                di = new Dieta();
                di.setIdDieta(rs.getInt("idDieta"));
                di.setValidade(rs.getDate("validade"));
                di.setDescricao(rs.getString("descricao"));
                di.setAluno(AlunoDao.listaUmBasico(rs.getInt("idAlunoFK")));
                //di.getNutricionista().setIdNutricionista(rs.getInt("idNutricionistaFK"));
                //di.getAluno().setIdAluno(rs.getInt("idAlunoFK"));
                dietas.add(di);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return dietas;

    }
    
    public static List<Dieta> listarDieVenc(int idNutricionista) throws Exception {
        List<Dieta> dietas = new ArrayList<Dieta>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM dieta WHERE idNutricionistaFK=? AND validade < CURDATE()");
            pstm.setInt(1, idNutricionista);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Dieta di;
                di = new Dieta();
                di.setIdDieta(rs.getInt("idDieta"));
                di.setValidade(rs.getDate("validade"));
                di.setDescricao(rs.getString("descricao"));
                di.setAluno(AlunoDao.listaUmBasico(rs.getInt("idAlunoFK")));
                dietas.add(di);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return dietas;

    }
    
    public static int listarQtdDieVenc(int idNutricionista) throws Exception {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int cont = 0;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT COUNT(idDieta) FROM dieta WHERE idNutricionistaFK=? AND validade < CURDATE()");
            pstm.setInt(1, idNutricionista);
            rs = pstm.executeQuery();

            while (rs.next()) {
                cont = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return cont;

    }

    public static Dieta listaUm(int id) throws Exception {
        Dieta di = new Dieta();
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM dieta WHERE idDieta=?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                di = new Dieta();
                di.setIdDieta(rs.getInt("idDieta"));
                di.setValidade(rs.getDate("validade"));
                di.setDescricao(rs.getString("descricao"));
                di.setAluno(AlunoDao.listaUmBasico(rs.getInt("idAlunoFK")));
                //di.getNutricionista().setIdNutricionista(rs.getInt("idNutricionistaFK"));
                //di.getAluno().setIdAluno(rs.getInt("idAlunoFK"));
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return di;
    }

    public static Dieta listaUmAlu(int id) throws Exception {
        Dieta di = new Dieta();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM dieta WHERE idAlunoFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                di = new Dieta();
                di.setIdDieta(rs.getInt("idDieta"));
                di.setValidade(rs.getDate("validade"));
                di.setDescricao(rs.getString("descricao"));
                di.setAluno(AlunoDao.listaUmBasico(rs.getInt("idAlunoFK")));
                List<Alimento> alimentos = AlimentoDietaDao.listarPorDieta(di.getIdDieta());
                di.setAlimentos(alimentos);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return di;
    }

    public static int alterar(Dieta di) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE dieta SET validade=?, descricao=?, idNutricionistaFK=?, idAlunoFK=? WHERE idDieta=?");
            pstm.setDate(2, new java.sql.Date(di.getValidade().getTime()));
            pstm.setString(3, di.getDescricao());
            //pstm.setInt(3, di.getNutricionista().getIdNutricionista());
            //pstm.setInt(4, di.getAluno().getIdAluno());
            ret = pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
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
            pstm = con.prepareStatement("DELETE FROM dieta WHERE idDieta=?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

            con.close();

            return ret;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
    
    public static int deletarAlun(int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("DELETE FROM dieta WHERE idAlunoFK=?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

            con.close();

            return ret;
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
    
    public static int deletarTodos() throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SET SQL_SAFE_UPDATES=0");
            pstm.executeUpdate();
            
            pstm = con.prepareStatement("DELETE FROM dieta");
            ret = pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
    
    public static int restauraId() throws Exception {
        Dieta d = new Dieta();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM dieta ORDER BY idDieta DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                d = new Dieta();
                d.setIdDieta(rs.getInt("idDieta"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return d.getIdDieta();
    }
}
