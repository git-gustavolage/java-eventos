package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DB;
import exceptions.DatabaseException;
import model.bean.Evento;
import model.vo.EventoFormato;

public class EventoDAO {

    public int create(Connection conn, Evento evento) throws DatabaseException {
        String sql = "INSERT INTO eventos (id_organizador, titulo, descricao, data_inicio, data_termino, formato) VALUES (?, ?, ?, ?, ?, ?);";

        return new DB().executeUpdate(conn, sql, stmt -> {
            stmt.setLong(1, evento.getId_organizador());
            stmt.setString(2, evento.getTitulo());
            stmt.setString(3, evento.getDescricao());
            stmt.setDate(4, new java.sql.Date(evento.getDataInicio().getTime()));
            stmt.setDate(5, new java.sql.Date(evento.getDataTermino().getTime()));
            stmt.setString(6, evento.getFormatoNome());
        });
    }

    public Evento findById(Connection conn, Long id) throws DatabaseException {
        String sql = "SELECT * FROM eventos WHERE id = ? LIMIT 1;";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id), rs -> parse(rs));
    }

    public int delete(Connection conn, Long id) throws DatabaseException {
        String sql = "DELETE FROM eventos WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }

    public int publish(Connection conn, Long id) throws DatabaseException {
        String sql = "UPDATE eventos SET is_publicado = 1 WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }

    public int cancel(Connection conn, Long id) throws DatabaseException {
        String sql = "UPDATE eventos SET is_cancelado = 1 WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }

    private Evento parse(ResultSet rs) throws DatabaseException {
        try (rs) {
            Evento evento = new Evento();
            evento.setId(rs.getLong("id"));
            evento.setTitulo(rs.getString("titulo"));
            evento.setDescricao(rs.getString("descricao"));
            evento.setDataInicio(rs.getDate("data_inicio"));
            evento.setDataTermino(rs.getDate("data_termino"));
            evento.setFormato(EventoFormato.valueOf(rs.getString("formato")));
            return evento;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
