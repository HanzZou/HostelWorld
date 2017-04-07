package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("settle")
public class SettleAction extends ActionSupport {

    @Autowired
    private ManagerService managerService;

    public String execute() {
        managerService.settle();
        Map request = (Map) ActionContext.getContext().get("request");
        request.put("hotelToOpen", managerService.getHotelToOpen());
        request.put("hotelInfo", managerService.getHotelInfo());
        request.put("customerInfo", managerService.getCustomerInfo());
        request.put("checkinReport", managerService.getCheckinReport());
        request.put("finances", managerService.getFinances());
        return "success";
    }

}
