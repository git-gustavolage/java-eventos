package controllers;

import auth.Auth;
import exceptions.AuthenticationException;
import model.bean.User;

public class AuthController {

    public User login(String username, String password) throws AuthenticationException {
        User user = new User();
        
        user.setUsername(username);
        user.setPassword(password);

        Auth.login(user);

        return Auth.user();
    }
}
