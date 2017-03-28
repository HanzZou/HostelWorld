package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.*;

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

    void unlock(String id);

    CustomerEntity cancelVIP(String id);

    PlanEntity getPlanByID(String id);

    ReservationEntity cancelReservation(String id);

    void freePlan(String planId);

    List<CheckinEntity> getCheckinRecord();

    List<FinanceRecordEntity> getFinance();
}
