package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Entity
@Table(name = "checkin", schema = "hostelworld", catalog = "")
public class CheckinEntity {
    private String id;
    private String hotelId;
    private String member;
    private String room;
    private Date date;
    private Date leaveDate;
    private byte payCard;
    private int pNum;
    private String names;
    private byte checkout;

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
    @Column(name = "member", nullable = false, length = 7)
    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
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
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "leave_date", nullable = true)
    public Date getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    @Basic
    @Column(name = "pay_card", nullable = false)
    public byte getPayCard() {
        return payCard;
    }

    public void setPayCard(byte payCard) {
        this.payCard = payCard;
    }

    @Basic
    @Column(name = "p_num", nullable = false)
    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    @Basic
    @Column(name = "names", nullable = true, length = 255)
    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    @Basic
    @Column(name = "checkout", nullable = false)
    public byte getCheckout() {
        return checkout;
    }

    public void setCheckout(byte checkout) {
        this.checkout = checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckinEntity that = (CheckinEntity) o;

        if (payCard != that.payCard) return false;
        if (pNum != that.pNum) return false;
        if (checkout != that.checkout) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (leaveDate != null ? !leaveDate.equals(that.leaveDate) : that.leaveDate != null) return false;
        if (names != null ? !names.equals(that.names) : that.names != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        result = 31 * result + (int) payCard;
        result = 31 * result + pNum;
        result = 31 * result + (names != null ? names.hashCode() : 0);
        result = 31 * result + (int) checkout;
        return result;
    }
}
