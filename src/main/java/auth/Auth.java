package auth;

import model.bean.User;
import model.dao.UserDao;

public class Auth {
    
    private static UserDao model;
    private static User user;
    
    public Auth(UserDao model){
        Auth.model = model;
        this.user = null;
    }
    
    public static User login(User user) {
        if(Auth.check()) return Auth.user();
        
        String username = user.getUser();
        String password = user.getPassword();
        
        if (Auth.validate(, user.getPassword()))
        {

        }
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
