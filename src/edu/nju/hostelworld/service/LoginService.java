package edu.nju.hostelworld.service;

import edu.nju.hostelworld.model.CustomerEntity;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
public interface LoginService {

    CustomerEntity findValidatedCustomer(CustomerEntity customer);


}
