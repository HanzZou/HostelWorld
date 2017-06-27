package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.*;

import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
public interface ManagerService {

    List<HotelEntity> getHotelToOpen();

    List<HotelInfoEntity> getHotelInfo();

    List<CustomerInfoEntity> getCustomerInfo();

    void approveHotelToOpen(List<String> hotelToOpen);

    void approveHotelInfo(List<String> hotelInfo);

    void approveCustomerInfo(List<String> customerInfoList);

    List<CheckinEntity> getCheckinReport();

    void settle();

    List<FinanceRecordEntity> getFinances();

    List<ReservationEntity> getReservations();

    List<HotelReport> getGoodHotels();
}
