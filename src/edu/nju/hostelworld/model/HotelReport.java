package edu.nju.hostelworld.model;

/**
 * Created by Hanz on 2017/6/27.
 *
 * @author Hanz
 */
public class HotelReport {
    String hotelName;
    String hotelNo;
    int ordernum;
    double rateavg;
    double moneyavg;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelNo() {
        return hotelNo;
    }

    public void setHotelNo(String hotelNo) {
        this.hotelNo = hotelNo;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public double getRateavg() {
        return rateavg;
    }

    public void setRateavg(double rateavg) {
        this.rateavg = rateavg;
    }

    public double getMoneyavg() {
        return moneyavg;
    }{}

    public void setMoneyavg(double moneyavg) {
        this.moneyavg = moneyavg;
    }

    public HotelReport(String hotelName, String hotelNo, int ordernum, double rateavg, double moneyavg) {
        this.hotelName = hotelName;
        this.hotelNo = hotelNo;
        this.ordernum = ordernum;
        this.rateavg = rateavg;
        this.moneyavg = moneyavg;
    }
}
