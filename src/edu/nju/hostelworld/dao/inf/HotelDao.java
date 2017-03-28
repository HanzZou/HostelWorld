package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.*;

import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public interface HotelDao {

    PlanEntity releasePlan(PlanEntity plan);

    HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity);

    List<HotelEntity> getHotelList();

    HotelEntity getHotelByID(String id);

    void updateHotel(HotelEntity hotelEntity);

    ReservationEntity checkin(String id);

    void saveCheckInRecord(CheckinEntity checkinEntity);

    CheckinEntity getCheckinRecordByID(String id);

    void checkout(CheckinEntity checkinEntity);

    List<CheckinEntity> getCheckinRecord();

    void saveFinanceRecord(FinanceRecordEntity financeRecordEntity);

    List<FinanceRecordEntity> getFinance();
}
