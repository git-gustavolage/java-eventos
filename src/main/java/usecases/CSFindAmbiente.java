package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Ambiente;
import model.dao.AmbienteDao;

public class CSFindAmbiente {

    /**
     * Busca um ambiente pelo id
     * 
     * @param id
     * @return o ambiente encontrado ou null caso nao seja encontrado
     */
    public Ambiente execute(Long id) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AmbienteDao().find(conn, id);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
