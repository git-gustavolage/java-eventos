package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import exceptions.DomainException;
import model.bean.Atividade;
import model.bean.Evento;
import model.dao.AtividadeDao;

public class CSCancelarAtividade {

    public boolean execute(Long id) throws DomainException {

        if (id == null) {
            throw new DomainException("Atividade não encontrada.");
        }

        Atividade atividade = new CSFindAtividade().execute(id);

        if (atividade == null) {
            throw new DomainException("Atividade não encontrada.");
        }

        if (atividade.isCancelada()) {
            return true;
        }

        if (atividade.getData().isBefore(LocalDate.now())) {
            throw new DomainException("Não é possível cancelar uma atividade já finalizada.");
        }

        Evento evento = new CSFindEventoById().execute(atividade.getId_evento());

        if (evento == null) {
            throw new DomainException("Evento não encontrado.");
        }

        if (evento.getDataTermino().isBefore(LocalDate.now())) {
            throw new DomainException("Não é possivel cancelar atividades de um evento encerrado.");
        }

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AtividadeDao().cancel(conn, id) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
        
    }

}
