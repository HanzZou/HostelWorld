package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelDao hotelDao;

    @Override
    public PlanEntity releasePlan(PlanEntity plan) {
        return hotelDao.releasePlan(plan);
    }

    @Override
    public HotelInfoEntity modifyInfo(HotelInfoEntity hotelInfoEntity) {
        return hotelDao.modifyInfo(hotelInfoEntity);
    }
}
