package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Inscricao;
import model.dao.InscricaoDAO;

public class CSInscrever {

    /**
     * Inscreve um usuario em um evento
     * 
     * @param inscricao
     * @return true se conseguiu inscrever ou false caso contrario
     */
    public boolean execute(Inscricao inscricao) {

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new InscricaoDAO().create(conn, inscricao) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }

    }

}
