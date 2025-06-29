package usecases;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import exceptions.DomainException;
import model.bean.Atividade;
import model.bean.Evento;
import model.dao.AtividadeDao;

public class CSCadastrarAtividade {

    /**
     * Cadastra uma atividade. Campos obrigatorios: id_organizador, id_evento,
     * id_ambiente, titulo, descricao, data, hora_inicio, hora_termino
     *
     * @param atividade
     * @return (true) se o cadastro foi realizado com sucesso ou (false) caso
     * tenha ocorrido algum erro
     * @throws DomainException caso tenha ocorrido algum erro de domínio
     */
    public boolean execute(Atividade atividade) throws DomainException {
        if (atividade == null) {
            throw new DomainException("Atividade não encontrada.");
        }

        Evento evento = new CSFindEventoById().execute(atividade.getId_evento());
        if (evento == null) {
            throw new DomainException("Evento não encontrado.");
        }

        if (evento.isCancelado()) {
            throw new DomainException("Não é possível adicionar uma atividade em um evento cancelado.");
        }

        LocalDate dataAtividade = atividade.getData();
        LocalDate dataHoje = LocalDate.now();
        if (dataAtividade.isBefore(dataHoje)) {
            throw new DomainException("A data da atividade não pode ser anterior ao dia atual.");
        }

        // início < hora término
        if (!atividade.getHora_inicio().isBefore(atividade.getHora_termino())) {
            throw new DomainException("A hora de início deve ser anterior à hora de término.");
        }

        // atividade está dentro do período do evento
        LocalDate dataEventoInicio = evento.getDataInicio();
        LocalDate dataEventoFim = evento.getDataTermino();
        if (dataAtividade.isBefore(dataEventoInicio) || dataAtividade.isAfter(dataEventoFim)) {
            throw new DomainException("A data da atividade deve estar dentro do período do evento.");
        }

        // conflitos de horário no ambiente
        List<Atividade> atividades = new CSListarAtividades().execute();
        for (Atividade atividadeAux : atividades) {
            if(atividadeAux.isCancelada()) {
                continue;
            }
            
            if (Objects.equals(atividadeAux.getId_ambiente(), atividade.getId_ambiente())
                    && atividadeAux.getData().equals(dataAtividade)) {

                boolean sobrepoe = atividadeAux.getHora_inicio().isBefore(atividade.getHora_termino())
                        && atividade.getHora_inicio().isBefore(atividadeAux.getHora_termino());

                if (sobrepoe) {
                    throw new DomainException("Ambiente não disponível para o horário informado.");
                }
            }
        }

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new AtividadeDao().create(conn, atividade) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

}
