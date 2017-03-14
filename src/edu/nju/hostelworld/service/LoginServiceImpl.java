package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;
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
        return userDao.getCustomerByIDAndPassword(customer);
    }

    @Override
    public ManagerEntity findValidatedManager(ManagerEntity manager) {
        return userDao.getManagerByIDAndPassword(manager);
    }

    @Override
    public HotelEntity findValidatedHotel(HotelEntity hotel) {
        return userDao.getHotelByIDAndPassword(hotel);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
