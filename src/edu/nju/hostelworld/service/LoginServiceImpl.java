package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private UserDao userDao;

    public LoginServiceImpl() {}

    @Override
    public CustomerEntity findValidatedCustomer(CustomerEntity customer) {
        System.out.println(1);
        return userDao.getCustomerByIDAndPassword(customer);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
