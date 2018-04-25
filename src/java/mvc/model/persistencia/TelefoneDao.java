package mvc.model.persistencia;

import mvc.model.Telefone;
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
public class TelefoneDao extends Conexao {

    /*Ações de persistência para inserir o telefone*/
    public static int inserirTelProf(Telefone t, int idProfessor) throws Exception {// 
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO telefone (numero, idProfessorFK)"
                    + " values (?,?)");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idProfessor);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int inserirTelAlu(Telefone t, int idAluno) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO telefone (numero, idAlunoFK)"
                    + " values (?,?)");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idAluno);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int inserirTelEst(Telefone t, int idEstagiario) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO telefone (numero, idEstagiarioFK)"
                    + " values (?,?)");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idEstagiario);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int inserirTelRecep(Telefone t, int idRecepcionista) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO telefone (numero, idRecepcionistaFK)"
                    + " values (?,?)");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idRecepcionista);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int inserirTelNutr(Telefone t, int idNutricionista) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO telefone (numero, idNutricionistaFK)"
                    + " values (?,?)");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idNutricionista);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    /*Ações de persistência para listar todos os telefone*/
    public static List<Telefone> listarTelAluno() throws Exception {
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT idTelefone, numero, idAlunoFK  FROM telefone");
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listarTelProf() throws Exception {// padrão que lista todos os Telefones de professores
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT idTelefone, numero, idProfessorFK  FROM telefone");
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listarTelRecep() throws Exception {
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT idTelefone, numero, idRecepcionistaFK  FROM telefone");
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listarTelEst() throws Exception {
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT idTelefone, numero, idEstagiarioFK  FROM telefone");
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listarTelNutr() throws Exception {
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT idTelefone, numero, idNutricionistaFK  FROM telefone");
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return telefones;
    }

    /*Ações de persistência para listar apenas um número*/
    public static List<Telefone> listaUmProf(int id) throws Exception { // padrão que lista todos os telefones especifico de um professor especifico
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM telefone WHERE idProfessorFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listaUmAlu(int id) throws Exception { // padrão que lista todos os telefones especifico de um professor especifico
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM telefone WHERE idAlunoFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listaUmRecep(int id) throws Exception { // padrão que lista todos os telefones especifico de um professor especifico
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM telefone WHERE idRecepcionistaFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listaUmEst(int id) throws Exception { // padrão que lista todos os telefones especifico de um professor especifico
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM telefone WHERE idEstagiarioFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return telefones;
    }

    public static List<Telefone> listaUmNutr(int id) throws Exception { // padrão que lista todos os telefones especifico de um professor especifico
        List<Telefone> telefones = new ArrayList<Telefone>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM telefone WHERE idNutricionistaFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            telefones = new ArrayList<Telefone>();

            while (rs.next()) {
                Telefone t;
                t = new Telefone();
                t.setIdTelefone(rs.getInt("idTelefone"));
                t.setNumero(rs.getString("numero"));
                telefones.add(t);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return telefones;
    }

    public static int alterarTelProf(Telefone t, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE telefone SET numero=? WHERE idProfessorFK=? AND idTelefone=?");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, id);
            pstm.setInt(3, t.getIdTelefone());
            ret = pstm.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarTelAlun(Telefone t, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE telefone SET numero=? WHERE idAlunoFK=? AND idTelefone=?");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, id);
            pstm.setInt(3, t.getIdTelefone());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarTelRecep(Telefone t, int idRecepcionista) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE telefone SET numero=? WHERE idRecepcionistaFK=? AND idTelefone=?");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idRecepcionista);
            pstm.setInt(3, t.getIdTelefone());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarTelEst(Telefone t, int idEstagiario) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE telefone SET numero=? WHERE idEstagiarioFK=? AND idTelefone=?");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idEstagiario);
            pstm.setInt(3, t.getIdTelefone());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarTelNutr(Telefone t, int idNutricionista) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE telefone SET numero=? WHERE idNutricionistaFK=? AND idTelefone=?");
            pstm.setString(1, t.getNumero());
            pstm.setInt(2, idNutricionista);
            pstm.setInt(3, t.getIdTelefone());
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
            pstm = con.prepareStatement("delete from telefone where idSugestao = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
}
