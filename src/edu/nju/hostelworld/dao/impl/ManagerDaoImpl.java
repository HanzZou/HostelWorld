package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.ManagerDao;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Repository("managerDao")
public class ManagerDaoImpl implements ManagerDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public List<HotelInfoEntity> getHotelInfo() {
        return baseDao.getAllList(HotelInfoEntity.class);
    }

    @Override
    public List<CustomerInfoEntity> getCustomerInfo() {
        return baseDao.getAllList(CustomerInfoEntity.class);
    }

    @Override
    public void updateHotelToOpen(String id) {
        HotelEntity hotelEntity = (HotelEntity) baseDao.load(HotelEntity.class, id);
        hotelEntity.setIsApproved((byte) 1);
        baseDao.update(hotelEntity);
    }

    @Override
    public HotelInfoEntity updateHotelInfo(String id) {
        HotelInfoEntity hotelInfoEntity = (HotelInfoEntity) baseDao.load(HotelInfoEntity.class, id);
        hotelInfoEntity.setIsAccepted((byte)1);
        baseDao.update(hotelInfoEntity);
        return hotelInfoEntity;
    }
}
