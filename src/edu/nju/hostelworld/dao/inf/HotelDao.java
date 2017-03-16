package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.PlanEntity;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public interface HotelDao {
    PlanEntity releasePlan(PlanEntity plan);
}
