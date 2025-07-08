package usecases;

import java.sql.Connection;
import java.sql.SQLException;

import database.ConnectionFactory;
import exceptions.AuthenticationException;
import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UsuarioDAO;

public class CSCadastrarUsuario {

    private final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    private boolean isValidEmail(String email) {
        return email.matches(EMAIL_REGEX);
    }

    /**
     * Cadastra um usuario no banco de dados. 
     * Campos obrigatorios: nome, email, password
     *
     * @param user
     * @return (true) se o cadastro foi realizado com sucesso ou (false) caso
     * tenha ocorrido algum erro
     * @throws AuthenticationException caso tenha ocorrido algum erro no
     * cadastro
     */
    public boolean execute(User user) throws AuthenticationException {

        if (user.getNome() == null || user.getNome().isEmpty()) {
            throw new AuthenticationException("Informe o nome!");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new AuthenticationException("Informe o email!");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new AuthenticationException("Informe a senha!");
        }

        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new AuthenticationException("A senha deve ter no mínimo 8 caracteres!");
        }

        if(!isValidEmail(user.getEmail())){ 
            throw new AuthenticationException("Email inválido!");
        }

        try (Connection conn = ConnectionFactory.getNewConnection()) {
            
            if(new UsuarioDAO().create(conn, user) == 1){
                return true;
            }

            throw new AuthenticationException("Erro ao efetuar cadastro!");
        } catch (DatabaseException | SQLException e) {
            throw new AuthenticationException("Erro ao efetuar cadastro!\n " + e.getMessage());
        }
    }

}
