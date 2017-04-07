package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.HotelEntity;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Map;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
@Controller("releasePlanAction")
public class ReleasePlanAction extends ActionSupport implements ModelDriven<PlanEntity> {

    @Autowired
    private HotelService hotelService;

    private PlanEntity plan = new PlanEntity();

    @Override
    public PlanEntity getModel() {
        return plan;
    }

    public String execute() {
        plan.setIsReserved((byte)0);
        // 获取酒店编号
        Map session = ActionContext.getContext().getSession();
        plan.setHotelId(((HotelEntity)session.get("hotel")).getId());
        hotelService.releasePlan(plan);

        HotelEntity hotel = (HotelEntity) ActionContext.getContext().getSession().get("hotel");

        Map request = (Map) ActionContext.getContext().get("request");
        request.put("reservations", hotelService.getReservations(hotel.getId()));
        request.put("rooms", hotelService.getCheckinRecords(hotel.getId()));
        request.put("checkins", hotelService.getCheckins(hotel.getId()));
        request.put("finance", hotelService.getFinance(hotel.getId()));
        return "SUCCESS";
    }

}
