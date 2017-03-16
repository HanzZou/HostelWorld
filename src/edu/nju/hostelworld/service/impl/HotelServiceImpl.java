package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public PlanEntity releasePlan(PlanEntity plan) {
        hotelDao.releasePlan(plan);
        return null;
    }
}
