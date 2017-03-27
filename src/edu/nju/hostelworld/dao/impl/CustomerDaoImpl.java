package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.model.ReservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        String number = String.valueOf(baseDao.getTotalCount(ReservationEntity.class)+1);
        for (int i = number.length(); i < 10; i++) {
            number = "0"+number;
        }
        reservationEntity.setId(number);
        baseDao.save(reservationEntity);
    }

}
