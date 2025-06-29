package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import exceptions.DomainException;
import model.bean.Evento;
import model.dao.EventoDAO;

public class CSCadastrarEvento {

    /**
     * Cadastra um evento no banco de dados. Campos obrigatorios:
     * id_organizador, titulo, descricao, dataInicio, dataTermino, formato
     *
     * @param evento
     * @return (true) se o cadastro foi realizado com sucesso ou (false) caso tenha
     * ocorrido algum erro
     */
    public boolean execute(Evento evento) throws DomainException {
        if (evento == null) {
            return false;
        }

        LocalDate hoje = LocalDate.now();
        LocalDate inicio = toLocalDate(evento.getDataInicio());
        LocalDate termino = toLocalDate(evento.getDataTermino());

        if (termino.isBefore(inicio)) {
            throw new DomainException("A data de término não pode ser anterior à data de início.");
        }

        if (inicio.isBefore(hoje)) {
            throw new DomainException("A data de início não pode ser anterior à data atual.");
        }

        if (termino.isBefore(hoje)) {
            throw new DomainException("A data de término não pode ser anterior à data atual.");
        }

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new EventoDAO().create(conn, evento) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    private LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}
