package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Evento;
import model.dao.EventoDAO;

public class CSFindEventoById {

    /**
     * Busca um evento pelo id
     * 
     * @param id
     * @return o evento encontrado ou null caso nao seja encontrado
     */
    public Evento execute(Long id) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new EventoDAO().findById(conn, id);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
