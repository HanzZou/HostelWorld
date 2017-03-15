package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.UserDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private BaseDao baseDao;

    public UserDaoImpl() {}

    @Override
    /**
     * 根据用户名和密码获取用户
     */
    public CustomerEntity getCustomerByID(String id) {
        return (CustomerEntity) baseDao.load(CustomerEntity.class, id);
    }

    @Override
    /**
     * 根据用户名和密码获取经理
     */
    public ManagerEntity getManagerByID(String id) {
        return (ManagerEntity) baseDao.load(ManagerEntity.class, id);
    }

    @Override
    public HotelEntity getHotelByID(String id) {
        return (HotelEntity) baseDao.load(HotelEntity.class, id);
    }

    @Override
    public CustomerEntity registerCustomer(CustomerEntity customer) {
        String number = String.valueOf(baseDao.getTotalCount(CustomerEntity.class)+1);
        for (int i = Integer.valueOf(number); i < 7; i++) {
            number = "0"+number;
        }
        customer.setId(number);
        baseDao.save(customer);
        return customer;
    }

    @Override
    public HotelEntity registerHotel(HotelEntity hotel) {
        String number = String.valueOf(baseDao.getTotalCount(HotelEntity.class)+1);
        for (int i = Integer.valueOf(number); i < 7; i++) {
            number = "0"+number;
        }
        hotel.setId(number);
        baseDao.save(hotel);
        return hotel;
    }

}
