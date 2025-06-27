package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Evento;
import model.vo.EventoFormato;

public class EventoDao {

    // private static Evento parse(ResultSet result) throws SQLException {
    //     Evento evento = new Evento();
    //     evento.setId(result.getLong("id"));
    //     evento.setTitulo(result.getString("titulo"));
    //     evento.setDescricao(result.getString("descricao"));
    //     evento.setDataInicio(result.getDate("data_inicio"));
    //     evento.setDataTermino(result.getDate("data_termino"));
    //     evento.setFormato(EventoFormato.valueOf(result.getString("formato")));
    //     return evento;
    // }

    // public static Evento findById(long id) {
    //     String sql = "SELECT * FROM eventos WHERE id = ? LIMIT 1;";
    //     return Dao.executeQueryForSingleResult(
    //             sql,
    //             stmt -> stmt.setLong(1, id),
    //             EventoDao::parse,
    //             "Erro ao buscar evento por ID!",
    //             EventoDao.class
    //     );
    // }

    // public static boolean create(Evento evento) {
    //     String sql = "INSERT INTO eventos (titulo, descricao, data_inicio, data_termino, formato) VALUES (?, ?, ?, ?, ?);";
    //     return Dao.execute(
    //             sql,
    //             stmt -> {
    //                 stmt.setString(1, evento.getTitulo());
    //                 stmt.setString(2, evento.getDescricao());
    //                 stmt.setDate(3, new java.sql.Date(evento.getDataInicio().getTime()));
    //                 stmt.setDate(4, new java.sql.Date(evento.getDataTermino().getTime()));
    //                 stmt.setString(5, evento.getFormato());
    //             },
    //             "Erro ao criar evento!",
    //             EventoDao.class
    //     );
    // }

    // public static boolean update(Evento evento) {
    //     String sql = "UPDATE eventos SET titulo = ?, descricao = ?, data_inicio = ?, data_termino = ?, formato = ? WHERE id = ?";
    //     return Dao.execute(
    //             sql,
    //             stmt -> {
    //                 stmt.setString(1, evento.getTitulo());
    //                 stmt.setString(2, evento.getDescricao());
    //                 stmt.setDate(3, new java.sql.Date(evento.getDataInicio().getTime()));
    //                 stmt.setDate(4, new java.sql.Date(evento.getDataTermino().getTime()));
    //                 stmt.setString(5, evento.getFormato());
    //                 stmt.setLong(6, evento.getId());
    //             },
    //             "Erro ao atualizar evento!",
    //             EventoDao.class
    //     );
    // }

    // public static boolean destroy(long id) {
    //     String sql = "DELETE FROM eventos WHERE id = ?";
    //     return Dao.execute(
    //             sql,
    //             stmt -> stmt.setLong(1, id),
    //             "Erro ao deletar evento!",
    //             EventoDao.class
    //     );
    // }
}
