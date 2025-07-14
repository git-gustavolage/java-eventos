package controllers;

import java.util.List;

import auth.Auth;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import exceptions.InvalidInputException;
import model.bean.Ambiente;
import model.bean.Atividade;
import model.bean.Evento;
import model.bean.User;
import usecases.CSCadastrarAtividade;
import usecases.CSListarAmbientes;
import usecases.CSListarEventos;

public class AtividadeController {

    public boolean store(Atividade atividade, String evento, String ambiente) throws AuthenticationException, InvalidInputException, DomainException {

        System.out.println("\n\n\n");
        System.out.println("Evento no controller: " + evento);
        System.out.println("Ambiente no controller: " + ambiente);
        System.out.println("Atividade no controller: " + atividade.toString());
        System.out.println("\n\n\n");

        User user = Auth.user();

        if (user == null) {
            throw new AuthenticationException("Não foi possível recuperar as informações do usuário! Faça login novamente!");
        }

        if (atividade.getTitulo() == null || atividade.getTitulo().isEmpty()) {
            throw new InvalidInputException("Informe o titulo!");
        }

        if (atividade.getDescricao() == null || atividade.getDescricao().isEmpty()) {
            throw new InvalidInputException("Informe a descricao!");
        }

        if (atividade.getData() == null) {
            throw new InvalidInputException("Data inválida!");
        }

        if (atividade.getHora_inicio() == null) {
            throw new InvalidInputException("Hora de inicio inválida!");
        }

        if (atividade.getHora_termino() == null) {
            throw new InvalidInputException("Hora de termino inválida!");
        }

        List<Evento> eventos = new CSListarEventos().execute();
        for (Evento e : eventos) {
            System.out.println(e.toString());
            if (e.getTitulo().equals(evento)) {
                System.out.println("\nSelecionado: " + e.toString());
                atividade.setId_evento(e.getId());
                break;
            }
        }

        if(atividade.getId_evento() == null) {
            throw new InvalidInputException("Evento nao encontrado!");
        }

        List<Ambiente> ambientes = new CSListarAmbientes().execute();
        for (Ambiente a : ambientes) {
            System.out.println(a.toString());
            if (a.getNome().equals(ambiente)) {
                System.out.println("\nSelecionado: " + a.toString());
                atividade.setId_ambiente(a.getId());
                break;
            }
        }

        if(atividade.getId_ambiente() == null) {
            throw new InvalidInputException("Ambiente nao encontrado!");
        }

        System.out.println("\n\nAtividade no controller: " + atividade.toString());

        atividade.setId_responsavel(user.getId());

        boolean sucesso = new CSCadastrarAtividade().execute(atividade);

        if (sucesso == false) {
            throw new DomainException("Erro ao cadastrar atividade!");
        }

        return sucesso;
    }

}
