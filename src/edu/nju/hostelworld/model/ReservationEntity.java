package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Hanz on 2017/3/28.
 *
 * @author Hanz
 */
@Entity
@Table(name = "reservation", schema = "hostelworld")
public class ReservationEntity {
    private String id;
    private String memberId;
    private String planId;
    private byte isCanceled;
    private byte isFinished;
    private Date time;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "plan_id", nullable = false, length = 10)
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "is_canceled", nullable = false)
    public byte getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(byte isCanceled) {
        this.isCanceled = isCanceled;
    }

    @Basic
    @Column(name = "is_finished", nullable = false)
    public byte getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(byte isFinished) {
        this.isFinished = isFinished;
    }

    @Basic
    @Column(name = "time", nullable = false)
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (isCanceled != that.isCanceled) return false;
        if (isFinished != that.isFinished) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (int) isCanceled;
        result = 31 * result + (int) isFinished;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}
