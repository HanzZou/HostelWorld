package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.omg.PortableInterceptor.HOLDING;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("checkin")
public class CheckinAction extends ActionSupport {

    @Autowired
    private HotelService hotelService;

    private ArrayList<String> checkinList = new ArrayList<>();

    public String execute() {
        System.out.println(checkinList.size());
        for (String id:checkinList) {
            hotelService.checkin(id);
        }
        HotelEntity hotel = (HotelEntity) ActionContext.getContext().getSession().get("hotel");

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("reservations", hotelService.getReservations(hotel.getId()));
        request.put("rooms", hotelService.getCheckinRecords(hotel.getId()));
        request.put("checkins", hotelService.getCheckins(hotel.getId()));
        request.put("finance", hotelService.getFinance(hotel.getId()));
        return "success";
    }

    public ArrayList<String> getCheckinList() {
        return checkinList;
    }

    public void setCheckinList(ArrayList<String> checkinList) {
        this.checkinList = checkinList;
    }
}
