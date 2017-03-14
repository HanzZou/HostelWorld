package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.RegisterUser;
import edu.nju.hostelworld.service.RegisterService;
import org.springframework.stereotype.Controller;

/**
 * Created by Hanz on 2017/3/14.
 *
 * @author Hanz
 */
@Controller
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterUser> {

    private RegisterService registerService;

    private RegisterUser user = new RegisterUser();

    @Override
    public RegisterUser getModel() {
        return user;
    }

    public String execute() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPassword(user.getPassword());
        customer.setAddress(user.getAddress());
        customer.setName(user.getName());
        customer.setTelephone(user.getTelephone());
        customer.setCardId(user.getCard_id());
        registerService.registerCustomer(customer);
        return null;
    }

    public void setRegisterService(edu.nju.hostelworld.service.RegisterServiceImpl registerService) {
        this.registerService = registerService;
    }
}
