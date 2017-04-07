package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
@Repository("hotelDao")
public class HotelDaoImpl implements HotelDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public PlanEntity releasePlan(PlanEntity plan) {
        String number = String.valueOf(baseDao.getTotalCount(PlanEntity.class)+1);
        for (int i = number.length(); i < 10; i++) {
            number = "0"+number;
        }
        plan.setId(number);
        baseDao.save(plan);
        return plan;
    }

    @Override
    public HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity) {
        String number = String.valueOf(baseDao.getTotalCount(HotelInfoEntity.class)+1);
        for (int i = number.length(); i < 15; i++) {
            number = "0"+number;
        }
        hotelInfoEntity.setId(number);
        hotelInfoEntity.setIsAccepted((byte)0);
        baseDao.save(hotelInfoEntity);
        return hotelInfoEntity;
    }

    @Override
    public List<HotelEntity> getHotelList() {
        return baseDao.getAllList(HotelEntity.class);
    }

    @Override
    public HotelEntity getHotelByID(String id) {
        return (HotelEntity) baseDao.load(HotelEntity.class, id);
    }

    @Override
    public void updateHotel(HotelEntity hotelEntity) {
        baseDao.update(hotelEntity);
    }

    @Override
    public ReservationEntity checkin(String id) {
        ReservationEntity reservationEntity = (ReservationEntity) baseDao.load(ReservationEntity.class, id);
        reservationEntity.setIsFinished((byte)1);
        baseDao.update(reservationEntity);
        return reservationEntity;
    }

    @Override
    public void saveCheckInRecord(CheckinEntity checkinEntity) {
        String number = String.valueOf(baseDao.getTotalCount(CheckinEntity.class)+1);
        for (int i = number.length(); i < 15; i++) {
            number = "0"+number;
        }
        checkinEntity.setId(number);
        baseDao.save(checkinEntity);
    }

    @Override
    public CheckinEntity getCheckinRecordByID(String id) {
        return (CheckinEntity) baseDao.load(CheckinEntity.class, id);
    }

    @Override
    public void checkout(CheckinEntity checkinEntity) {
        baseDao.update(checkinEntity);
    }

    @Override
    public List<CheckinEntity> getCheckinRecord() {
        return baseDao.getAllList(CheckinEntity.class);
    }

    @Override
    public void saveFinanceRecord(FinanceRecordEntity financeRecordEntity) {
        String number = String.valueOf(baseDao.getTotalCount(FinanceRecordEntity.class)+1);
        for (int i = number.length(); i < 15; i++) {
            number = "0"+number;
        }
        financeRecordEntity.setId(number);
        baseDao.save(financeRecordEntity);
    }

    @Override
    public List<FinanceRecordEntity> getFinance() {
        return baseDao.getAllList(FinanceRecordEntity.class);
    }

}
