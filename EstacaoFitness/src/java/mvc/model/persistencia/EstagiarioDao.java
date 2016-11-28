package mvc.model.persistencia;

import mvc.model.Estagiario;
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
public class EstagiarioDao extends Conexao {

    public static int inserir(Estagiario es) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO estagiario (matricula, nome, cpf, endereco, status, urlFoto, senha)"
                    + " values (?,?,?,?,?,?,?)");
            pstm.setInt(1, es.getMatricula());
            pstm.setString(2, es.getNome());
            pstm.setString(3, es.getCpf());
            pstm.setString(4, es.getEndereco());
            pstm.setString(5, es.getStatus());
            pstm.setString(6, es.getUrlFoto());
            pstm.setString(7, es.getSenha());
            ret = pstm.executeUpdate();

            for (Telefone tel : es.getTelefones()) {
                TelefoneDao.inserirTelEst(tel, restauraId());
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Estagiario> listar() throws Exception {
        List<Estagiario> estagiarios = new ArrayList<Estagiario>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM estagiario");
            estagiarios = new ArrayList<Estagiario>();

            while (rs.next()) {
                Estagiario es;
                es = new Estagiario();
                es.setIdEstagiario(rs.getInt("idEstagiario"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNome(rs.getString("nome"));
                es.setCpf(rs.getString("cpf"));
                es.setEndereco(rs.getString("endereco"));
                es.setStatus(rs.getString("status"));
                es.setUrlFoto(rs.getString("urlFoto"));
                es.setSenha(rs.getString("senha"));
                es.setTelefones(TelefoneDao.listaUmEst(es.getIdEstagiario()));
                estagiarios.add(es);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return estagiarios;
    }

    public static Estagiario listaUm(int id) throws Exception {
        Estagiario es = new Estagiario();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM estagiario WHERE idEstagiario = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                es = new Estagiario();
                es.setIdEstagiario(rs.getInt("idEstagiario"));
                es.setMatricula(rs.getInt("matricula"));
                es.setNome(rs.getString("nome"));
                es.setCpf(rs.getString("cpf"));
                es.setEndereco(rs.getString("endereco"));
                es.setStatus(rs.getString("status"));
                es.setUrlFoto(rs.getString("urlFoto"));
                es.setSenha(rs.getString("senha"));
                es.setTelefones(TelefoneDao.listaUmEst(id));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return es;
    }

    public static Estagiario listaUmMatricula(int matricula) throws Exception {
        Estagiario es = new Estagiario();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM estagiario WHERE matricula = ?");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            if (rs.next()) {
                es = new Estagiario();
                es.setIdEstagiario(rs.getInt("idEstagiario"));
                es.setMatricula(matricula);
                es.setNome(rs.getString("nome"));
                es.setCpf(rs.getString("cpf"));
                es.setEndereco(rs.getString("endereco"));
                es.setStatus(rs.getString("status"));
                es.setUrlFoto(rs.getString("urlFoto"));
                es.setSenha(rs.getString("senha"));
                es.setTelefones(TelefoneDao.listaUmEst(es.getIdEstagiario()));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return es;
    }

    public static int alterar(Estagiario es) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE estagiario SET nome=?, matricula=?, cpf=?, endereco=?, status=?, senha=? WHERE idEstagiario=?");
            pstm.setString(1, es.getNome());
            pstm.setInt(2, es.getMatricula());
            pstm.setString(3, es.getCpf());
            pstm.setString(4, es.getEndereco());
            pstm.setString(5, es.getStatus());
            pstm.setString(6, es.getSenha());
            pstm.setInt(7, es.getIdEstagiario());
            ret = pstm.executeUpdate();

            for (Telefone tel : es.getTelefones()) {
                TelefoneDao.alterarTelEst(tel, es.getIdEstagiario());
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
            pstm = con.prepareStatement("UPDATE estagiario SET urlFoto=? WHERE idEstagiario=?");
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

    public static int alterarSenha(Estagiario es, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE estagiario SET senha=? WHERE idEstagiario=?");
            pstm.setString(1, es.getSenha());
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
            pstm = con.prepareStatement("delete from estagiario where idEstagiario = ?");
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
        Estagiario es = new Estagiario();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM estagiario ORDER BY idEstagiario DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                es = new Estagiario();
                es.setIdEstagiario(rs.getInt("idEstagiario"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return es.getIdEstagiario();
    }

    public static boolean existeEstagiario(int matricula, String senha) throws Exception {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM estagiario WHERE matricula = ? AND senha = ?");
            pstm.setInt(1, matricula);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Estagiario es = new Estagiario();
                es.setMatricula(rs.getInt("matricula"));
                es.setSenha(rs.getString("senha"));
                es.setStatus(rs.getString("status"));

                if (matricula != 0 && !senha.isEmpty() && es.getStatus().equalsIgnoreCase("Ativado")) {
                    existe = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return existe;
    }

    public static int listarQtd() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(idEstagiario) FROM estagiario");

            while (rs.next()) {
                cont = rs.getInt(1);

            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, stm);
        }
        return cont;
    }
}
