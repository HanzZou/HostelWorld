package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public interface HotelService {
    PlanEntity releasePlan(PlanEntity plan);

    HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity);
}
