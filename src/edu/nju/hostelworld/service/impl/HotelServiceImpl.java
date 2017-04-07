package edu.nju.hostelworld.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import edu.nju.hostelworld.dao.inf.CustomerDao;
import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private CustomerDao customerDao;

    @Override
    public PlanEntity releasePlan(PlanEntity plan) {
        return hotelDao.releasePlan(plan);
    }

    @Override
    public HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity) {
        return hotelDao.modifyInfo(hotelInfoEntity);
    }

    @Override
    public List<Reservation> getReservations(String id) {
        List<ReservationEntity> list = customerDao.getReservations();
        List<Reservation> result = new ArrayList<>();
        for (ReservationEntity reservationEntity:list) {
            PlanEntity planEntity = customerDao.getPlanByID(reservationEntity.getPlanId());
            if (!planEntity.getHotelId().equals(id)||reservationEntity.getIsFinished()==(byte)1||reservationEntity.getIsCanceled()==(byte)1)
                continue;
            Reservation reservation = new Reservation();
            reservation.setRoom(planEntity.getRoom());
            reservation.setEndDay(planEntity.getEndDay());
            reservation.setStartDay(planEntity.getStartDay());
            reservation.setId(reservationEntity.getId());
            reservation.setHotelName(customerDao.getCustomerByID(reservationEntity.getMemberId()).getName());
            reservation.setTime(reservationEntity.getTime());
            result.add(reservation);
        }
        return result;
    }

    @Override
    public void checkin(String id) {
        ReservationEntity reservationEntity = hotelDao.checkin(id);
        CheckinEntity checkinEntity = new CheckinEntity();
        PlanEntity planEntity = customerDao.getPlanByID(reservationEntity.getPlanId());
        checkinEntity.setHotelId(planEntity.getHotelId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.valueOf(sdf.format(new java.util.Date()));
        checkinEntity.setDate(date);
        checkinEntity.setpNum(1);
        checkinEntity.setLeaveDate(date);
        checkinEntity.setRoom(planEntity.getRoom());
        checkinEntity.setPayCard((byte)1);
        checkinEntity.setCheckout((byte)0);
        checkinEntity.setMember(reservationEntity.getMemberId());
        checkinEntity.setNames(customerDao.getCustomerByID(reservationEntity.getMemberId()).getName());
        hotelDao.saveCheckInRecord(checkinEntity);

        System.out.println(1);
        FinanceRecordEntity financeRecordEntity = new FinanceRecordEntity();
        financeRecordEntity.setIsSettled((byte)0);
        financeRecordEntity.setHotelId(planEntity.getHotelId());
        financeRecordEntity.setMemberId(reservationEntity.getMemberId());
        financeRecordEntity.setPrice(planEntity.getPrice());
        financeRecordEntity.setTime(Date.valueOf(sdf.format(new java.util.Date())));
        hotelDao.saveFinanceRecord(financeRecordEntity);
    }

    @Override
    public void checkinByHand(CheckinEntity checkinEntity) {
        hotelDao.saveCheckInRecord(checkinEntity);
    }

    @Override
    public void checkout(String id) {
        CheckinEntity checkinEntity = hotelDao.getCheckinRecordByID(id);
        checkinEntity.setCheckout((byte)1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        checkinEntity.setLeaveDate(Date.valueOf(simpleDateFormat.format(new java.util.Date())));
        hotelDao.checkout(checkinEntity);
    }

    @Override
    public List<CheckinEntity> getCheckinRecords(String id) {
        List<CheckinEntity> list = hotelDao.getCheckinRecord();
        List<CheckinEntity> result = new ArrayList<>();
        for (CheckinEntity checkinEntity:list) {
            if (checkinEntity.getHotelId().equals(id)&&checkinEntity.getCheckout()==(byte)0) {
                result.add(checkinEntity);
            }
        }
        return result;
    }

    @Override
    public List<CheckinEntity> getCheckins(String id) {
        List<CheckinEntity> list = hotelDao.getCheckinRecord();
        List<CheckinEntity> result = new ArrayList<>();
        for (CheckinEntity checkinEntity:list) {
            if (checkinEntity.getHotelId().equals(id)&&checkinEntity.getCheckout()==(byte)1) {
                result.add(checkinEntity);
            }
        }
        return result;
    }

    @Override
    public List<FinanceRecordEntity> getFinance(String id) {
        List<FinanceRecordEntity> list = hotelDao.getFinance();
        List<FinanceRecordEntity> result = new ArrayList<>();
        for (FinanceRecordEntity financeRecordEntity : list) {
            if (financeRecordEntity.getHotelId().equals(id))
                result.add(financeRecordEntity);
        }
        return result;
    }
}
