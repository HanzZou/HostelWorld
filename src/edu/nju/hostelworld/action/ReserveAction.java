package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/24.
 *
 * @author Hanz
 */
@Controller("reserveAction")
public class ReserveAction extends ActionSupport {

    @Autowired
    private CustomerService customerService;

    private ArrayList<String> planReserved = new ArrayList<>();

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        CustomerEntity customer = (CustomerEntity) session.get("customer");
        for (String planId: planReserved) {
            customerService.reservePlan(planId);
            customerService.recordReservation(planId, customer.getId());
        }
        Map request = (Map) ActionContext.getContext().get("request");
        List<PlanEntity> plans = customerService.getPlans();
        request.put("plans", customerService.getPlans());
        request.put("reservations", customerService.getReservations(customer.getId()));
        request.put("checkinRecord", customerService.getCheckinRecord(customer.getId()));
        request.put("finance", customerService.getFinance(customer.getId()));
        return "success";
    }

    public ArrayList<String> getPlanReserved() {
        return planReserved;
    }

    public void setPlanReserved(ArrayList<String> planReserved) {
        this.planReserved = planReserved;
    }
}
