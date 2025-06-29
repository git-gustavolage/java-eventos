package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import exceptions.DatabaseException;
import model.bean.Ambiente;

public class AmbienteDAO {

    private Ambiente parse(ResultSet result) throws DatabaseException {
        try {
            Ambiente ambiente = new Ambiente();
            ambiente.setId(result.getLong("id"));
            ambiente.setNome(result.getString("nome"));
            ambiente.setDescricao(result.getString("descricao"));
            return ambiente;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public int create(Connection conn, Ambiente ambiente) throws DatabaseException {
        String sql = "INSERT INTO ambientes (nome, descricao) VALUES (?, ?)";
        return new DB().executeUpdate(conn, sql, stmt -> {
            stmt.setString(1, ambiente.getNome());
            stmt.setString(2, ambiente.getDescricao());
        });
    }

    public Ambiente find(Connection conn, Long id) throws DatabaseException {
        String sql = "SELECT * FROM ambientes WHERE id = (?)";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id), rs -> {
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

    public List<Ambiente> all(Connection conn) throws DatabaseException {
        String sql = "SELECT * FROM ambientes";
        return new DB().executeQuery(conn, sql, stmt -> {}, rs -> {
            List<Ambiente> ambientes = new ArrayList<>();
            while (rs.next()) {
                ambientes.add(parse(rs));
            }
            return ambientes;
        });
    }

    public int delete(Connection conn, Long id) throws DatabaseException {
        String sql = "DELETE FROM ambientes WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }
}
