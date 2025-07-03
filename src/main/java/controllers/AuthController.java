package controllers;

import auth.Auth;
import exceptions.AuthenticationException;
import model.bean.User;
import usecases.CSCadastrarUsuario;

public class AuthController {

    public User login(String username, String password) throws AuthenticationException {
        if(Auth.check()) {
            return Auth.user();
        }

        User user = new User();
        
        user.setUsername(username);
        user.setPassword(password);

        return Auth.login(user);
    }

    public User store(User user) throws AuthenticationException {
        boolean sucess = new CSCadastrarUsuario().execute(user);

        if (sucess) {
            return this.login(user.getUsername(), user.getPassword());
        }

        return null;
    }

    public void logout() {
        Auth.logout();
    }
}
