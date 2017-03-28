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
        for (String planId: planReserved) {
            customerService.reservePlan(planId);
            Map session = ActionContext.getContext().getSession();
            customerService.recordReservation(planId, ((CustomerEntity)session.get("customer")).getId());
        }
        Map request = (Map) ActionContext.getContext().get("request");
        List<PlanEntity> plans = customerService.getPlans();
        request.put("plans", plans);
        return "success";
    }

    public ArrayList<String> getPlanReserved() {
        return planReserved;
    }

    public void setPlanReserved(ArrayList<String> planReserved) {
        this.planReserved = planReserved;
    }
}
