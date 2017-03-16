package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Hanz on 2017/3/16.
 *
 * @author Hanz
 */
@Entity
@Table(name = "checkin", schema = "hostelworld")
public class CheckinEntity {
    private String id;
    private String hotelId;
    private String member;
    private String room;
    private Date date;
    private int people;
    private Date leaveDate;
    private byte payCard;

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
    @Column(name = "people", nullable = false)
    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckinEntity that = (CheckinEntity) o;

        if (people != that.people) return false;
        if (payCard != that.payCard) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (hotelId != null ? !hotelId.equals(that.hotelId) : that.hotelId != null) return false;
        if (member != null ? !member.equals(that.member) : that.member != null) return false;
        if (room != null ? !room.equals(that.room) : that.room != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (leaveDate != null ? !leaveDate.equals(that.leaveDate) : that.leaveDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (hotelId != null ? hotelId.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + people;
        result = 31 * result + (leaveDate != null ? leaveDate.hashCode() : 0);
        result = 31 * result + (int) payCard;
        return result;
    }
}
