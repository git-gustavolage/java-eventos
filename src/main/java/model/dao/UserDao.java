package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import database.ConnectionFactory;
import model.bean.User;
import support.Hash;

public class UserDao {
    
    public User find(User user) {
        return user;
    }
    
    public User find(String username, String password) {
        
        String sql = "SELECT * FROM usuarios (WHERE username = ? AND password = ?) LIMIT 1;";
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);
            stmt.setString(2, password);
            
            //ResultSet result = stmt.executeQuery();
            
            //User user = new User();
            return null;
           
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            ConnectionFactory.close(conn, stmt);
        }
    }

    public boolean create(User user) {

        String sql = "INSERT INTO usuarios (nome, username, email, password) VALUES (?, ?, ?, ?)";

        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUser());
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
