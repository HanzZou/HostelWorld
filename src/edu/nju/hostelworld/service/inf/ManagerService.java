package edu.nju.hostelworld.service.inf;

import edu.nju.hostelworld.model.*;

import java.util.List;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
public interface ManagerService {

    public List<HotelEntity> getHotelToOpen();

    public List<HotelInfoEntity> getHotelInfo();

    public List<CustomerInfoEntity> getCustomerInfo();

    void approveHotelToOpen(List<String> hotelToOpen);

    void approveHotelInfo(List<String> hotelInfo);

    void approveCustomerInfo(List<String> customerInfoList);

    List<CheckinEntity> getCheckinReport();

}
