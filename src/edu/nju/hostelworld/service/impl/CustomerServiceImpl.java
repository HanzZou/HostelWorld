package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.model.ReservationEntity;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanz on 2017/3/24.
 *
 * @author Hanz
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private HotelDao hotelDao;

    @Override
    public List<PlanEntity> getPlans() {
        List<PlanEntity> list = customerDao.getPlans();
        List<PlanEntity> result = new ArrayList<>();
        for (PlanEntity planEntity:list) {
            if (planEntity.getIsReserved()==(byte)1)
                continue;
            planEntity.setHotelId(hotelDao.getHotelByID(planEntity.getHotelId()).getName());
            result.add(planEntity);
        }
        return result;
    }

    @Override
    public void reservePlan(String planId) {
        customerDao.reservePlan(planId);
    }

    @Override
    public void recordReservation(String planId, String customer) {
        customerDao.recordReservation(planId, customer);
    }

    @Override
    public List<ReservationEntity> getReservations(String id) {
        List<ReservationEntity> list = customerDao.getReservations();
        List<ReservationEntity> result = new ArrayList<>();
        for (ReservationEntity reservationEntity:list) {
            if (reservationEntity.getMemberId().equals(id))
                result.add(reservationEntity);
        }
        return result;
    }

    @Override
    public void modifyInfo(CustomerInfoEntity customerInfoEntity) {
        customerDao.modify(customerInfoEntity);
    }
}
