package mvc.model.persistencia;

import mvc.model.Nutricionista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Telefone;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class NutricionistaDao extends Conexao {

    public static int inserir(Nutricionista n) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO nutricionista (matricula, nome, cpf, endereco, status, urlFoto, senha)"
                    + " values (?,?,?,?,?,?,?)");
            pstm.setInt(1, n.getMatricula());
            pstm.setString(2, n.getNome());
            pstm.setString(3, n.getCpf());
            pstm.setString(4, n.getEndereco());
            pstm.setString(5, n.getStatus());
            pstm.setString(6, n.getUrlFoto());
            pstm.setString(7, n.getSenha());
            ret = pstm.executeUpdate();

            for (Telefone tel : n.getTelefones()) {
                TelefoneDao.inserirTelNutr(tel, restauraId());
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Nutricionista> listar() throws Exception {
        List<Nutricionista> nutricionistas = new ArrayList<Nutricionista>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM nutricionista");
            nutricionistas = new ArrayList<Nutricionista>();

            while (rs.next()) {
                Nutricionista n;
                n = new Nutricionista();
                n.setIdNutricionista(rs.getInt("idNutricionista"));
                n.setMatricula(rs.getInt("matricula"));
                n.setNome(rs.getString("nome"));
                n.setCpf(rs.getString("cpf"));
                n.setEndereco(rs.getString("endereco"));
                n.setStatus(rs.getString("status"));
                n.setUrlFoto(rs.getString("urlFoto"));
                n.setSenha(rs.getString("senha"));
                n.setTelefones(TelefoneDao.listaUmNutr(n.getIdNutricionista()));
                nutricionistas.add(n);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return nutricionistas;
    }

    public static Nutricionista listaUm(int id) throws Exception {
        Nutricionista n = new Nutricionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM nutricionista WHERE idNutricionista = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                n = new Nutricionista();
                n.setIdNutricionista(rs.getInt("idNutricionista"));
                n.setMatricula(rs.getInt("matricula"));
                n.setNome(rs.getString("nome"));
                n.setCpf(rs.getString("cpf"));
                n.setEndereco(rs.getString("endereco"));
                n.setStatus(rs.getString("status"));
                n.setUrlFoto(rs.getString("urlFoto"));
                n.setSenha(rs.getString("senha"));
                n.setTelefones(TelefoneDao.listaUmNutr(id));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return n;
    }

    public static Nutricionista listaUmMatricula(int matricula) throws Exception {
        Nutricionista n = new Nutricionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM nutricionista WHERE matricula = ?");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            if (rs.next()) {
                n = new Nutricionista();
                n.setIdNutricionista(rs.getInt("idNutricionista"));
                n.setMatricula(matricula);
                n.setNome(rs.getString("nome"));
                n.setCpf(rs.getString("cpf"));
                n.setEndereco(rs.getString("endereco"));
                n.setStatus(rs.getString("status"));
                n.setUrlFoto(rs.getString("urlFoto"));
                n.setSenha(rs.getString("senha"));
                n.setTelefones(TelefoneDao.listaUmNutr(n.getIdNutricionista()));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return n;
    }

    public static int alterar(Nutricionista n) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE nutricionista SET nome=?, matricula=?, cpf=?, endereco=?, status=?, senha=? WHERE idNutricionista=?");
            pstm.setString(1, n.getNome());
            pstm.setInt(2, n.getMatricula());
            pstm.setString(3, n.getCpf());
            pstm.setString(4, n.getEndereco());
            pstm.setString(5, n.getStatus());
            pstm.setString(6, n.getSenha());
            pstm.setInt(7, n.getIdNutricionista());
            ret = pstm.executeUpdate();

            for (Telefone tel : n.getTelefones()) {
                TelefoneDao.alterarTelNutr(tel, n.getIdNutricionista());
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarFotoUrl(String urlFoto, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE nutricionista SET urlFoto=? WHERE idNutricionista=?");
            pstm.setString(1, urlFoto);
            pstm.setInt(2, id);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int alterarSenha(Nutricionista n, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE nutricionista SET senha=? WHERE idNutricionista=?");
            pstm.setString(1, n.getSenha());
            pstm.setInt(2, id);
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
            pstm = con.prepareStatement("delete from nutricionista where idNutricionista = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int restauraId() throws Exception {
        Nutricionista n = new Nutricionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM nutricionista ORDER BY idNutricionista DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                n = new Nutricionista();
                n.setIdNutricionista(rs.getInt("idNutricionista"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return n.getIdNutricionista();
    }

    public static boolean existeNutricionista(int matricula, String senha) throws Exception {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM nutricionista WHERE matricula = ? AND senha = ?");
            pstm.setInt(1, matricula);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Nutricionista n = new Nutricionista();
                n.setMatricula(rs.getInt("matricula"));
                n.setSenha(rs.getString("senha"));
                n.setStatus(rs.getString("status"));

                if (matricula != 0 && !senha.isEmpty() && n.getStatus().equalsIgnoreCase("Ativado")) {
                    existe = true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return existe;
    }

    public static int listarQtd() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
             con = Conexao.criaConexao();
             stm = con.createStatement();
             rs = stm.executeQuery("SELECT COUNT(idNutricionista) FROM nutricionista");

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
