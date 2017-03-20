package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by Hanz on 2017/3/20.
 *
 * @author Hanz
 */
@Entity
@Table(name = "reservation", schema = "hostelworld", catalog = "")
public class ReservationEntity {
    private String id;
    private String memberId;
    private String planId;
    private Byte isCanceled;

    @Id
    @Column(name = "id", nullable = false, length = 10)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "member_id", nullable = true, length = 7)
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "plan_id", nullable = true, length = 10)
    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Basic
    @Column(name = "is_canceled", nullable = true)
    public Byte getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(Byte isCanceled) {
        this.isCanceled = isCanceled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (planId != null ? !planId.equals(that.planId) : that.planId != null) return false;
        if (isCanceled != null ? !isCanceled.equals(that.isCanceled) : that.isCanceled != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (planId != null ? planId.hashCode() : 0);
        result = 31 * result + (isCanceled != null ? isCanceled.hashCode() : 0);
        return result;
    }
}
