package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Ambiente;
import model.dao.AmbienteDAO;

public class CSListarAmbientes {

    /**
     * Lista todos os ambientes cadastrados
     * 
     * @return uma lista com todos os ambientes cadastrados ou null em caso de erro
     */
    public List<Ambiente> execute() {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AmbienteDAO().all(conn);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
