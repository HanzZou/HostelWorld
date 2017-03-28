package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Entity
@Table(name = "finance_record", schema = "hostelworld")
public class FinanceRecordEntity {
    private String id;
    private String hotelId;
    private String memberId;
    private int price;
    private Date time;
    private Byte isSettled;

    @Id
    @Column(name = "id", nullable = false, length = 15)
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
    @Column(name = "member_id", nullable = false, length = 7)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Basic
    @Column(name = "is_settled", nullable = true)
    public Byte getIsSettled() {
        return isSettled;
    }

    public void setIsSettled(Byte isSettled) {
        this.isSettled = isSettled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinanceRecordEntity that = (FinanceRecordEntity) o;

        if (price != that.price) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (isSettled != null ? !isSettled.equals(that.isSettled) : that.isSettled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isSettled != null ? isSettled.hashCode() : 0);
        return result;
    }
}
