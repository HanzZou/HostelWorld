package edu.nju.hostelworld.service.impl;

import edu.nju.hostelworld.dao.inf.CustomerDao;
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
    @Autowired
    private CustomerDao customerDao;

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
            CustomerInfoEntity customerInfoEntity = managerDao.updateCustomerInfo(id);
            CustomerEntity customerEntity = customerDao.getCustomerByID(customerInfoEntity.getMemberId());
            customerEntity.setAddress(customerInfoEntity.getAddress());
            customerEntity.setCardId(customerInfoEntity.getCardId());
            customerEntity.setName(customerInfoEntity.getName());
            customerEntity.setTelephone(customerInfoEntity.getTelephone());
            customerDao.updateCustomer(customerEntity);
        }
    }

    @Override
    public List<CheckinEntity> getCheckinReport() {
        System.out.println(managerDao.getCheckinReport().size());
        return managerDao.getCheckinReport();
    }

    @Override
    public void settle() {
        List<FinanceRecordEntity> list = managerDao.getFinance();
        for (FinanceRecordEntity financeRecordEntity:list) {
            financeRecordEntity.setIsSettled((byte)1);
            managerDao.settleFinance(financeRecordEntity);
            managerDao.addMoney(financeRecordEntity.getHotelId(), financeRecordEntity.getPrice());
        }
    }

    @Override
    public List<FinanceRecordEntity> getFinances() {
//        System.out.println(managerDao.getFinance().size());
        return managerDao.getFinance();
    }

    @Override
    public List<ReservationEntity> getReservations() {
        List<ReservationEntity> list = customerDao.getReservations();
        List<ReservationEntity> result = new ArrayList<>();
        for (ReservationEntity reservationEntity:list) {
            PlanEntity planEntity = customerDao.getPlanByID(reservationEntity.getPlanId());
            reservationEntity.setId(planEntity.getStartDay().toString());
            reservationEntity.setPlanId(planEntity.getHotelId());
            result.add(reservationEntity);
        }
        return result;
    }

    @Override
    public List<HotelReport> getGoodHotels() {
        List<HotelEntity> list = hotelDao.getHotelList();
        List<HotelReport> reportList = new ArrayList<>();
        for (HotelEntity hotel: list) {
            int num = 0;
            int sum = 0;
            int rates=0;
            String name = hotelDao.getHotelByID(hotel.getId()).getName();
            List<FinanceRecordEntity> financeRecordEntities = managerDao.getFinance();
            for (FinanceRecordEntity record : financeRecordEntities) {
                if (record.getHotelId().equals(hotel.getId())) {
                    num++;
                    sum+=record.getPrice();
                    rates+=record.getRate();
                }
            }
            if (num == 0)
                continue;
            HotelReport report = new HotelReport(name, hotel.getId(), num, (double)rates/num, (double)sum/num);
            reportList.add(report);
        }
        return reportList;
    }

}
