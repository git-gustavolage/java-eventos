package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Ambiente;
import model.dao.AmbienteDAO;

public class CSCadastrarAmbiente {

    /**
     * Cadastra um ambiente. Campos obrigatorios: nome, descricao
     * 
     * @param ambiente
     * @return true se cadastrou, false caso contrario
     */
    public boolean execute(Ambiente ambiente) {

        //TODO: adicionar constraint unique para a coluna "nome" da tabela ambientes

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AmbienteDAO().create(conn, ambiente) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

}
