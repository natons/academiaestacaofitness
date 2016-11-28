package mvc.model.persistencia;

import mvc.model.Lembrete;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mvc.model.Recepcionista;
import mvc.model.conexao.Conexao;

/**
 *
 * @author Luciana
 */
public class LembreteDao {

    public static int inserir(Lembrete l) throws Exception {
        int ret = 0;
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = Conexao.criaConexao();
            pstm = con.prepareStatement("INSERT INTO lembrete (titulo, corpo, idRecepcionistaFK)"
                    + " values (?,?,?)");
            pstm.setString(1, l.getTitulo());
            pstm.setString(2, l.getCorpo());
            pstm.setInt(3, l.getRecepcionista().getIdRecepcionista());
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally{
            Conexao.closeConnection(con, pstm);
        }
        return ret;
    }

    public static List<Lembrete> listar() throws Exception {
        List<Lembrete> lembretes = new ArrayList<Lembrete>();
        try {
            Connection con = Conexao.criaConexao();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT*FROM lembrete");
            lembretes = new ArrayList<Lembrete>();

            while (rs.next()) {
                Lembrete l;
                l = new Lembrete();
                l.setIdLembrete(rs.getInt("idLembrete"));
                l.setTitulo(rs.getString("titulo"));
                l.setCorpo(rs.getString("corpo"));

                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setIdRecepcionista(rs.getInt("idRecepcionistaFK"));

                l.setRecepcionista(recepcionista);
                lembretes.add(l);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lembretes;
    }

    public static Lembrete listaUm(int id) throws Exception {
        Lembrete l = new Lembrete();
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("SELECT*FROM lembrete WHERE idLembrete = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                l = new Lembrete();
                l.setIdLembrete(rs.getInt("idLembrete"));
                l.setTitulo(rs.getString("titulo"));
                l.setCorpo(rs.getString("corpo"));
                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setIdRecepcionista(rs.getInt("idRecepcionistaFK"));
                l.setRecepcionista(recepcionista);
            }

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return l;
    }

    public static List<Lembrete> listaUmRecep(int id) throws Exception {
        List<Lembrete> lembretes = new ArrayList<Lembrete>();
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("SELECT*FROM lembrete WHERE idRecepcionistaFK = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            lembretes = new ArrayList<Lembrete>();

            while (rs.next()) {
                Lembrete l;
                l = new Lembrete();
                l.setIdLembrete(rs.getInt("idLembrete"));
                l.setTitulo(rs.getString("titulo"));
                l.setCorpo(rs.getString("corpo"));

                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setIdRecepcionista(rs.getInt("idRecepcionistaFK"));

                l.setRecepcionista(recepcionista);

                lembretes.add(l);
            }
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lembretes;
    }

    public static int alterar(Lembrete l) throws Exception {
        int ret = 0;
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("UPDATE lembrete SET titulo=?, corpo=?, idRecepcionistaFK=? WHERE idLembrete=?");
            pstm.setString(1, l.getTitulo());
            pstm.setString(2, l.getCorpo());
            pstm.setInt(3, l.getRecepcionista().getIdRecepcionista());
            pstm.setInt(4, l.getIdLembrete());

            ret = pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return ret;
    }

    public static int deletar(int id) throws Exception {
        int ret = 0;
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("delete from lembrete where idLembrete = ?");
            pstm.setInt(1, id);
            ret = pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return ret;
    }

    public static List<Lembrete> listaUltiRecep(int id) throws Exception {
        List<Lembrete> lembretes = new ArrayList<Lembrete>();
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("SELECT*FROM lembrete WHERE idRecepcionistaFK = ? ORDER BY idLembrete DESC LIMIT 6");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            lembretes = new ArrayList<Lembrete>();

            while (rs.next()) {
                Lembrete l;
                l = new Lembrete();
                l.setIdLembrete(rs.getInt("idLembrete"));
                l.setTitulo(rs.getString("titulo"));
                l.setCorpo(rs.getString("corpo"));

                Recepcionista recepcionista = new Recepcionista();
                recepcionista.setIdRecepcionista(rs.getInt("idRecepcionistaFK"));

                l.setRecepcionista(recepcionista);

                lembretes.add(l);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return lembretes;
    }

    public static int listaQtdRecep(int id) throws Exception {
        int cont = 0;
        try {
            Connection con = Conexao.criaConexao();
            PreparedStatement pstm = con.prepareStatement("SELECT COUNT(idlembrete) FROM lembrete WHERE idRecepcionistaFK = ?");
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cont = rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
        return cont;
    }

}
