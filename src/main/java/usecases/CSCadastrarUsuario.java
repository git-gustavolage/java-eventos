package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UsuarioDAO;

public class CSCadastrarUsuario {

    /**
     * Cadastra um usuario no banco de dados. Campos obrigatorios: username,
     * nome, email, password
     *
     * @param user
     * @return (true) se o cadastro foi realizado com sucesso ou (false) caso tenha
     * ocorrido algum erro
     */
    public boolean execute(User user) {
        try (Connection conn = ConnectionFactory.getNewConnection()) {
            return new UsuarioDAO().create(conn, user) == 1;
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

}
