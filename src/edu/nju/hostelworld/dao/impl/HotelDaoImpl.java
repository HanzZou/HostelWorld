package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.model.PlanEntity;
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

}
