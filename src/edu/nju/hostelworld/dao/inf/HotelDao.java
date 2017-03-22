package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;

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
}
