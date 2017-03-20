package edu.nju.hostelworld.action;

import com.opensymphony.xwork2.ModelDriven;
import edu.nju.hostelworld.model.HotelInfoEntity;
import edu.nju.hostelworld.service.inf.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
        hotelService.modifyInfo(hotelInfoEntity);
        return "success";
    }
}
