package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.bean.Atividade;

public class AtividadeDao {

    private static Atividade parse(ResultSet result) throws SQLException {
        try {
            Atividade atividade = new Atividade();
            atividade.setId(result.getLong("id"));
            atividade.setId_evento(result.getLong("id_evento"));
            atividade.setId_responsavel(result.getLong("id_responsavel"));
            atividade.setId_ambiente(result.getLong("id_ambiente"));
            atividade.setTitulo(result.getString("titulo"));
            atividade.setDescricao(result.getString("descricao"));
            atividade.setHora_inicio(result.getTime("hora_inicio").toLocalTime());
            atividade.setHora_termino(result.getTime("hora_termino").toLocalTime());
            return atividade;
        } catch (SQLException e) {
            return null;
        }
    }

    public static Atividade findById(Long id) {
        String sql = "SELECT * FROM atividades WHERE id = ? LIMIT 1;";
        return Dao.executeQueryForSingleResult(sql,
                stmt -> stmt.setLong(1, id),
                AtividadeDao::parse,
                "Erro ao buscar atividade!",
                AtividadeDao.class
        );
    }

    public static List<Atividade> findByTitulo(String titulo) {
        String tituloTratado = "%" + titulo + "%";
        String sql = "SELECT * FROM atividades WHERE titulo like ?;";
        return Dao.executeQueryForMultipleResults(sql,
                stmt -> stmt.setString(1, tituloTratado),
                AtividadeDao::parse,
                "Erro ao buscar atividade!",
                AtividadeDao.class
        );
    }

    public static boolean create(Atividade atividade) {
        String sql = "INSERT INTO atividades (id_evento, id_responsavel, id_ambiente, titulo, descricao, hora_inicio, hora_termino) VALUES (?, ?, ?, ?, ?, ?, ?);";
        return Dao.execute(
                sql,
                stmt -> {
                    stmt.setLong(1, atividade.getId_evento());
                    stmt.setLong(2, atividade.getId_responsavel());
                    stmt.setLong(3, atividade.getId_ambiente());
                    stmt.setString(4, atividade.getTitulo());
                    stmt.setString(5, atividade.getDescricao());
                    stmt.setTime(6, java.sql.Time.valueOf(atividade.getHora_inicio()));
                    stmt.setTime(7, java.sql.Time.valueOf(atividade.getHora_termino()));
                },
                "Erro ao criar atividade!",
                AtividadeDao.class
        );
    }

    public static boolean update(Atividade atividade) {
        String sql = "UPDATE atividades SET id_evento = ?, id_responsavel = ?, id_ambiente = ?, titulo = ?, descricao = ?, hora_inicio = ?, hora_termino = ? WHERE id = ?;";
        return Dao.execute(sql,
                stmt -> {
                    stmt.setLong(1, atividade.getId_evento());
                    stmt.setLong(2, atividade.getId_responsavel());
                    stmt.setLong(3, atividade.getId_ambiente());
                    stmt.setString(4, atividade.getTitulo());
                    stmt.setString(5, atividade.getDescricao());
                    stmt.setTime(6, java.sql.Time.valueOf(atividade.getHora_inicio()));
                    stmt.setTime(7, java.sql.Time.valueOf(atividade.getHora_termino()));
                    stmt.setLong(8, atividade.getId());
                },
                "Erro ao atualizar atividade!",
                AtividadeDao.class
        );
    }

    public static boolean destroy(long id) {
        String sql = "DELETE FROM atividades WHERE id = ?;";
        return Dao.execute(sql,
                stmt -> stmt.setLong(1, id),
                "Erro ao deletar atividade!",
                AtividadeDao.class
        );
    }

}
