package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Ambiente;
import model.dao.AmbienteDao;

public class CSCadastrarAmbiente {

    /**
     * Cadastra um ambiente. Campos obrigatorios: nome, descricao
     * 
     * @param ambiente
     * @return true se cadastrou, false caso contrario
     */
    public boolean execute(Ambiente ambiente) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AmbienteDao().create(conn, ambiente) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

}
