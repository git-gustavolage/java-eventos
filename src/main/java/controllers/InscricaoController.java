package controllers;

import java.time.LocalDate;
import java.util.List;

import auth.Auth;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import model.bean.Evento;
import model.bean.Inscricao;
import model.bean.User;
import usecases.CSFindEventoById;
import usecases.CSInscrever;
import usecases.CSListarInscricoes;

public class InscricaoController {

    public boolean store(Inscricao inscricao) throws AuthenticationException, DomainException {

        User user = Auth.user();

        if (user == null) {
            throw new AuthenticationException("Não foi possível recuperar as informações do usuário! Faça login novamente!");
        }

        Evento evento = new CSFindEventoById().execute(inscricao.getId_evento());

        if (evento == null) {
            throw new DomainException("Evento nao encontrado!");
        }

        if (evento.isCancelado()) {
            throw new DomainException("Este evento foi cancelado.");
        }

        if (evento.getDataTermino().isBefore(LocalDate.now())) {
            throw new DomainException("O evento foi encerrado.");
        }

        if (!evento.isPublicado()) {
            throw new DomainException("Não é possivel se inscrever neste evento!");
        }

        inscricao.setId_usuario(user.getId());
        inscricao.setData(LocalDate.now());

        List<Inscricao> inscricoes = new CSListarInscricoes().execute(inscricao.getId_usuario());

        for (Inscricao i : inscricoes) {
            if (i.getId_evento().equals(inscricao.getId_evento())) {
                throw new DomainException("Você já está inscrito neste evento!");
            }
        }

        boolean sucess = new CSInscrever().execute(inscricao);

        if (!sucess) {
            throw new DomainException("Falha ao se inscrever no evento!");
        }

        return sucess;
    }

}
