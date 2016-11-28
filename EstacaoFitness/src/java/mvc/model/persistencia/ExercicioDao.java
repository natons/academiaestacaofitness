package mvc.model.persistencia;

import mvc.model.Exercicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Aluno;
import mvc.model.Estagiario;
import mvc.model.Professor;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class ExercicioDao extends Conexao {

    public static int inserir(Exercicio e) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO exercicio (descricao, idProfessorFK, idAlunoFK) "
                    + "values(?,?,?)");
            pstm.setString(1, e.getDescricao());
            pstm.setInt(2, e.getProfessor().getIdProfessor());
            pstm.setInt(3, e.getAluno().getIdAluno());
            pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;

    }

    public static List<Exercicio> listar() throws Exception {
        List<Exercicio> exercicios = new ArrayList<Exercicio>();
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            stm = con.createStatement();
            rs = stm.executeQuery("SELECT*FROM exercicio");
            exercicios = new ArrayList<Exercicio>();

            while (rs.next()) {
                Exercicio e;
                e = new Exercicio();
                e.setIdExercicio(rs.getInt("idExercicio"));
                e.setDescricao(rs.getString("descricao"));
                Estagiario estagiario = new Estagiario();
                estagiario.setIdEstagiario(rs.getInt("idEstagiarioFK"));
                e.setEstagiario(estagiario);
                Professor professor = new Professor();
                professor.setIdProfessor(rs.getInt("idProfessorFK"));
                e.setProfessor(professor);
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAlunoFK"));
                e.setAluno(aluno);
                e.setTipos(ExercicioTipoDao.listarPorExercicio(e.getIdExercicio()));
                exercicios.add(e);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, stm, rs);
        }
        return exercicios;

    }

    public static Exercicio listaUm(int id) throws Exception {
        Exercicio e = new Exercicio();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM exercicio WHERE idExercicio=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();

            if (rs.next()) {
                e = new Exercicio();
                e.setIdExercicio(rs.getInt("idExercicio"));
                e.setDescricao(rs.getString("descricao"));
                Estagiario estagiario = new Estagiario();
                estagiario.setIdEstagiario(rs.getInt("idEstagiarioFK"));
                e.setEstagiario(estagiario);
                Professor professor = new Professor();
                professor.setIdProfessor(rs.getInt("idProfessorFK"));
                e.setProfessor(professor);
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAlunoFK"));

                e.setTipos(ExercicioTipoDao.listarPorExercicio(id));

                e.setAluno(aluno);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return e;
    }

    public static List<Exercicio> listaUmAlun(int id) throws Exception {
        Exercicio e = new Exercicio();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Exercicio> exercicios = new ArrayList<Exercicio>();

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SELECT*FROM exercicio WHERE idAlunoFK=?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                e = new Exercicio();
                e.setIdExercicio(rs.getInt("idExercicio"));
                e.setDescricao(rs.getString("descricao"));
                Estagiario estagiario = new Estagiario();
                estagiario.setIdEstagiario(rs.getInt("idEstagiarioFK"));
                e.setEstagiario(estagiario);
                Professor professor = new Professor();
                professor.setIdProfessor(rs.getInt("idProfessorFK"));
                e.setProfessor(professor);
                Aluno aluno = new Aluno();
                aluno.setIdAluno(rs.getInt("idAlunoFK"));
                e.setTipos(ExercicioTipoDao.listarPorExercicio(e.getIdExercicio()));
                e.setAluno(aluno);
                
                exercicios.add(e);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return exercicios;
    }

    public static int alterar(Exercicio e) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("UPDATE exercicio SET descricao=?, idEstagiarioFK=?, idProfessorFK=?, idAlunoFK=? WHERE idExercicio=?");
            pstm.setString(2, e.getDescricao());
            pstm.setInt(3, e.getEstagiario().getIdEstagiario());
            pstm.setInt(4, e.getProfessor().getIdProfessor());
            pstm.setInt(5, e.getAluno().getIdAluno());
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
            pstm = con.prepareStatement("DELETE FROM exercicio WHERE idExercicio=?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
    
    public static int deletarTodos(int id) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("SET SQL_SAFE_UPDATES=0");
            pstm.executeUpdate();
            
            pstm = con.prepareStatement("DELETE FROM exercicio Where idAlunoFK = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }
    
    public static int restauraId() throws Exception {
        Exercicio e = new Exercicio();
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = Conexao.criaConexao();;
            pstm = con.prepareStatement("SELECT * FROM exercicio ORDER BY idExercicio DESC LIMIT 1");
            rs = pstm.executeQuery();
            if (rs.next()) {
                e = new Exercicio();
                e.setIdExercicio(rs.getInt("idExercicio"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        } finally {
            Conexao.closeConnection(con, pstm, rs);
        }
        return e.getIdExercicio();
    }
}
