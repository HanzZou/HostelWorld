package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.PlanEntity;

import java.util.List;

/**
 * Created by Hanz on 2017/3/24.
 *
 * @author Hanz
 */
public interface CustomerService {
    List<PlanEntity> getPlans();

    void reservePlan(String planId);

    void recordReservation(String planId, String customer);
}
