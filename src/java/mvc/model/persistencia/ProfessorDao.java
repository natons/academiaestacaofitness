package mvc.model.persistencia;

import mvc.model.Professor;
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
public class ProfessorDao extends Conexao {

    public static int inserir(Professor pr) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO professor (matricula, nome, cpf, endereco, status, urlFoto, senha)"
                    + " values (?,?,?,?,?,?,?)");
            pstm.setInt(1, pr.getMatricula());
            pstm.setString(2, pr.getNome());
            pstm.setString(3, pr.getCpf());
            pstm.setString(4, pr.getEndereco());
            pstm.setString(5, pr.getStatus());
            pstm.setString(6, pr.getUrlFoto());
            pstm.setString(7, pr.getSenha());
            ret = pstm.executeUpdate();

            for (Telefone tel : pr.getTelefones()) {
                TelefoneDao.inserirTelProf(tel, restauraId());
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Professor> listar() throws Exception {
        List<Professor> professores = new ArrayList<Professor>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM professor");
            professores = new ArrayList<Professor>();

            while (rs.next()) {
                Professor pr;
                pr = new Professor();
                pr.setIdProfessor(rs.getInt("idProfessor"));
                pr.setMatricula(rs.getInt("matricula"));
                pr.setNome(rs.getString("nome"));
                pr.setCpf(rs.getString("cpf"));
                pr.setEndereco(rs.getString("endereco"));
                pr.setStatus(rs.getString("status"));
                pr.setUrlFoto(rs.getString("urlFoto"));
                pr.setSenha(rs.getString("senha"));
                pr.setTelefones(TelefoneDao.listaUmProf(pr.getIdProfessor()));
                professores.add(pr);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return professores;
    }

    public static Professor listaUm(int id) throws Exception {
        Professor pr = new Professor();
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM professor WHERE idProfessor = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pr = new Professor();
                pr.setIdProfessor(rs.getInt("idProfessor"));
                pr.setMatricula(rs.getInt("matricula"));
                pr.setNome(rs.getString("nome"));
                pr.setCpf(rs.getString("cpf"));
                pr.setEndereco(rs.getString("endereco"));
                pr.setStatus(rs.getString("status"));
                pr.setUrlFoto(rs.getString("urlFoto"));
                pr.setSenha(rs.getString("senha"));
                pr.setTelefones(TelefoneDao.listaUmProf(id));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return pr;
    }

    public static Professor listaUmMatricula(int matricula) throws Exception {
        Professor pr = new Professor();
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM professor WHERE matricula = ?");
            pstm.setInt(1, matricula);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pr = new Professor();
                pr.setIdProfessor(rs.getInt("idProfessor"));
                pr.setMatricula(matricula);
                pr.setNome(rs.getString("nome"));
                pr.setCpf(rs.getString("cpf"));
                pr.setEndereco(rs.getString("endereco"));
                pr.setStatus(rs.getString("status"));
                pr.setUrlFoto(rs.getString("urlFoto"));
                pr.setSenha(rs.getString("senha"));
                pr.setTelefones(TelefoneDao.listaUmProf(pr.getIdProfessor()));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return pr;
    }

    public static int alterar(Professor pr) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE professor SET nome=?, matricula=?, cpf=?, endereco=?, status=?, senha=? WHERE idProfessor=?");
            pstm.setString(1, pr.getNome());
            pstm.setInt(2, pr.getMatricula());
            pstm.setString(3, pr.getCpf());
            pstm.setString(4, pr.getEndereco());
            pstm.setString(5, pr.getStatus());
            pstm.setString(6, pr.getSenha());
            pstm.setInt(7, pr.getIdProfessor());
            ret = pstm.executeUpdate();

            for (Telefone tel : pr.getTelefones()) {
                TelefoneDao.alterarTelProf(tel, pr.getIdProfessor());
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
            pstm = con.prepareStatement("UPDATE professor SET urlFoto=? WHERE idProfessor=?");
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

    public static int alterarSenha(Professor pr, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE professor SET senha=? WHERE idProfessor=?");
            pstm.setString(1, pr.getSenha());
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
            pstm = con.prepareStatement("delete from professor where idProfessor = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();
            con.close();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static int restauraId() throws Exception {
        Professor n = new Professor();
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM professor ORDER BY idProfessor DESC LIMIT 1");
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                n = new Professor();
                n.setIdProfessor(rs.getInt("idProfessor"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(null, pstm, null);
        }
        return n.getIdProfessor();
    }

    public static boolean existeProfessor(int matricula, String senha) throws Exception {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM professor WHERE matricula = ? AND senha = ?");
            pstm.setInt(1, matricula);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                Professor pr = new Professor();
                pr.setMatricula(rs.getInt("matricula"));
                pr.setSenha(rs.getString("senha"));
                pr.setStatus(rs.getString("status"));

                if (matricula != 0 && !senha.isEmpty() && pr.getStatus().equalsIgnoreCase("Ativado")) {
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
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT COUNT(idProfessor) FROM professor");

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
