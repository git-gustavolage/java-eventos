package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import exceptions.DatabaseException;
import model.bean.Inscricao;

public class InscricaoDAO {

    public int create(Connection conn, Inscricao inscricao) throws DatabaseException {
        String sql = "INSERT INTO inscricoes (id_usuario, id_evento, categoria, data) VALUES (?, ?, ?, ?)";

        return new DB().executeUpdate(conn, sql, stmt -> {
            stmt.setLong(1, inscricao.getId_usuario());
            stmt.setLong(2, inscricao.getId_evento());
            stmt.setString(3, inscricao.getCategoria());
            stmt.setString(4, inscricao.getData().toString());
        });
    }

    public Inscricao findById(Connection conn, Long id) throws DatabaseException {
        String sql = "SELECT * FROM inscricoes WHERE id = ? LIMIT 1;";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id), rs -> {
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

    public int delete(Connection conn, Long id) throws DatabaseException {
        String sql = "DELETE FROM inscricoes WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }

    public List<Inscricao> all(Connection conn) throws DatabaseException {
        String sql = "SELECT * FROM inscricoes;";

        return new DB().executeQuery(conn, sql, stmt -> {}, rs -> {
            List<Inscricao> inscricoes = new ArrayList<>();
            while (rs.next()) {
                inscricoes.add(parse(rs));
            }
            return inscricoes;
        });
    }

    public List<Inscricao> all(Connection conn, Long id_usuario) throws DatabaseException {
        String sql = "SELECT * FROM inscricoes WHERE id_usuario = (?);";

        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id_usuario), rs -> {
            List<Inscricao> inscricoes = new ArrayList<>();
            while (rs.next()) {
                inscricoes.add(parse(rs));
            }
            return inscricoes;
        });
    }

    public Inscricao parse(ResultSet rs) throws DatabaseException {
        try {
            Inscricao inscricao = new Inscricao();
            inscricao.setId(rs.getLong("id"));
            inscricao.setId_usuario(rs.getLong("id_usuario"));
            inscricao.setId_evento(rs.getLong("id_evento"));
            inscricao.setCategoria(rs.getString("categoria"));
            inscricao.setData(rs.getDate("data").toLocalDate());
            return inscricao;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}
