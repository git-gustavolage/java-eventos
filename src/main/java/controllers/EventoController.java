package controllers;

import java.util.List;

import auth.Auth;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import exceptions.InvalidInputException;
import model.bean.Atividade;
import model.bean.Evento;
import model.bean.User;
import usecases.CSCadastrarEvento;
import usecases.CSFindEventoById;
import usecases.CSListarAtividades;

public class EventoController {

    public void store(Evento evento) throws AuthenticationException, InvalidInputException, DomainException {

        User user = Auth.user();

        if (user == null) {
            throw new AuthenticationException("Não foi possível recuperar as informações do usuário! Faça login novamente!");
        }

        if (evento.getTitulo() == null || evento.getTitulo().isEmpty()) {
            throw new InvalidInputException("Informe o titulo!");
        }

        if (evento.getDescricao() == null || evento.getDescricao().isEmpty()) {
            throw new InvalidInputException("Informe a descricao!");
        }

        if (evento.getFormato() == null || evento.getFormato().toString().isEmpty()) {
            throw new InvalidInputException("Informe a categoria!");
        }

        if (evento.getDataInicio() == null) {
            throw new InvalidInputException("Informe a data de inicio!");
        }

        if (evento.getDataTermino() == null) {
            throw new InvalidInputException("Informe a data de termino!");
        }

        evento.setId_organizador(user.getId());

        //TODO: validar cidade, estado e campus
        boolean sucesso = false;

        try {
            sucesso = new CSCadastrarEvento().execute(evento);
        } catch (DomainException e) {
            throw new DomainException(e.getMessage());
        }

        if (sucesso == false) {
            throw new DomainException("Erro ao cadastrar o evento!");
        }
    }

    public Evento find(Long id) {
        return new CSFindEventoById().execute(id);
    }

    public List<Atividade> atividades(Long id_evento) {
        return new CSListarAtividades().execute(id_evento);
    }

}
