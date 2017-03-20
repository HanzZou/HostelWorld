package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.service.inf.HotelService;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Controller("approveHotelToOpenAction")
public class ApproveHotelToOpenAction extends ActionSupport {

    @Autowired
    private ManagerService managerService;





}
