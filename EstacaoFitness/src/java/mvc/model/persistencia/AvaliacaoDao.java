package mvc.model.persistencia;

import mvc.model.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mvc.model.Aluno;
import mvc.model.Professor;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class AvaliacaoDao extends Conexao {

    public static int inserir(Avaliacao av) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO avaliacao (dataAvaliacao, resultado, valor, validade, idProfessorFK, idAlunoFK) "
                    + "values(?,?,?,?,?,?)");
            pstm.setDate(1, new java.sql.Date(av.getDataAvaliacao().getTime()));
            pstm.setString(2, av.getResultado());
            pstm.setDouble(3, av.getValor());
            pstm.setDate(4, new java.sql.Date(av.getValidade().getTime()));
            pstm.setInt(5, av.getProfessor().getIdProfessor());
            pstm.setInt(6, av.getAluno().getIdAluno());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;

    }

    public static List<Avaliacao> listar() throws Exception {
        List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM avaliacao");
            avaliacoes = new ArrayList<Avaliacao>();

            while (rs.next()) {
                Avaliacao av;
                av = new Avaliacao();
                av.setIdAvaliacao(rs.getInt("idAvaliacao"));
                av.setValidade(rs.getDate("validade"));
                av.setDataAvaliacao(rs.getDate("dataAvaliacao"));
                av.setResultado(rs.getString("resultado"));
                av.setValor(rs.getDouble("valor"));
                
                av.setAluno(AlunoDao.listaUmBasico(rs.getInt("idAlunoFK")));
                
                Professor professor = ProfessorDao.listaUm(rs.getInt("idProfessorFK"));
                
                av.setProfessor(professor);
                avaliacoes.add(av);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return avaliacoes;

    }

    public static Avaliacao listaUm(int id) throws Exception {
        Avaliacao av = new Avaliacao();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM avaliacao WHERE idAvaliacao=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                av = new Avaliacao();
                av.setIdAvaliacao(rs.getInt("idAvaliacao"));
                av.setValidade(rs.getDate("validade"));
                av.setDataAvaliacao(rs.getDate("dataAvaliacao"));
                av.setResultado(rs.getString("resultado"));
                av.setValor(rs.getDouble("valor"));
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAlunoFK"));
                
                av.setAluno(aluno);
                
                Professor professor = ProfessorDao.listaUm(rs.getInt("idProfessorFK"));
                
                av.setProfessor(professor);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return av;
    }

    public static List<Avaliacao> listaUmAluno(int id) throws Exception {
        List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM avaliacao WHERE idAlunoFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Avaliacao av;
                av = new Avaliacao();
                av.setIdAvaliacao(rs.getInt("idAvaliacao"));
                av.setValidade(rs.getDate("validade"));
                av.setDataAvaliacao(rs.getDate("dataAvaliacao"));
                av.setResultado(rs.getString("resultado"));
                av.setValor(rs.getDouble("valor"));
                
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAlunoFK"));
                
                av.setAluno(aluno);
                
                Professor professor = ProfessorDao.listaUm(rs.getInt("idProfessorFK"));
                
                av.setProfessor(professor);
                avaliacoes.add(av);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return avaliacoes;
    }

    public static int alterar(Avaliacao av) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE avaliacao SET dataAvaliacao=?, resultado=?, valor=?, validade=?, idProfessorFK=?, idAlunoFK=? WHERE idAvaliacao=?");
            pstm.setDate(1, new java.sql.Date(av.getDataAvaliacao().getTime()));
            pstm.setString(2, av.getResultado());
            pstm.setDouble(3, av.getValor());
            pstm.setDate(4, new java.sql.Date(av.getValidade().getTime()));
            pstm.setInt(5, av.getProfessor().getIdProfessor());
            pstm.setInt(6, av.getAluno().getIdAluno());
            pstm.setInt(7, av.getIdAvaliacao());
            ret = pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro na avaliacao dao: " + ex.getMessage());
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
            pstm = con.prepareStatement("DELETE FROM avaliacao WHERE idAvaliacao=?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static String ultimAvaliacao(int id) throws Exception {
        String data = null;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT * FROM avaliacao WHERE idAlunoFK=? ORDER BY idAvaliacao DESC LIMIT 1");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                Date validade = rs.getDate("validade");
                SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
                data = formataData.format(validade);
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return data;
    }
    
    public static Date ultmAval(int idAluno) throws Exception {
        Avaliacao a = new Avaliacao();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();;
            pstm = con.prepareStatement("SELECT * FROM avaliacao WHERE idAlunoFK = ? ORDER BY dataAvaliacao ASC LIMIT 1");
            pstm.setInt(1, idAluno);
            rs = pstm.executeQuery();
            if (rs.next()) {
                a = new Avaliacao();
                a.setDataAvaliacao(rs.getDate("dataAvaliacao"));
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return a.getDataAvaliacao();
    }
}
