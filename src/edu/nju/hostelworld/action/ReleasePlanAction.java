package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.PlanEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Hanz on 2017/3/15.
 *
 * @author Hanz
 */
@Controller
public class ReleasePlanAction extends ActionSupport implements ModelDriven<PlanEntity> {

    @Autowired
    private HotelService hotelService;

    private PlanEntity plan = new PlanEntity();

    @Override
    public PlanEntity getModel() {
        return plan;
    }

    public String execute() {
        plan.setIsReserved(false);
        //获取酒店编号
        plan.setHotelId("0000001");
        hotelService.releasePlan(plan);
        return "SUCCESS";
    }

}
