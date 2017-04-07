package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Controller("approveAction")
public class ApproveAction extends ActionSupport {

    public List<String> hotelToOpenList = new ArrayList();
    public List<String> hotelInfoList = new ArrayList<>();
    public List<String> customerInfoList = new ArrayList<>();

    @Autowired
    private ManagerService managerService;

    public String execute() throws IOException {
        if (hotelToOpenList.size()!=0)
            managerService.approveHotelToOpen(hotelToOpenList);
        if (hotelInfoList.size()!=0)
            managerService.approveHotelInfo(hotelInfoList);
        if (customerInfoList.size()!=0)
            managerService.approveCustomerInfo(customerInfoList);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("hotelToOpen", managerService.getHotelToOpen());
        request.put("hotelInfo", managerService.getHotelInfo());
        request.put("customerInfo", managerService.getCustomerInfo());
        request.put("checkinReport", managerService.getCheckinReport());
        request.put("finances", managerService.getFinances());
        return "success";
    }

    public ArrayList getHotelToOpenList() {
        return (ArrayList) hotelToOpenList;
    }

    public void setHotelToOpenList(ArrayList hotelToOpenList) {
        this.hotelToOpenList = hotelToOpenList;
    }

    public List<String> getHotelInfoList() {
        return hotelInfoList;
    }

    public void setHotelInfoList(List<String> hotelInfoList) {
        this.hotelInfoList = hotelInfoList;
    }

    public List<String> getCustomerInfoList() {
        return customerInfoList;
    }

    public void setCustomerInfoList(List<String> customerInfoList) {
        this.customerInfoList = customerInfoList;
    }

}