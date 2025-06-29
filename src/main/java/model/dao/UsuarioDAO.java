package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import exceptions.DatabaseException;
import model.bean.User;
import support.Hash;

public class UsuarioDAO {

    public int create(Connection conn, User user) throws DatabaseException {
        String sql = "INSERT INTO usuarios (nome, username, email, password) VALUES (?, ?, ?, ?)";

        return new DB().executeUpdate(conn, sql, stmt -> {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, Hash.hash(user.getPassword()));
        });
    }

    public User find(Connection conn, Long id) throws DatabaseException {
        String sql = "SELECT * FROM usuarios WHERE id = (?)";

        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id), rs -> {
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

    public User findByUsername(Connection conn, String username) throws DatabaseException {
        String sql = "SELECT * FROM usuarios WHERE username = (?)";

        return new DB().executeQuery(conn, sql, stmt -> stmt.setString(1, username), rs -> {
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

    public List<User> all(Connection conn) throws DatabaseException {
        String sql = "SELECT * FROM usuarios";

        return new DB().executeQuery(conn, sql, stmt -> {
        }, rs -> {
            List<User> users = new ArrayList<>();
            while (rs.next()) {
                users.add(parse(rs));
            }
            return users;
        });
    }

    private User parse(ResultSet rs) throws DatabaseException {
        try (rs) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setNome(rs.getString("nome"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            return user;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
