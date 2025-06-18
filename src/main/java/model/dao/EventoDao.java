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
}
