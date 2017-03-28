package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("cancelReservation")
public class CancelReservationAction extends ActionSupport {

    ArrayList<String> cancelList = new ArrayList<>();

    @Autowired
    private CustomerService customerService;

    public String execute() {
        String memberID = ((CustomerEntity)ActionContext.getContext().getSession().get("customer")).getId();
        for (String id:cancelList) {
            customerService.cancelReservation(id);
        }

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("plans", customerService.getPlans());
        request.put("reservations", customerService.getReservations(memberID));
        request.put("checkinRecord", customerService.getCheckinRecord(memberID));
        request.put("finance", customerService.getFinance(memberID));
        return "success";
    }

    public ArrayList<String> getCancelList() {
        return cancelList;
    }

    public void setCancelList(ArrayList<String> cancelList) {
        this.cancelList = cancelList;
    }
}
