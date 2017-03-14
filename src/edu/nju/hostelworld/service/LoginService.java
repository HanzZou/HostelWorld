package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.ManagerEntity;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public interface LoginService {

    CustomerEntity findValidatedCustomer(CustomerEntity customer);

    ManagerEntity findValidatedManager(ManagerEntity manager);

    HotelEntity findValidatedHotel(HotelEntity hotel);
}
