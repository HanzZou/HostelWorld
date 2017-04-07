package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;
import edu.nju.hostelworld.service.inf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;


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

        Calendar c1 = Calendar.getInstance();
        c1.setTime(getCustomer.getBlockedDay());
        Calendar c2 = Calendar.getInstance();
        c2.setTime(new Date());
        if (getDaysBetween(c1,c2)>100) {
            getCustomer.setIsBlocked((byte)1);
        }
        userDao.saveCustomer(getCustomer);
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

    public int getDaysBetween (Calendar d1, Calendar d2) {
        if (d1.after(d2)) {
            java.util.Calendar swap = d1;
            d1 = d2;
            d2 = swap;
        }
        int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
        int y2 = d2.get(Calendar.YEAR);
        if (d1.get(Calendar.YEAR) != y2) {
            d1 = (Calendar) d1.clone();
            do {
                days = d1.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                d1.add(Calendar.YEAR, 1);
            } while (d1.get(Calendar.YEAR) != y2);
        }
        return days;
    }

}
