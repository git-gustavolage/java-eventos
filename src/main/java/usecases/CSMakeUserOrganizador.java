package usecases;

import java.sql.SQLException;

import database.DB;
import exceptions.DatabaseException;
import model.bean.User;
import model.dao.UserCargoDao;
import model.dao.UserDao;
import model.vo.UserCargo;

public class CSMakeUserOrganizador {

    private final UserDao userDao = new UserDao();
    private final UserCargoDao userCargoDao = new UserCargoDao();

    public static void execute(User user) throws DatabaseException {
        new CSMakeUserOrganizador().handle(user);
    }

    public void handle(User user) throws DatabaseException {
        DB db = DB.getInstance();

        try {
            db.beginTransaction();

            userDao.makeOrganizador(user);

            userCargoDao.create(user, UserCargo.RESPONSAVEL_GERAL);

            db.commit();
        } catch (SQLException | DatabaseException e) {
            db.rollback();
            throw new DatabaseException("Erro ao tornar usuário organizador", e);
        }
    }

}
