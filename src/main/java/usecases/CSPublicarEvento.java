package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import exceptions.DomainException;
import model.bean.Evento;
import model.dao.EventoDAO;

public class CSPublicarEvento {

    /**
     * Publica um evento
     *
     * @param id
     * @return (true) se conseguiu publicar o evento ou (false) caso contrario
     * @throws DomainException caso tenha ocorrido algum erro de domínio
     */
    public boolean execute(Long id) throws DomainException {
        Evento evento = new CSFindEventoById().execute(id);

        if (evento == null) {
            return false;
        }

        if (evento.isPublicado()) {
            return true;
        }

        if (evento.isCancelado()) {
            throw new DomainException("Não é possivel publicar um evento cancelado.");
        }

        if (evento.getDataTermino().isBefore(LocalDate.now())) {
            throw new DomainException("Não é possivel publicar um evento cuja data de termino ja passou.");
        }

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new EventoDAO().publish(conn, id) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

}
