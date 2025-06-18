package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.Evento;

public class EventoDao {
    
    private static Evento parse(ResultSet result) throws SQLException {
        Evento evento = new Evento();
        evento.setId(result.getLong("id"));
        evento.setUuid(result.getString("uuid"));
        evento.setTitulo(result.getString("titulo"));
        evento.setDescricao(result.getString("descricao"));
        evento.setDataInicio(result.getDate("data_inicio"));
        evento.setDataTermino(result.getDate("data_termino"));
        evento.setIdFormato(result.getLong("id_formato"));
        evento.setCreatedAt(result.getTimestamp("created_at"));
        evento.setUpdatedAt(result.getTimestamp("updated_at"));
        return evento;
    }
     public static Evento findById(long id) {
        String sql = "SELECT * FROM eventos WHERE id = ? LIMIT 1;";
        return Dao.executeQueryForSingleResult(
            sql,
            stmt -> stmt.setLong(1, id),
            EventoDao::parse,
            "Erro ao buscar evento por ID!",
            EventoDao.class
        );
    }
     public static Evento findByUuid(String uuid) {
        String sql = "SELECT * FROM eventos WHERE uuid = ? LIMIT 1;";
        return Dao.executeQueryForSingleResult(
            sql,
            stmt -> stmt.setString(1, uuid),
            EventoDao::parse,
            "Erro ao buscar evento por UUID!",
            EventoDao.class
        );
    }
      public static boolean create(Evento evento) {
        String sql = "INSERT INTO eventos (uuid, titulo, descricao, data_inicio, data_termino, id_formato, created_at, updated_at) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return Dao.execute(
            sql,
            stmt -> {
                stmt.setString(1, evento.getUuid());
                stmt.setString(2, evento.getTitulo());
                stmt.setString(3, evento.getDescricao());
                stmt.setDate(4, new java.sql.Date(evento.getDataInicio().getTime()));
                stmt.setDate(5, new java.sql.Date(evento.getDataTermino().getTime()));
                stmt.setLong(6, evento.getIdFormato());
                stmt.setTimestamp(7, new java.sql.Timestamp(new Date().getTime()));
                stmt.setTimestamp(8, new java.sql.Timestamp(new Date().getTime()));
            },
            "Erro ao criar evento!",
            EventoDao.class
        );
    }
}


