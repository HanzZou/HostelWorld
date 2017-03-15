package edu.nju.hostelworld.service;

import edu.nju.hostelworld.dao.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

/**
 * Created by Hanz on 2017/3/14.
 *
 * @author Hanz
 */
@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserDao userDao;

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customer) {
        customer.setBlockedDay(new Date(0));
        customer.setIsBlocked(false);
        customer.setVipGrade(1);
        customer.setCredits(0);
        return userDao.registerCustomer(customer);
    }

    @Override
    public HotelEntity registerHotel(HotelEntity hotel) {
        return null;
    }
}
