package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.ManagerDao;
import edu.nju.hostelworld.model.CustomerInfoEntity;
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
}
