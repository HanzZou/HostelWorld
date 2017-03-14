package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Hanz on 2017/3/14.
 *
 * @author Hanz
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customer) {
        String id = userDao.getCustomerNumber();
        return userDao.registerCustomer(customer);
    }
}
