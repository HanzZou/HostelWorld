package dao;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDao = new UserDaoImpl();

    private UserDaoImpl() {}

    public static UserDaoImpl getInstance() {
        return userDao;
    }
}
