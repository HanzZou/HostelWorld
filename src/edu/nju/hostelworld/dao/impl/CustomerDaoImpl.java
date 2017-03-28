package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.model.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
