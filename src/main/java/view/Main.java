package view;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import auth.Auth;
import controllers.AuthController;
import controllers.EventoController;
import exceptions.AuthenticationException;
import exceptions.DomainException;
import exceptions.InvalidInputException;
import model.bean.Evento;
import model.bean.User;
import model.vo.EventoFormato;

public class Main {

    public static void main(String[] args) {

        try {
        new AuthController().login("email@gmail.com", "12345678");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao efetuar login: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = Auth.user();

        if (user == null) {
            System.out.println("Erro ao efetuar login!");
            return;
        }


        try {
            Evento evento = new Evento();
            evento.setTitulo("titulo");
            evento.setDescricao("descricao");
            evento.setFormato(EventoFormato.valueOf("ONLINE"));
            evento.setDataInicio(LocalDate.parse("2025-07-10"));
            evento.setDataTermino(LocalDate.parse("2025-07-10"));

            new EventoController().store(evento);

            JOptionPane.showMessageDialog(null, "Evento salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            // this.dispose();

            // Tela_cadastro_atividades next = new Tela_cadastro_atividades();
            // next.setVisible(true);

        } catch (InvalidInputException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (DomainException | AuthenticationException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o evento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

}
