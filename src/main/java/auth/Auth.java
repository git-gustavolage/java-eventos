package auth;

import model.bean.User;
import model.dao.UserDao;

public class Auth {
    
    private static UserDao model;
    private static User user;
    
    public Auth(UserDao model){
        Auth.model = model;
        Auth.user = null;
    }
    
    public static User login(User user) {
        if(Auth.check()) return Auth.user();
        
        String username = user.getUser();
        String password = user.getPassword();
        
        if (Auth.validate(username, password))
        {
            User result = model.find(user);
            
            Auth.user = result;
            
            //tbm salvar na sessão
            
            return result;
        } else {
            //invalida a sessão atual...
        }
        
        return null;
    }
    
    public static User user() {
        return user;
    }
    
    public static boolean check() {
        return user != null;
    }
    
    public static boolean guest() {
        return user == null;
    }
    
    public static boolean validate(String username, String password) {
        //
        return true;
    }
    
    
}
