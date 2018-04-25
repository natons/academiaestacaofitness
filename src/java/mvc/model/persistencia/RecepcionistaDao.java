package mvc.model.persistencia;

import mvc.model.Recepcionista;
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
public class RecepcionistaDao extends Conexao {

    public static int inserir(Recepcionista r) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO recepcionista (matricula, nome, cpf, endereco, status, urlFoto, senha)"
                    + " values (?,?,?,?,?,?,?)");
            pstm.setInt(2, r.getMatricula());
            pstm.setString(3, r.getNome());
            pstm.setString(4, r.getCpf());
            pstm.setString(5, r.getEndereco());
            pstm.setString(6, r.getStatus());
            pstm.setString(7, r.getUrlFoto());
            pstm.setString(8, r.getSenha());
            ret = pstm.executeUpdate();
            con.close();

            for (Telefone tel : r.getTelefones()) {
                TelefoneDao.alterarTelRecep(tel, restauraId());
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Recepcionista> listar() throws Exception {
        List<Recepcionista> recepcionistas = new ArrayList<Recepcionista>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM recepcionista");
            recepcionistas = new ArrayList<Recepcionista>();

            while (rs.next()) {
                Recepcionista r;
                r = new Recepcionista();
                r.setIdRecepcionista(rs.getInt("idRecepcionista"));
                r.setMatricula(rs.getInt("matricula"));
                r.setNome(rs.getString("nome"));
                r.setCpf(rs.getString("cpf"));
                r.setEndereco(rs.getString("endereco"));
                r.setStatus(rs.getString("status"));
                r.setUrlFoto(rs.getString("urlFoto"));
                r.setSenha(rs.getString("senha"));
                r.setTelefones(TelefoneDao.listaUmRecep(r.getIdRecepcionista()));
                recepcionistas.add(r);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return recepcionistas;
    }

    public static Recepcionista listaUm(int id) throws Exception {
        Recepcionista r = new Recepcionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM recepcionista WHERE idRecepcionista = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                r = new Recepcionista();
                r.setIdRecepcionista(rs.getInt("idRecepcionista"));
                r.setMatricula(rs.getInt("matricula"));
                r.setNome(rs.getString("nome"));
                r.setCpf(rs.getString("cpf"));
                r.setEndereco(rs.getString("endereco"));
                r.setStatus(rs.getString("status"));
                r.setUrlFoto(rs.getString("urlFoto"));
                r.setSenha(rs.getString("senha"));
                r.setTelefones(TelefoneDao.listaUmRecep(id));
                r.setLembretes(LembreteDao.listaUmRecep(id));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return r;
    }

    public static Recepcionista listaUmMatricula(int matricula) throws Exception {
        Recepcionista r = new Recepcionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM recepcionista WHERE matricula = ?");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            if (rs.next()) {
                r = new Recepcionista();
                r.setIdRecepcionista(rs.getInt("idRecepcionista"));
                r.setMatricula(matricula);
                r.setNome(rs.getString("nome"));
                r.setCpf(rs.getString("cpf"));
                r.setEndereco(rs.getString("endereco"));
                r.setStatus(rs.getString("status"));
                r.setUrlFoto(rs.getString("urlFoto"));
                r.setSenha(rs.getString("senha"));
                r.setTelefones(TelefoneDao.listaUmRecep(r.getIdRecepcionista()));
                r.setLembretes(LembreteDao.listaUmRecep(r.getIdRecepcionista()));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return r;
    }

    public static int alterar(Recepcionista r) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE recepcionista SET nome=?, cpf=?, endereco=?, status=?, senha=? WHERE idRecepcionista=?");
            pstm.setString(1, r.getNome());
            pstm.setString(2, r.getCpf());
            pstm.setString(3, r.getEndereco());
            pstm.setString(4, r.getStatus());
            pstm.setString(5, r.getSenha());
            pstm.setInt(6, r.getIdRecepcionista());
            ret = pstm.executeUpdate();

            for (Telefone tel : r.getTelefones()) {
                TelefoneDao.alterarTelRecep(tel, r.getIdRecepcionista());
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
            pstm = con.prepareStatement("UPDATE recepcionista SET urlFoto=? WHERE idRecepcionista=?");
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

    public static int alterarSenha(Recepcionista r, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE recepcionista SET senha=? WHERE idRecepcionista=?");
            pstm.setString(1, r.getSenha());
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
            pstm = con.prepareStatement("delete from recepcionista where idRecepcionista = ?");
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
        Recepcionista r = new Recepcionista();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM recepcionista ORDER BY idRecepcionista DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                r = new Recepcionista();
                r.setIdRecepcionista(rs.getInt("idRecepcionista"));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return r.getIdRecepcionista();
    }

    public static boolean existeRecepcionista(int matricula, String senha) throws Exception {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM recepcionista WHERE matricula = ? AND senha = ?");
            pstm.setInt(1, matricula);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Recepcionista r = new Recepcionista();
                r.setMatricula(rs.getInt("matricula"));
                r.setSenha(rs.getString("senha"));
                r.setStatus(rs.getString("status"));

                existe = true;
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return existe;
    }

    public static int qtdTodosUsu() throws Exception {
        int cont = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
             con = Conexao.criaConexao();
             pstm = con.prepareStatement("SELECT (\n"
                    + "	(SELECT COUNT(idAluno) FROM aluno) +\n"
                    + "	(SELECT COUNT(idRecepcionista) FROM recepcionista)+\n"
                    + "    (SELECT COUNT(idProfessor) FROM professor)+\n"
                    + "    (SELECT COUNT(idEstagiario) FROM estagiario)+\n"
                    + "    (SELECT COUNT(idNutricionista) FROM nutricionista)\n"
                    + "    ) AS resultado");
             rs = pstm.executeQuery();

            while (rs.next()) {
                cont = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm, rs);
        }
        return cont;
    }

    public static int listarQtd() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
             con = Conexao.criaConexao();
             stm = con.createStatement();
             rs = stm.executeQuery("SELECT COUNT(idRecepcionista) FROM recepcionista");

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
