package edu.nju.hostelworld.dao.impl;

import edu.nju.hostelworld.dao.inf.BaseDao;
import edu.nju.hostelworld.dao.inf.ManagerDao;
import edu.nju.hostelworld.model.*;
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

    @Override
    public CustomerInfoEntity updateCustomerInfo(String id) {
        CustomerInfoEntity customerInfoEntity = (CustomerInfoEntity) baseDao.load(CustomerInfoEntity.class, id);
        customerInfoEntity.setIsAccepted((byte)1);
        baseDao.update(customerInfoEntity);
        return customerInfoEntity;
    }

    @Override
    public List<CheckinEntity> getCheckinReport() {
        return baseDao.getAllList(CheckinEntity.class);
    }

    @Override
    public List<FinanceRecordEntity> getFinance() {
        return baseDao.getAllList(FinanceRecordEntity.class);
    }

    @Override
    public void settleFinance(FinanceRecordEntity financeRecordEntity) {
        baseDao.update(financeRecordEntity);
    }

    @Override
    public void addMoney(String hotelId, int price) {
        CardEntity cardEntity = (CardEntity) baseDao.load(CardEntity.class, ((HotelEntity)baseDao.load(HotelEntity.class, hotelId)).getCardId());
        cardEntity.setBalance(cardEntity.getBalance()+price);
        baseDao.update(cardEntity);
    }
}
