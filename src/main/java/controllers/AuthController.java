package controllers;

import auth.Auth;
import model.bean.User;

public class AuthController {

    public void login(String username, String password) {
        User user = new User();
        
        user.setUsername(username);
        user.setPassword(password);

        Auth.login(user);

        if(Auth.guest()){
            //adicionar erros na sessão e retornar para a tela de login
        }

        if(Auth.check()){
            //redirecionar para a tela principal
        }
    }
}
