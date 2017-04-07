package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.smartcardio.Card;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Hanz on 2017/3/24.
 *
 * @author Hanz
 */
@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<PlanEntity> getPlans() {
        return baseDao.getAllList(PlanEntity.class);
    }

    @Override
    public void reservePlan(String planId) {
        PlanEntity planEntity = (PlanEntity) baseDao.load(PlanEntity.class, planId);
        planEntity.setIsReserved((byte)1);
        baseDao.update(planEntity);
    }

    @Override
    public void recordReservation(String planId, String customer) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setIsCanceled((byte)0);
        reservationEntity.setMemberId(customer);
        reservationEntity.setPlanId(planId);
        reservationEntity.setIsFinished((byte)0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String day = simpleDateFormat.format(new java.util.Date());
        reservationEntity.setTime(Date.valueOf(day));
        String number = String.valueOf(baseDao.getTotalCount(ReservationEntity.class)+1);
        for (int i = number.length(); i < 10; i++) {
            number = "0"+number;
        }
        reservationEntity.setId(number);
        baseDao.save(reservationEntity);
    }

    @Override
    public List<ReservationEntity> getReservations() {
        return baseDao.getAllList(ReservationEntity.class);
    }

    @Override
    public void modify(CustomerInfoEntity customerInfoEntity) {
        String number = String.valueOf(baseDao.getTotalCount(CustomerInfoEntity.class)+1);
        for (int i = number.length(); i < 15; i++) {
            number = "0" + number;
        }
        customerInfoEntity.setId(number);
        baseDao.save(customerInfoEntity);
    }

    @Override
    public CustomerEntity getCustomerByID(String id) {
        return (CustomerEntity) baseDao.load(CustomerEntity.class, id);
    }

    @Override
    public void updateCustomer(CustomerEntity customerEntity) {
        baseDao.update(customerEntity);
    }

    @Override
    public void unlock(String id) {
        CustomerEntity customerEntity = (CustomerEntity) baseDao.load(CustomerEntity.class, id);
        customerEntity.setIsBlocked((byte)0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        customerEntity.setBlockedDay(Date.valueOf(simpleDateFormat.format(new java.util.Date())));
        baseDao.update(customerEntity);
    }

    @Override
    public CustomerEntity cancelVIP(String id) {
        CustomerEntity customerEntity = (CustomerEntity) baseDao.load(CustomerEntity.class, id);
        customerEntity.setIsBlocked((byte)1);
        baseDao.update(customerEntity);
        return customerEntity;
    }

    @Override
    public PlanEntity getPlanByID(String id) {
        return (PlanEntity) baseDao.load(PlanEntity.class, id);
    }

    @Override
    public ReservationEntity cancelReservation(String id) {
        ReservationEntity reservationEntity = (ReservationEntity) baseDao.load(ReservationEntity.class, id);
        reservationEntity.setIsCanceled((byte)1);
        baseDao.update(reservationEntity);
        return reservationEntity;
    }

    @Override
    public void freePlan(String planId) {
        PlanEntity planEntity = (PlanEntity) baseDao.load(PlanEntity.class, planId);
        planEntity.setIsReserved((byte)0);
        baseDao.update(planEntity);
    }

    @Override
    public List<CheckinEntity> getCheckinRecord() {
        return baseDao.getAllList(CheckinEntity.class);
    }

    @Override
    public List<FinanceRecordEntity> getFinance() {
        return baseDao.getAllList(FinanceRecordEntity.class);
    }

    @Override
    public void payforunlock(String id) {
        CardEntity cardEntity = (CardEntity) baseDao.load(CardEntity.class, ((CustomerEntity)baseDao.load(CustomerEntity.class, id)).getCardId());
        cardEntity.setBalance(cardEntity.getBalance()-1000);
        baseDao.update(cardEntity);
    }

}
