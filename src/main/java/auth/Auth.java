package auth;

import model.bean.User;
import model.dao.UserDao;
import support.Hash;

public class Auth {
    
    private static User AuthenticatedUser;
    
    public Auth(UserDao model){
        Auth.AuthenticatedUser = null;
    }
    
    public static User login(User user) {
        if(user == null) return null;

        String username = user.getUsername();
        String password = user.getPassword();
        
        if (Auth.validate(username, password))
        {
            User result = UserDao.findByUsername(username);
            
            Auth.AuthenticatedUser = result;
            
            //tbm salvar na sessão
            
            return null;
        } else {
            Auth.AuthenticatedUser = null;
            //invalida a sessão atual...
        }
        
        return null;
    }
    
    public static User user() {
        return AuthenticatedUser;
    }
    
    public static boolean check() {
        return AuthenticatedUser != null;
    }
    
    public static boolean guest() {
        return AuthenticatedUser == null;
    }
    
    public static boolean validate(String username, String password) {
        if (username == null || username.length() == 0) return false;
        
        User user = UserDao.findByUsername(username);

        if(user == null) return false;

        return Hash.verify(password, user.getPassword());
    }
    
}
