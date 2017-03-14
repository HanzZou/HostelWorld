package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;

/**
 * Created by Hanz on 2017/3/1.
 *
 * @author Hanz
 */
public interface UserDao {
    CustomerEntity getCustomerByIDAndPassword(CustomerEntity customer);

    ManagerEntity getManagerByIDAndPassword(ManagerEntity manager);

    HotelEntity getHotelByIDAndPassword(HotelEntity hotel);

    CustomerEntity registerCustomer(CustomerEntity customer);

    HotelEntity hotelCustomer(HotelEntity hotel);

    String getCustomerNumber();
}
