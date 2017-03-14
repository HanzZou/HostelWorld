package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.LoginUser;
import edu.nju.hostelworld.model.ManagerEntity;
import org.springframework.stereotype.Controller;
import edu.nju.hostelworld.service.LoginService;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<LoginUser> {

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
        return "CUSTOMER";
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
