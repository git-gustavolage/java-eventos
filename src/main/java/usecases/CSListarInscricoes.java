package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Inscricao;
import model.dao.InscricaoDAO;

public class CSListarInscricoes {

    public List<Inscricao> execute() {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new InscricaoDAO().all(conn);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Inscricao> execute(Long id_usuario) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new InscricaoDAO().all(conn, id_usuario);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
