package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UsuarioDAO;

public class CSFindUserByEmail {

    /**
     * Busca um usuario pelo email
     *
     * @param email
     * @return o usuario encontrado ou null caso nao seja encontrado
     */
    public static User execute(String email) {
        User result;

        try (Connection conn = new ConnectionFactory().open()) {
            result = new UsuarioDAO().findByEmail(conn, email);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            result = null;
        }

        return result;
    }

}
