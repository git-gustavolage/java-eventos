package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import database.DB;
import exceptions.DatabaseException;
import model.bean.Atividade;

public class AtividadeDao {

    private Atividade parse(ResultSet result) throws SQLException {
        try {
            Atividade atividade = new Atividade();
            atividade.setId(result.getLong("id"));
            atividade.setId_evento(result.getLong("id_evento"));
            atividade.setId_responsavel(result.getLong("id_responsavel"));
            atividade.setId_ambiente(result.getLong("id_ambiente"));
            atividade.setTitulo(result.getString("titulo"));
            atividade.setDescricao(result.getString("descricao"));
            atividade.setData(result.getDate("data").toLocalDate());
            atividade.setHora_inicio(result.getTime("hora_inicio").toLocalTime());
            atividade.setHora_termino(result.getTime("hora_termino").toLocalTime());
            atividade.setCancelada(result.getBoolean("is_cancelada"));
            return atividade;
        } catch (SQLException e) {
            return null;
        }
    }

    public int create(Connection conn, Atividade atividade) throws DatabaseException {
        String sql = "INSERT INTO atividades (id_evento, id_responsavel, id_ambiente, titulo, descricao, data, hora_inicio, hora_termino) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        return new DB().executeUpdate(conn, sql, stmt -> {
            stmt.setLong(1, atividade.getId_evento());
            stmt.setLong(2, atividade.getId_responsavel());
            stmt.setLong(3, atividade.getId_ambiente());
            stmt.setString(4, atividade.getTitulo());
            stmt.setString(5, atividade.getDescricao());
            stmt.setString(6, atividade.getData().toString());
            stmt.setTime(7, Time.valueOf(atividade.getHora_inicio()));
            stmt.setTime(8, Time.valueOf(atividade.getHora_termino()));
        });
    }

    public Atividade find(Connection conn, Long id) throws DatabaseException {
        String sql = "SELECT * FROM atividades WHERE id = ? LIMIT 1;";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id), rs ->{
            if (rs.next()) {
                return parse(rs);
            }
            return null;
        });
    }

    public List<Atividade> all(Connection conn) throws DatabaseException {
        String sql = "SELECT * FROM atividades";
        return new DB().executeQuery(conn, sql, stmt -> {}, rs -> {
            List<Atividade> atividades = new ArrayList<>();
            while (rs.next()) {
                atividades.add(parse(rs));
            }
            return atividades;
        });
    }


    public List<Atividade> all(Connection conn, Long id_evento) throws DatabaseException {
        String sql = "SELECT * FROM atividades WHERE id_evento = ?;";
        return new DB().executeQuery(conn, sql, stmt -> stmt.setLong(1, id_evento), rs -> {
            List<Atividade> atividades = new ArrayList<>();
            while (rs.next()) {
                atividades.add(parse(rs));
            }
            return atividades;
        });
    }

    public int cancel(Connection conn, Long id) throws DatabaseException {
        String sql = "UPDATE atividades SET is_cancelada = 1 WHERE id = (?)";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }

    public int delete(Connection conn, Long id) throws DatabaseException {
        String sql = "DELETE FROM atividades WHERE id = ?;";
        return new DB().executeUpdate(conn, sql, stmt -> stmt.setLong(1, id));
    }
}
