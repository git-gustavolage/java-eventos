package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Atividade;
import model.dao.AtividadeDao;

public class CSFindAtividade {

    /**
     * Busca uma atividade pelo id
     * 
     * @param id
     * @return a atividade encontrada ou null caso nao seja encontrada
     */
    public Atividade execute(Long id) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AtividadeDao().find(conn, id);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
