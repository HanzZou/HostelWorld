package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/18.
 *
 * @author Hanz
 */
@Controller("modifyHotelInfoAction")
public class ModifyHotelInfoAction implements ModelDriven<HotelInfoEntity> {

    @Autowired
    private HotelService hotelService;

    private HotelInfoEntity hotelInfoEntity = new HotelInfoEntity();

    @Override
    public HotelInfoEntity getModel() {
        return hotelInfoEntity;
    }

    public String execute() {
        Map session = ActionContext.getContext().getSession();
        String hotelId = ((HotelEntity)session.get("hotel")).getId();
        hotelInfoEntity.setHotelId(hotelId);
        hotelService.modifyInfo(hotelInfoEntity);

        HotelEntity hotel = (HotelEntity) ActionContext.getContext().getSession().get("hotel");

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("reservations", hotelService.getReservations(hotel.getId()));
        request.put("rooms", hotelService.getCheckinRecords(hotel.getId()));
        request.put("checkins", hotelService.getCheckins(hotel.getId()));
        request.put("finance", hotelService.getFinance(hotel.getId()));
        return "success";
    }
}
