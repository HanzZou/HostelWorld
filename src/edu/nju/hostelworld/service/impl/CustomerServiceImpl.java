package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.dao.inf.ManagerDao;
import edu.nju.hostelworld.model.*;
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
    public List<Reservation> getReservations(String id) {
        List<ReservationEntity> list = customerDao.getReservations();
        List<Reservation> result = new ArrayList<>();
        for (ReservationEntity reservationEntity:list) {
            if (reservationEntity.getMemberId().equals(id)&&reservationEntity.getIsCanceled()==(byte)0) {
                Reservation reservation = new Reservation();
                reservation.setId(reservationEntity.getId());
                reservation.setTime(reservationEntity.getTime());
                PlanEntity planEntity = customerDao.getPlanByID(reservationEntity.getPlanId());
                reservation.setHotelName(hotelDao.getHotelByID(planEntity.getHotelId()).getName());
                reservation.setStartDay(planEntity.getStartDay());
                reservation.setEndDay(planEntity.getEndDay());
                reservation.setRoom(planEntity.getRoom());
                result.add(reservation);
            }
        }
        return result;
    }

    @Override
    public void modifyInfo(CustomerInfoEntity customerInfoEntity) {
        customerDao.modify(customerInfoEntity);
    }

    @Override
    public void unlock(String id) {
        customerDao.payforunlock(id);
        customerDao.unlock(id);
    }

    @Override
    public CustomerEntity getCustomerByID(String id) {
        return customerDao.getCustomerByID(id);
    }

    @Override
    public CustomerEntity cancelVIP(String id) {
        return customerDao.cancelVIP(id);
    }

    @Override
    public void cancelReservation(String id) {
        ReservationEntity reservationEntity = customerDao.cancelReservation(id);
        customerDao.freePlan(reservationEntity.getPlanId());
    }

    @Override
    public List<CheckinEntity> getCheckinRecord(String id) {
        List<CheckinEntity> list = customerDao.getCheckinRecord();
        List<CheckinEntity> result = new ArrayList<>();
        for (CheckinEntity checkinEntity:list) {
            if (checkinEntity.getMember().equals(id)) {
                checkinEntity.setHotelId(hotelDao.getHotelByID(checkinEntity.getHotelId()).getName());
                result.add(checkinEntity);
            }
        }
        return result;
    }

    @Override
    public List<FinanceRecordEntity> getFinance(String id) {
        List<FinanceRecordEntity> list = customerDao.getFinance();
        List<FinanceRecordEntity> result = new ArrayList<>();
        for (FinanceRecordEntity financeRecordEntity : list) {
            if (!financeRecordEntity.getMemberId().equals(id))
                continue;
            financeRecordEntity.setHotelId(hotelDao.getHotelByID(financeRecordEntity.getHotelId()).getName());
            result.add(financeRecordEntity);
        }
        return result;
    }
}
