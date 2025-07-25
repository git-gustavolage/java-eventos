package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import support.Config;

public class ConnectionFactory {

    private static final String DRIVER = Config.get("db.driver");
    private static final String URL = Config.get("db.url");
    private static final String USER = Config.get("db.user");
    private static final String PASSWORD = Config.get("db.password");

    public ConnectionFactory() {

    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Connection getNewConnection() {
        return new ConnectionFactory().open();
    }

    public Connection open() {
        try {
            Class.forName(DRIVER);
            return this.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao estabelecer conexão com o banco de dados!", ex);
        }
    }

    public void close(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão com o banco de dados!", ex);
        }
    }

    public void close(Connection conn, PreparedStatement stmt) {
        this.close(conn);

        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão com o banco de dados!", ex);
        }
    }

    public void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
        this.close(conn, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, "Erro ao fechar conexão com o banco de dados!", ex);
        }
    }
}
