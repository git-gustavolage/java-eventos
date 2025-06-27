package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.DB;
import exceptions.DatabaseException;
import model.bean.User;
import model.vo.UserCargo;

public class UserCargoDao {

    private UserCargo parse(ResultSet rs) throws SQLException {
        return UserCargo.valueOf(rs.getString("cargo"));
    }

    public void create(User user, UserCargo cargo) throws DatabaseException {
        String sql = "INSERT INTO user_cargo (user_id, cargo) VALUES (?, ?)";

        DB.getInstance().executeUpdate(sql, stmt -> {
            stmt.setInt(1, user.getId());
            stmt.setString(2, cargo.name());
        });
    }

    public UserCargo getUserCargo(User user) throws DatabaseException {
        String sql = "SELECT cargo FROM user_cargo WHERE user_id = ?";

        return DB.getInstance().executeQuery(sql, stmt -> stmt.setInt(1, user.getId()), rs -> {
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

}
