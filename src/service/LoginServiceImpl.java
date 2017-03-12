package service;

import dao.UserDao;
import dao.UserDaoImpl;
import factory.DaoFactory;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public class LoginServiceImpl implements LoginService {

    private static UserDao userDao = DaoFactory.getUserDao();

    private static LoginServiceImpl loginService = new LoginServiceImpl();

    private LoginServiceImpl() {}

    public static LoginService getInstance() {
        return loginService;
    }

}
