package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;

/**
 * Created by Hanz on 2017/3/1.
 *
 * @author Hanz
 */
public interface UserDao {
    CustomerEntity getCustomerByID(String id);

    ManagerEntity getManagerByID(String id);

    HotelEntity getHotelByID(String id);

    CustomerEntity registerCustomer(CustomerEntity customer);

    HotelEntity registerHotel(HotelEntity hotel);

}
