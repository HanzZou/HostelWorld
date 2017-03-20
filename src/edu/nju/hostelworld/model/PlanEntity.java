package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Hanz on 2017/3/20.
 *
 * @author Hanz
 */
@Entity
@Table(name = "plan", schema = "hostelworld")
public class PlanEntity {
    private String id;
    private String hotelId;
    private String room;
    private Date startDay;
    private Date endDay;
    private int price;
    private byte isReserved;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hotel_id", nullable = false, length = 7)
    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "room", nullable = false, length = 4)
    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Basic
    @Column(name = "start_day", nullable = false)
    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    @Basic
    @Column(name = "end_day", nullable = false)
    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "is_reserved", nullable = false)
    public byte getIsReserved() {
        return isReserved;
    }

    public void setIsReserved(byte isReserved) {
        this.isReserved = isReserved;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanEntity that = (PlanEntity) o;

        if (price != that.price) return false;
        if (isReserved != that.isReserved) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (startDay != null ? !startDay.equals(that.startDay) : that.startDay != null) return false;
        if (endDay != null ? !endDay.equals(that.endDay) : that.endDay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (startDay != null ? startDay.hashCode() : 0);
        result = 31 * result + (endDay != null ? endDay.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (int) isReserved;
        return result;
    }
}
