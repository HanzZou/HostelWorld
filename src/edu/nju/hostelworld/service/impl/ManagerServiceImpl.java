package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Override
    public List<HotelEntity> getHotelToOpen() {
        return null;
    }

    @Override
    public List<HotelInfoEntity> getHotelInfo() {
        return null;
    }

    @Override
    public List<CustomerInfoEntity> getCustomerInfo() {
        return null;
    }
}
