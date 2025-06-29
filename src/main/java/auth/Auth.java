package auth;

import exceptions.AuthenticationException;
import model.bean.User;
import support.Hash;
import usecases.CSFindUserByUsername;

public class Auth {

    private static User authenticatedUser;

    private Auth() {
        Auth.authenticatedUser = null;
    }

    public static User login(User user) throws AuthenticationException {
        Session.expire();

        if (user == null) {
            return null;
        }

        String username = user.getUsername();
        String password = user.getPassword();

        if (!Auth.validate(username, password)) {
            Auth.logout();
            throw new AuthenticationException("Credenciais incorretas!");
        }

        User result = CSFindUserByUsername.execute(username);

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
        Session.set(null);
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

    public static boolean validate(String username, String password) {
        if (username == null || username.length() == 0) {
            return false;
        }

        User user = CSFindUserByUsername.execute(username);

        if (user == null) {
            return false;
        }

        return Hash.verify(password, user.getPassword());
    }

}
