package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.CheckinEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.model.Reservation;

import java.util.List;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public interface HotelService {
    PlanEntity releasePlan(PlanEntity plan);

    HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity);

    List<Reservation> getReservations(String id);

    void checkin(String id);

    void checkinByHand(CheckinEntity checkinEntity);

    void checkout(String id);
}
