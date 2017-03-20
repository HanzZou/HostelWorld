package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/17.
 *
 * @author Hanz
 */
@Controller("logoutAction")
public class LogoutAction extends ActionSupport {

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        session.put("logined", false);
        session.remove("hotelId");
        session.remove("hotelName");
        session.remove("customerId");
        session.remove("customerName");
        return "success";
    }
}
