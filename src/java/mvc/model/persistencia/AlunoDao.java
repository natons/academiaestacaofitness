package mvc.model.persistencia;

import mvc.model.Aluno;
import mvc.model.Telefone;
import java.sql.Connection;
import java.sql.Date;
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
public class AlunoDao extends Conexao {
    
    public static int inserir(Aluno a) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO aluno (nome, matricula, peso, status,  endereco, dataNascimento, senha, urlFoto)"
                    + " values (?,?,?,?,?,?,?,?)");
            pstm.setString(1, a.getNome());
            pstm.setInt(2, a.getMatricula());
            pstm.setDouble(3, a.getPeso());
            pstm.setString(4, a.getStatus());
            pstm.setString(5, a.getEndereco());
            pstm.setDate(6, (Date) a.getDataNascimento());
            pstm.setString(7, a.getSenha());
            pstm.setString(8, a.getUrlFoto());
            ret = pstm.executeUpdate();

            //Gravando telefone
            for (Telefone tel : a.getTelefones()) {
                TelefoneDao.inserirTelAlu(tel, restauraId());
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Aluno> listar() throws Exception {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM aluno");
            rs = pstm.executeQuery();
            
            alunos = new ArrayList<Aluno>();
            while (rs.next()) {
                Aluno a;
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setPeso(rs.getDouble("peso"));
                a.setEndereco(rs.getString("endereco"));
                a.setDataNascimento(rs.getDate("dataNascimento"));
                a.setStatus(rs.getString("status"));
                a.setSenha(rs.getString("senha"));
                a.setUrlFoto(rs.getString("urlFoto"));
                a.setAvaliacoes(AvaliacaoDao.listaUmAluno(a.getIdAluno()));
                a.setExercicios(ExercicioDao.listaUmAlun(a.getIdAluno()));
                int id = a.getIdAluno();

                List<Telefone> telefones = TelefoneDao.listaUmAlu(id);
                a.setTelefones(telefones);

                alunos.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return alunos;
    }

    public static int listarStaAtiv() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT COUNT(idAluno) FROM aluno WHERE status = 'Ativado' ");

            if (rs.next()) {
                cont = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return cont;
    }

    public static int listarStaDesa() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT COUNT(idAluno) FROM aluno WHERE status = 'Desativado' ");

            if (rs.next()) {
                cont = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return cont;
    }

    public static Aluno listaUm(int id) throws Exception {
        Aluno a = new Aluno();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM aluno WHERE idAluno = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setPeso(rs.getDouble("peso"));
                a.setEndereco(rs.getString("endereco"));
                a.setDataNascimento(rs.getDate("dataNascimento"));
                a.setSenha(rs.getString("senha"));
                a.setStatus(rs.getString("status"));
                a.setUrlFoto(rs.getString("urlFoto"));
                a.setTelefones(TelefoneDao.listaUmAlu(id));
                a.setDieta(DietaDao.listaUmAlu(a.getIdAluno()));
                a.setAvaliacoes(AvaliacaoDao.listaUmAluno(a.getIdAluno()));
                a.setExercicios(ExercicioDao.listaUmAlun(a.getIdAluno()));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a;
    }
    
    public static Aluno listaUmBasico(int id) throws Exception {
        Aluno a = new Aluno();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM aluno WHERE idAluno = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a;
    }

    public static Aluno listaUmMatricula(int matricula) throws Exception {
        Aluno a = new Aluno();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM aluno WHERE matricula = ?");
            pstm.setInt(1, matricula);
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setNome(rs.getString("nome"));
                a.setPeso(rs.getDouble("peso"));
                a.setEndereco(rs.getString("endereco"));
                a.setDataNascimento(rs.getDate("dataNascimento"));
                a.setSenha(rs.getString("senha"));
                a.setStatus(rs.getString("status"));
                a.setUrlFoto(rs.getString("urlFoto"));
                a.setMatricula(matricula);
                a.setTelefones(TelefoneDao.listaUmAlu(a.getIdAluno()));
                a.setDieta(DietaDao.listaUmAlu(a.getIdAluno()));
                a.setAvaliacoes(AvaliacaoDao.listaUmAluno(a.getIdAluno()));
                a.setExercicios(ExercicioDao.listaUmAlun(a.getIdAluno()));
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a;
    }

    public static int alterar(Aluno a) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE aluno SET nome=?, matricula=?, peso=?, status=?,  endereco=?, dataNascimento=?, senha=? WHERE idAluno=?");
            pstm.setString(1, a.getNome());
            pstm.setInt(2, a.getMatricula());
            pstm.setDouble(3, a.getPeso());
            pstm.setString(4, a.getStatus());
            pstm.setString(5, a.getEndereco());
            pstm.setDate(6, (Date) a.getDataNascimento());
            pstm.setString(7, a.getSenha());
            pstm.setInt(8, a.getIdAluno());
            ret = pstm.executeUpdate();

            for (Telefone tel : a.getTelefones()) {
                TelefoneDao.alterarTelAlun(tel, a.getIdAluno());
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
            con = Conexao.criaConexao();;
            pstm = con.prepareStatement("UPDATE aluno SET urlFoto=? WHERE idAluno=?");
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

    public static int alterarSenha(Aluno aluno, int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE aluno SET senha=? WHERE idAluno=?");
            pstm.setString(1, aluno.getSenha());
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
            pstm = con.prepareStatement("delete from aluno where idAluno = ?");
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
        Aluno a = new Aluno();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();;
            pstm = con.prepareStatement("SELECT * FROM aluno ORDER BY idAluno DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a.getIdAluno();
    }

    public static boolean existeAluno(int matricula, String senha) throws Exception {
        boolean existe = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM aluno WHERE matricula = ? AND senha = ?");
            pstm.setInt(1, matricula);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                Aluno a = new Aluno();
                a.setMatricula(rs.getInt("matricula"));
                a.setSenha(rs.getString("senha"));
                a.setStatus(rs.getString("status"));

                if (matricula != 0 && !senha.isEmpty() && a.getStatus().equalsIgnoreCase("Ativado")) {
                    existe = true;
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return existe;
    }

    public static List<Aluno> listarUltimos() throws Exception {
        List<Aluno> alunos = new ArrayList<Aluno>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT * FROM aluno ORDER BY idAluno DESC LIMIT 11");

            while (rs.next()) {
                Aluno a;
                a = new Aluno();
                a.setIdAluno(rs.getInt("idAluno"));
                a.setMatricula(rs.getInt("matricula"));
                a.setNome(rs.getString("nome"));
                a.setPeso(rs.getDouble("peso"));
                a.setEndereco(rs.getString("endereco"));
                a.setDataNascimento(rs.getDate("dataNascimento"));
                a.setStatus(rs.getString("status"));
                a.setSenha(rs.getString("senha"));
                a.setUrlFoto(rs.getString("urlFoto"));

                int id = a.getIdAluno();

                List<Telefone> telefones = TelefoneDao.listaUmAlu(id);
                a.setTelefones(telefones);

                alunos.add(a);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return alunos;
    }

    public static int listarQtd() throws Exception {
        int cont = 0;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT COUNT(idAluno) FROM aluno");

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
