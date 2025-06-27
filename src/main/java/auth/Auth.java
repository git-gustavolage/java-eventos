package auth;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.bean.User;
import model.dao.UserDao;
import support.Hash;

public class Auth {

    // private static User authenticatedUser;

    // public Auth(UserDao model) {
    //     Auth.authenticatedUser = null;
    // }

    // public static User login(User user) {
    //     Session.expire();

    //     if (user == null) {
    //         return null;
    //     }

    //     String username = user.getUsername();
    //     String password = user.getPassword();

    //     if (!Auth.validate(username, password)) {
    //         Auth.logout();
    //         Logger.getLogger(Auth.class.getName()).log(Level.SEVERE, "Credenciais incorretas!");
    //         return null;
    //     }

    //     User result = UserDao.findByUsername(username);

    //     result.setPassword(null);

    //     Auth.authenticatedUser = result;
    //     Session.set(result);

    //     return Auth.user();
    // }

    // public static void logout() {
    //     Auth.authenticatedUser = null;
    //     Session.set(null);
    // }

    // public static User user() {
    //     return authenticatedUser;
    // }

    // public static boolean check() {
    //     return authenticatedUser != null;
    // }

    // public static boolean guest() {
    //     return authenticatedUser == null;
    // }

    // public static boolean validate(String username, String password) {
    //     if (username == null || username.length() == 0) {
    //         return false;
    //     }

    //     User user = UserDao.findByUsername(username);

    //     if (user == null) {
    //         return false;
    //     }

    //     return Hash.verify(password, user.getPassword());
    // }

}
