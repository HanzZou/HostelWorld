package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.HotelDao;
import edu.nju.hostelworld.dao.inf.ManagerDao;
import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private ManagerDao managerDao;

    @Override
    public List<HotelEntity> getHotelToOpen() {
        List<HotelEntity> list = hotelDao.getHotelList();
        List<HotelEntity> result = new ArrayList<>();
        for (HotelEntity hotel:list) {
            if (String.valueOf(hotel.getIsApproved()).equals("0")){
                result.add(hotel);
            }
        }
        return result;
    }

    @Override
    public List<HotelInfoEntity> getHotelInfo() {
        List<HotelInfoEntity> list = managerDao.getHotelInfo();
        List<HotelInfoEntity> result = new ArrayList<>();
        for (HotelInfoEntity hotelInfoEntity:list) {
            if (String.valueOf(hotelInfoEntity.getIsAccepted()).equals("0")) {
                result.add(hotelInfoEntity);
            }
        }
        return result;
    }

    @Override
    public List<CustomerInfoEntity> getCustomerInfo() {
        List<CustomerInfoEntity> list = managerDao.getCustomerInfo();
        List<CustomerInfoEntity> result = new ArrayList<>();
        for (CustomerInfoEntity customerInfoEntity:list) {
            if (String.valueOf(customerInfoEntity.getIsAccepted()).equals("0")) {
                result.add(customerInfoEntity);
            }
        }
        return result;
    }

    @Override
    public void approveHotelToOpen(List<String> hotelToOpen) {
        for (String id:hotelToOpen) {
            managerDao.updateHotelToOpen(id);
        }
    }

    @Override
    public void approveHotelInfo(List<String> hotelInfo) {
        for (String id:hotelInfo) {
            HotelInfoEntity hotelInfoEntity = managerDao.updateHotelInfo(id);
            HotelEntity hotelEntity = hotelDao.getHotelByID(hotelInfoEntity.getHotelId());
            hotelEntity.setTelephone(hotelInfoEntity.getTelephone());
            hotelEntity.setCardId(hotelInfoEntity.getCardId());
            hotelEntity.setName(hotelInfoEntity.getName());
            hotelEntity.setAddress(hotelInfoEntity.getAddress());
            hotelDao.updateHotel(hotelEntity);
        }
    }

    @Override
    public void approveCustomerInfo(List<String> customerInfoList) {
        for (String id:customerInfoList) {

        }
    }

    @Override
    public List<CheckinEntity> getCheckinReport() {
        return managerDao.getCheckinReport();
    }

}
