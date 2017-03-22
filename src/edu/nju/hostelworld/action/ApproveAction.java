package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.nju.hostelworld.service.inf.ManagerService;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Controller("approveAction")
public class ApproveAction extends ActionSupport implements ServletResponseAware {

    private HttpServletResponse response;

    public List<String> hotelToOpenList = new ArrayList();
    public List<String> hotelInfoList = new ArrayList<>();
    public List<String> customerInfoList = new ArrayList<>();

    @Autowired
    private ManagerService managerService;

    public String execute() throws IOException {
        managerService.approveHotelToOpen(hotelToOpenList);
        managerService.approveHotelInfo(hotelInfoList);
        managerService.approveCustomerInfo(customerInfoList);

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("hotelToOpen", managerService.getHotelToOpen());
        request.put("hotelInfo", managerService.getHotelInfo());
        request.put("customerInfo", managerService.getCustomerInfo());
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

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}