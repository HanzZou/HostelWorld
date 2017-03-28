package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CustomerEntity;
import edu.nju.hostelworld.model.CustomerInfoEntity;
import edu.nju.hostelworld.service.inf.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

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

    @Autowired
    private CustomerService customerService;

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        customerInfoEntity.setMemberId(((CustomerEntity)session.get("customer")).getId());
        customerInfoEntity.setIsAccepted((byte)0);
        customerService.modifyInfo(customerInfoEntity);
        return "success";
    }
}
