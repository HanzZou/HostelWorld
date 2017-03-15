package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;

/**
 * Created by Hanz on 2017/3/14.
 *
 * @author Hanz
 */
public interface RegisterService {

    CustomerEntity registerCustomer(CustomerEntity customer);

    HotelEntity registerHotel(HotelEntity hotel);
}
