package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.*;

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

    List<Reservation> getReservations(String id);

    void modifyInfo(CustomerInfoEntity customerInfoEntity);

    void unlock(String id);

    CustomerEntity getCustomerByID(String id);

    CustomerEntity cancelVIP(String id);

    void cancelReservation(String id);

    List<CheckinEntity> getCheckinRecord(String id);

    List<FinanceRecordEntity> getFinance(String id);
}
