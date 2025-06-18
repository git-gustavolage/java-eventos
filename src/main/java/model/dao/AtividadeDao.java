package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Atividade;

public class AtividadeDao {

    private static Atividade parse(ResultSet result) throws SQLException {
        try {
            Atividade atividade = new Atividade();
            atividade.setId((long) result.getInt("id"));
            atividade.setId_evento((long) result.getInt("id_evento"));
            atividade.setId_responsavel((long) result.getInt("id_responsavel"));
            atividade.setId_ambiente((long) result.getInt("id_ambiente"));
            atividade.setTitulo(result.getString("titulo"));
            atividade.setDescricao(result.getString("descricao"));
            atividade.setHora_inicio(result.getTime("hora_inicio").toLocalTime());
            atividade.setHora_termino(result.getTime("hora_termino").toLocalTime());
            atividade.setIs_cancelada(result.getBoolean("is_cancelada"));
            return atividade;
        } catch (SQLException e) {
            return null;
        }
    }

    public static Atividade findById(Integer id) {
        String sql = "SELECT * FROM atividades WHERE id = ? LIMIT 1;";
        return Dao.executeQueryForSingleResult(sql,
                stmt -> stmt.setInt(1, id),
                AtividadeDao::parse,
                "Erro ao buscar atividade!",
                AtividadeDao.class
        );
    }
}
