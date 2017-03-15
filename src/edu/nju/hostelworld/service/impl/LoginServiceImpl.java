package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;
import edu.nju.hostelworld.service.inf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    public LoginServiceImpl() {}

    @Override
    public CustomerEntity findValidatedCustomer(CustomerEntity customer) {
        CustomerEntity getCustomer = userDao.getCustomerByID(customer.getId());
        if (getCustomer == null)
            return null;
        if (!getCustomer.getPassword().equals(customer.getPassword()))
            return null;
        return getCustomer;
    }

    @Override
    public ManagerEntity findValidatedManager(ManagerEntity manager) {
        ManagerEntity getManager = userDao.getManagerByID(manager.getId());
        if (getManager == null)
            return null;
        if (!getManager.getPassword().equals(manager.getPassword()))
            return null;
        return getManager;
    }

    @Override
    public HotelEntity findValidatedHotel(HotelEntity hotel) {
        HotelEntity getHotel = userDao.getHotelByID(hotel.getId());
        if (getHotel == null)
            return null;
        if (!getHotel.getPassword().equals(hotel.getPassword()))
            return null;
        return getHotel;
    }

}
