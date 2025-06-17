package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Ambiente;

public class AmbienteDao {

    private static Ambiente parse(ResultSet result) throws SQLException {
        Ambiente ambiente = new Ambiente();
        ambiente.setId(result.getInt("id"));
        ambiente.setNome(result.getString("nome"));
        ambiente.setDescricao(result.getString("descricao"));
        return ambiente;
    }

    public static Ambiente findById(int id) {
        String sql = "SELECT * FROM ambientes WHERE id = ? LIMIT 1;";
        return Dao.executeQueryForSingleResult(sql,
                stmt -> stmt.setInt(1, id),
                AmbienteDao::parse,
                "Erro ao buscar ambiente!",
                AmbienteDao.class);
    }

    public static boolean create(Ambiente ambiente) {
        String sql = "INSERT INTO ambientes (nome, descricao) VALUES (?, ?)";
        return Dao.execute(sql,
                stmt -> {
                    stmt.setString(1, ambiente.getNome());
                    stmt.setString(2, ambiente.getDescricao());
                },
                "Erro ao criar ambiente!",
                AmbienteDao.class);
    }

    public static boolean update(Ambiente ambiente) {
        String sql = "UPDATE ambientes SET nome = ?, descricao = ? WHERE id = ?";
        return Dao.execute(sql,
                stmt -> {
                    stmt.setString(1, ambiente.getNome());
                    stmt.setString(2, ambiente.getDescricao());
                    stmt.setInt(3, ambiente.getId());
                },
                "Erro ao atualizar ambiente!",
                AmbienteDao.class);
    }

    public static boolean destroy(Ambiente ambiente) {
        String sql = "DELETE FROM ambientes WHERE id = ?";
        return Dao.execute(sql,
                stmt -> stmt.setInt(1, ambiente.getId()),
                "Erro ao deletar ambiente!",
                AmbienteDao.class);
    }
}
