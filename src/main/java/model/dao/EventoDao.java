package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Evento> all(Connection conn) throws DatabaseException {
        String sql = "SELECT * FROM eventos";
        return new DB().executeQuery(conn, sql, stmt -> {}, rs -> {
            List<Evento> eventos = new ArrayList<>();
            while (rs.next()) {
                eventos.add(parse(rs));
            }
            return eventos;
        });
    }

    public List<Evento> all(Connection conn, Long id_organizador) throws DatabaseException {
        String sql = "SELECT * FROM eventos WHERE id_organizador = (?)";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id_organizador), rs -> {
            List<Evento> eventos = new ArrayList<>();
            while (rs.next()) {
                eventos.add(parse(rs));
            }
            return eventos;
        });
    }

    public List<Evento> all(Connection conn, boolean is_publicado) throws DatabaseException {
        String sql = "SELECT * FROM eventos WHERE is_publicado = (?)";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setBoolean(1, is_publicado), rs -> {
            List<Evento> eventos = new ArrayList<>();
            while (rs.next()) {
                eventos.add(parse(rs));
            }
            return eventos;
        });
    }

    public List<Evento> all(Connection conn, EventoFormato formato) throws DatabaseException {
        String sql = "SELECT * FROM eventos WHERE formato = (?)";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setString(1, formato.toString()), rs -> {
            List<Evento> eventos = new ArrayList<>();
            while (rs.next()) {
                eventos.add(parse(rs));
            }
            return eventos;
        });
    }

    private Evento parse(ResultSet rs) throws DatabaseException {
        try {
            Evento evento = new Evento();
            evento.setId(rs.getLong("id"));
            evento.setId_organizador(rs.getLong("id_organizador"));
            evento.setTitulo(rs.getString("titulo"));
            evento.setDescricao(rs.getString("descricao"));
            evento.setDataInicio(rs.getDate("data_inicio"));
            evento.setDataTermino(rs.getDate("data_termino"));
            evento.setFormato(EventoFormato.valueOf(rs.getString("formato")));
            evento.setPublicado(rs.getBoolean("is_publicado"));
            evento.setCancelado(rs.getBoolean("is_cancelado"));
            return evento;
        } catch (SQLException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
