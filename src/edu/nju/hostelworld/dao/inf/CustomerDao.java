package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.model.ReservationEntity;

import java.util.List;

/**
 * Created by Hanz on 2017/3/24.
 *
 * @author Hanz
 */
public interface CustomerDao {
    List<PlanEntity> getPlans();

    void reservePlan(String planId);

    void recordReservation(String planId, String customer);

    List<ReservationEntity> getReservations();

    void modify(CustomerInfoEntity customerInfoEntity);

    CustomerEntity getCustomerByID(String id);

    void updateCustomer(CustomerEntity customerEntity);
}
