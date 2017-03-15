package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.RegisterUser;
import edu.nju.hostelworld.service.inf.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;

/**
 * Created by Hanz on 2017/3/14.
 *
 * @author Hanz
 */
@Controller
public class RegisterAction extends ActionSupport implements ModelDriven<RegisterUser> {

    @Autowired
    private RegisterService registerService;

    private RegisterUser user = new RegisterUser();

    @Override
    public RegisterUser getModel() {
        return user;
    }

    public String customerRegister() {
        CustomerEntity customer = new CustomerEntity();
        customer.setPassword(user.getPassword());
        customer.setAddress(user.getAddress());
        customer.setName(user.getName());
        customer.setTelephone(user.getTelephone());
        customer.setCardId(user.getCard_id());
        customer.setBlockedDay(new Date(0));
        customer.setIsBlocked(false);
        customer.setVipGrade(1);
        customer.setCredits(0);
        registerService.registerCustomer(customer);
        return "CUSTOMER";
    }

    public String hotelRegister() {
        HotelEntity hotel = new HotelEntity();
        hotel.setPassword(user.getPassword());
        hotel.setTelephone(user.getTelephone());
        hotel.setCardId(user.getCard_id());
        hotel.setAddress(user.getAddress());
        hotel.setIsApproved(false);
        hotel.setName(user.getName());
        registerService.registerHotel(hotel);
        return "HOTEL";
    }

}
