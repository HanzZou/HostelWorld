package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.LoginUserEntity;
import org.springframework.stereotype.Controller;
import edu.nju.hostelworld.service.LoginService;

/**
 * Created by Hanz on 2017/3/6.
 *
 * @author Hanz
 */
@Controller
public class LoginAction extends ActionSupport implements ModelDriven<LoginUserEntity> {

    private LoginService loginService;

    private LoginUserEntity user = new LoginUserEntity();

    @Override
    public LoginUserEntity getModel() {
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
        return "MANAGER";
    }

    private String hotelLogin() {
        return "HOTEL";
    }

    private String customerLogin() {
        CustomerEntity loginCustomer = new CustomerEntity();
        loginCustomer.setId(user.getUid());
        loginCustomer.setPassword(user.getPwd());
        CustomerEntity customer = loginService.findValidatedCustomer(loginCustomer);
        System.out.println(customer.getAddress());
        return "CUSTOMER";
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}
