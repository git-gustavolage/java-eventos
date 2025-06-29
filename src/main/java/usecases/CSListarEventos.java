package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Evento;
import model.dao.EventoDAO;

public class CSListarEventos {

    /**
     * Listar todos os eventos cadastrados no banco
     * 
     * @return uma lista de eventos
     */
    public List<Evento> execute() {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new EventoDAO().all(conn);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
