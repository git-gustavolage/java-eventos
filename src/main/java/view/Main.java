package view;

import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UserDao;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        user.setNome("nome");
        user.setUsername("username 3");
        user.setEmail("email 3");
        user.setPassword("password");

        UserDao dao = new UserDao();
        
        try {
            dao.create(user);
        } catch (DatabaseException e) {
            System.out.println(e.getMessage());
        }

    }

}
