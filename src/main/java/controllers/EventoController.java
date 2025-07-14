package controllers;

import java.util.List;

import auth.Auth;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import exceptions.InvalidInputException;
import model.bean.Evento;
import model.bean.User;
import usecases.CSCadastrarEvento;
import usecases.CSFindUserByID;
import usecases.CSListarEventos;

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

    public List<Evento> list() {
        List<Evento> eventos = new CSListarEventos().execute();

        if (eventos == null) {
            return null;
        }

        if (eventos.isEmpty()) {
            return null;
        }

        for (Evento e : eventos) {
            User organizador = new CSFindUserByID().execute(e.getId_organizador());
            e.setOrganizador(organizador);
        }

        return eventos;
    }
}
