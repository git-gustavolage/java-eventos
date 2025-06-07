package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionFactory;
import model.bean.User;
import support.Hash;

public class UserDao {

    private static User parseUser(ResultSet result) {
        try {
            User user = new User();

            user.setId(result.getInt("id"));
            user.setNome(result.getString("nome"));
            user.setUsername(result.getString("username"));
            user.setEmail(result.getString("email"));
            user.setPassword(result.getString("password"));
            user.setData_nascimento(result.getDate("data_nascimento"));

            return user;
        } catch (SQLException e) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "Erro ao buscar usuário!", e);
            return null;
        }
    }

    public static User findById(int id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM usuarios WHERE id = ? LIMIT 1;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return UserDao.parseUser(result);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "Erro ao buscar usuário!", ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public static User findByUsername(String username) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        String sql = "SELECT * FROM usuarios WHERE username = ? LIMIT 1;";

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet result = stmt.executeQuery();

            if (!result.next()) {
                return null;
            }

            return UserDao.parseUser(result);
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "Erro ao buscar usuário!", ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public static boolean create(User user) {

        String sql = "INSERT INTO usuarios (nome, username, email, password) VALUES (?, ?, ?, ?)";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, Hash.hash(user.getPassword()));

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, "Erro ao criar usuário!", ex);
            return false;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }

        return true;
    }
}
