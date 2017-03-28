package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.*;
import edu.nju.hostelworld.service.inf.CustomerService;
import edu.nju.hostelworld.service.inf.HotelService;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import edu.nju.hostelworld.service.inf.LoginService;

import java.util.List;
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
    @Autowired
    private HotelService hotelService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private CustomerService customerService;

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
        session.put("manager", manager);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("hotelToOpen", managerService.getHotelToOpen());
        request.put("hotelInfo", managerService.getHotelInfo());
        request.put("customerInfo", managerService.getCustomerInfo());
        request.put("checkinReport", managerService.getCheckinReport());
        return "MANAGER";
    }

    private String hotelLogin() {
        HotelEntity loginHotel = new HotelEntity();
        loginHotel.setId(user.getUid());
        loginHotel.setPassword(user.getPwd());
        HotelEntity hotel = loginService.findValidatedHotel(loginHotel);
        if (hotel == null)
            return "WRONG";

        System.out.println(hotel.getIsApproved());
        if (hotel.getIsApproved() == 0)
            return "WAIT";

        Map session = ActionContext.getContext().getSession();
        session.put("logined", true);
        session.put("hotel", hotel);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("reservations", hotelService.getReservations(hotel.getId()));
        request.put("rooms", hotelService.getCheckinRecords(hotel.getId()));
        request.put("checkins", hotelService.getCheckins(hotel.getId()));
        request.put("finance", hotelService.getFinance(hotel.getId()));

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
        session.put("customer", customer);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("plans", customerService.getPlans());
        request.put("reservations", customerService.getReservations(customer.getId()));
        request.put("checkinRecord", customerService.getCheckinRecord(customer.getId()));
        request.put("finance", customerService.getFinance(customer.getId()));
        return "CUSTOMER";
    }

}
