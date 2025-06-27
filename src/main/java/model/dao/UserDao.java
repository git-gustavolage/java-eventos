package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import exceptions.DatabaseException;
import model.bean.User;
import support.Hash;

public class UserDao {

    public void create(User user) throws DatabaseException {
        String sql = "INSERT INTO usuarios (nome, username, email, password) VALUES (?, ?, ?, ?)";

        DB.getInstance().executeUpdate(sql, stmt -> {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, Hash.hash(user.getPassword()));
        });
    }

    public User findById(int id) throws DatabaseException {
        String sql = "SELECT * FROM user WHERE id = ?";

        return DB.getInstance().executeQuery(sql, stmt -> stmt.setInt(1, id), rs -> {
            if (rs.next()) {
                return mapResultSetToUser(rs);
            }
            return null;
        });
    }

    public List<User> findAll() throws DatabaseException {
        String sql = "SELECT * FROM user";

        return DB.getInstance().executeQuery(sql,
                stmt -> {
                },
                rs -> {
                    List<User> users = new ArrayList<>();
                    while (rs.next()) {
                        users.add(mapResultSetToUser(rs));
                    }
                    return users;
                });
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setNome(rs.getString("nome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setData_nascimento(rs.getDate("data_nascimento"));
        return user;
    }

    public int makeOrganizador(User user) throws DatabaseException {
        String sql = "UPDATE usuarios SET is_organizador = 1 WHERE id = ?";

        return DB.getInstance().executeUpdate(sql, stmt -> stmt.setInt(1, user.getId()));
    }

}
