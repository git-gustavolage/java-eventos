package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UsuarioDAO;

public class CSFindUserByID {

    /**
     * Busca um usuario pelo ID
     *
     * @param ID
     * @return o usuario encontrado ou null caso nao seja encontrado
     */
    public static User execute(Long ID) {
        User result;

        try (Connection conn = new ConnectionFactory().open()) {
            result = new UsuarioDAO().find(conn, ID);
        } catch (DatabaseException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
            result = null;
        }

        return result;
    }

}
