package edu.nju.hostelworld.dao.inf;

import edu.nju.hostelworld.model.CheckinEntity;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.model.FinanceRecordEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;

import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
public interface ManagerDao {
    List<HotelInfoEntity> getHotelInfo();

    List<CustomerInfoEntity> getCustomerInfo();

    void updateHotelToOpen(String id);

    HotelInfoEntity updateHotelInfo(String id);

    CustomerInfoEntity updateCustomerInfo(String id);

    List<CheckinEntity> getCheckinReport();

    List<FinanceRecordEntity> getFinance();

    void settleFinance(FinanceRecordEntity financeRecordEntity);

    void addMoney(String hotelId, int price);
}
