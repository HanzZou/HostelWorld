package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import org.springframework.stereotype.Controller;

/**
 * Created by Hanz on 2017/3/16.
 *
 * @author Hanz
 */
@Controller("modifyCustomerInfoAction")
public class ModifyCustomerInfoAction extends ActionSupport implements ModelDriven<CustomerInfoEntity> {

    private CustomerInfoEntity customerInfoEntity = new CustomerInfoEntity();

    @Override
    public CustomerInfoEntity getModel() {
        return customerInfoEntity;
    }

    public String execute() {
        return "success";
    }
}