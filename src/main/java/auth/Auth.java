package auth;

import exceptions.AuthenticationException;
import model.bean.User;
import support.Hash;
import usecases.CSFindUserByEmail;

public class Auth {

    private static User authenticatedUser;

    private Auth() {
        Auth.authenticatedUser = null;
    }

    public static User login(User user) throws AuthenticationException {
        logout();

        if (user == null) {
            return null;
        }

        String email = user.getEmail();
        String password = user.getPassword();

        if (!Auth.validate(email, password)) {
            Auth.logout();
            throw new AuthenticationException("Credenciais incorretas!");
        }

        User result = CSFindUserByEmail.execute(email);

        if (result == null) {
            Auth.logout();
            throw new AuthenticationException("Credenciais incorretas!");
        }

        result.setPassword(null);

        Auth.authenticatedUser = result;
        Session.set(result);

        return Auth.user();
    }

    public static void logout() {
        Auth.authenticatedUser = null;
        Session.clear();
    }

    public static User user() {
        return authenticatedUser;
    }

    public static boolean check() {
        return authenticatedUser != null;
    }

    public static boolean guest() {
        return authenticatedUser == null;
    }

    public static boolean validate(String email, String password) {
        if (email == null || email.length() == 0) {
            return false;
        }

        User user = CSFindUserByEmail.execute(email);

        if (user == null) {
            return false;
        }

        return Hash.verify(password, user.getPassword());
    }

}
