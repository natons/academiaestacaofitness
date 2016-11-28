package mvc.model.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Luciana
 */
public class Conexao {

    private static Connection con = null;

    public static Connection criaConexao() throws Exception{

        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/estacao_fitness", "root", "root");
                System.out.println("Conexão realizada com sucesso!");
            
            return con;
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }

    public static void closeConnection(Connection conn,
            Statement stmt, ResultSet rs) throws Exception {
        close(conn, stmt, rs);
    }

    public static void closeConnection(Connection conn, Statement stmt)
            throws Exception {
        close(conn, stmt, null);
    }

    public static void closeConnection(Connection conn)
            throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn,
            Statement stmt, ResultSet rs)
            throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
