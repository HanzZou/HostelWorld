package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("unlock")
public class UnlockAction extends ActionSupport {

    @Autowired
    private CustomerService customerService;

    public String execute(){
        CustomerEntity customer = (CustomerEntity)ActionContext.getContext().getSession().get("customer");
        String id = customer.getId();
        customerService.unlock(id);

        Map session = ActionContext.getContext().getSession();
        session.put("customer", customerService.getCustomerByID(id));

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("plans", customerService.getPlans());
        request.put("reservations", customerService.getReservations(customer.getId()));
        request.put("checkinRecord", customerService.getCheckinRecord(customer.getId()));
        request.put("finance", customerService.getFinance(customer.getId()));
        return "success";
    }
}
