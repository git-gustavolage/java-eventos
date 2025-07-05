package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.Atividade;
import model.dao.AtividadeDAO;

public class CSListarAtividades {

    /**
     * Listar todas as atividades de um evento específico cadastradas no banco
     *
     * @return uma lista de atividades de um evento
     */
    public List<Atividade> execute(Long id_evento) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AtividadeDAO().all(conn, id_evento);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    /**
     * Listar todas as atividades cadastradas no banco
     *
     * @return uma lista de atividades
     */
    public List<Atividade> execute() {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AtividadeDAO().all(conn);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

}
