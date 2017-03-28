package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.CheckinEntity;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Controller("checkinByHand")
public class CheckinByHandAction extends ActionSupport implements ModelDriven<CheckinEntity> {

    @Autowired
    private HotelService hotelService;

    private CheckinEntity checkinEntity = new CheckinEntity();

    @Override
    public CheckinEntity getModel() {
        return checkinEntity;
    }

    public String execute() {
        HotelEntity hotelEntity = (HotelEntity) ActionContext.getContext().getSession().get("hotel");
        checkinEntity.setHotelId(hotelEntity.getId());
        checkinEntity.setMember("0000000");
        checkinEntity.setPayCard((byte)0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        checkinEntity.setDate(Date.valueOf(simpleDateFormat.format(new java.util.Date())));
        checkinEntity.setLeaveDate(Date.valueOf(simpleDateFormat.format(new java.util.Date())));
        checkinEntity.setCheckout((byte)0);
        hotelService.checkinByHand(checkinEntity);
        return "success";
    }
}
