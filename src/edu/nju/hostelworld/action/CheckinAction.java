package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("checkin")
public class CheckinAction extends ActionSupport {

    private ArrayList<String> checkinList = new ArrayList<>();

    @Autowired
    private HotelService hotelService;

    public String execute() {
        for (String id:checkinList) {
            hotelService.checkin(id);
        }
        return "success";
    }

    public ArrayList<String> getCheckinList() {
        return checkinList;
    }

    public void setCheckinList(ArrayList<String> checkinList) {
        this.checkinList = checkinList;
    }
}
