package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Evento;
import model.dao.EventoDAO;

public class CSListarEventosPublicados {

    /**
     * Listar todos os eventos cadastrados no banco e que tenham sido publicados
     * 
     * @return uma lista de eventos publicados
     */
    public List<Evento> execute() {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new EventoDAO().all(conn, true);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
