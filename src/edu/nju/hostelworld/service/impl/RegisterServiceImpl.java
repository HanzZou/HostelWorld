package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.service.inf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userDao.registerCustomer(customer);
    }

    @Override
    public HotelEntity registerHotel(HotelEntity hotel) {
        return userDao.registerHotel(hotel);
    }
}
