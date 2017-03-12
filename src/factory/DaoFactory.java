package factory;

import dao.UserDao;
import dao.UserDaoImpl;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public class DaoFactory {

    public static UserDao getUserDao() {
        return UserDaoImpl.getInstance();
    }
}
