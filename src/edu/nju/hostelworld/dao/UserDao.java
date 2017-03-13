package edu.nju.hostelworld.dao;

import edu.nju.hostelworld.model.CustomerEntity;

/**
 * Created by Hanz on 2017/3/1.
 *
 * @author Hanz
 */
public interface UserDao {
    CustomerEntity getCustomerByIDAndPassword(CustomerEntity customer);
}
