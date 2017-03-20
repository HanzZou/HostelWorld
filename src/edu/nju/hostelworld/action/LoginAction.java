package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.LoginUser;
import edu.nju.hostelworld.model.ManagerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import edu.nju.hostelworld.service.inf.LoginService;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Controller("loginAction")
public class LoginAction extends ActionSupport implements ModelDriven<LoginUser> {

    @Autowired
    private LoginService loginService;

    private LoginUser user = new LoginUser();

    @Override
    public LoginUser getModel() {
        return user;
    }

    public String execute() throws Exception {
        switch (user.getRole()) {
            case CUSTOMER:return customerLogin();
            case HOTEL:return hotelLogin();
            case MANAGER:return managerLogin();
            default:return null;
        }
    }

    private String managerLogin() {
        ManagerEntity loginManager = new ManagerEntity();
        loginManager.setId(user.getUid());
        loginManager.setPassword(user.getPwd());
        ManagerEntity manager = loginService.findValidatedManager(loginManager);
        if (manager == null) {
            return "WRONG";
        }

        Map session = ActionContext.getContext().getSession();
        session.put("logined", true);
        session.put("managerId", manager.getId());
        session.put("managerName", manager.getName());
        return "MANAGER";
    }

    private String hotelLogin() {
        HotelEntity loginHotel = new HotelEntity();
        loginHotel.setId(user.getUid());
        loginHotel.setPassword(user.getPwd());
        HotelEntity hotel = loginService.findValidatedHotel(loginHotel);
        if (hotel == null) {
            return "WRONG";
        }

        if (!hotel.getIsApproved()) {
            return "UNAPPROVED";
        }

        Map session = ActionContext.getContext().getSession();
        session.put("logined", true);
        session.put("hotelId", hotel.getId());
        session.put("hotelName", hotel.getName());
        return "HOTEL";
    }

    private String customerLogin() {
        CustomerEntity loginCustomer = new CustomerEntity();
        loginCustomer.setId(user.getUid());
        loginCustomer.setPassword(user.getPwd());
        CustomerEntity customer = loginService.findValidatedCustomer(loginCustomer);
        if (customer == null) {
            return "WRONG";
        }
        Map session = ActionContext.getContext().getSession();
        session.put("logined", true);
        session.put("customerId", customer.getId());
        session.put("customerName", customer.getName());
        return "CUSTOMER";
    }

}
