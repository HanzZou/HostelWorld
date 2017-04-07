package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("checkout")
public class CheckoutAction extends ActionSupport {

    private ArrayList<String> checkoutList = new ArrayList<>();

    @Autowired
    private HotelService hotelService;

    public String execute() {
        for (String id:checkoutList) {
            hotelService.checkout(id);
        }
        HotelEntity hotel = (HotelEntity) ActionContext.getContext().getSession().get("hotel");

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("reservations", hotelService.getReservations(hotel.getId()));
        request.put("rooms", hotelService.getCheckinRecords(hotel.getId()));
        request.put("checkins", hotelService.getCheckins(hotel.getId()));
        request.put("finance", hotelService.getFinance(hotel.getId()));
        return "success";
    }

    public ArrayList<String> getCheckoutList() {
        return checkoutList;
    }

    public void setCheckoutList(ArrayList<String> checkoutList) {
        this.checkoutList = checkoutList;
    }
}
