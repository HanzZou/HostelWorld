package edu.nju.hostelworld.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;

/**
 * Created by Hanz on 2017/3/13.
 *
 * @author Hanz
 */
@Entity
@Table(name = "customer", schema = "hostelworld")
public class CustomerEntity {
    private String id;
    private String password;
    private String name;
    private String telephone;
    private String address;
    private byte[] avatar;
    private String cardId;
    private Byte isBlocked;
    private Date blockedDay;
    private int credits;
    private int vipGrade;

    @Id
    @Column(name = "id", nullable = false, length = 7)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "telephone", nullable = true, length = 11)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "avatar", nullable = true)
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "card_id", nullable = false, length = 19)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "is_blocked", nullable = true)
    public Byte getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Byte isBlocked) {
        this.isBlocked = isBlocked;
    }

    @Basic
    @Column(name = "blocked_day", nullable = true)
    public Date getBlockedDay() {
        return blockedDay;
    }

    public void setBlockedDay(Date blockedDay) {
        this.blockedDay = blockedDay;
    }

    @Basic
    @Column(name = "credits", nullable = false)
    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Basic
    @Column(name = "vip_grade", nullable = false)
    public int getVipGrade() {
        return vipGrade;
    }

    public void setVipGrade(int vipGrade) {
        this.vipGrade = vipGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerEntity that = (CustomerEntity) o;

        if (credits != that.credits) return false;
        if (vipGrade != that.vipGrade) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (!Arrays.equals(avatar, that.avatar)) return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (isBlocked != null ? !isBlocked.equals(that.isBlocked) : that.isBlocked != null) return false;
        if (blockedDay != null ? !blockedDay.equals(that.blockedDay) : that.blockedDay != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(avatar);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (isBlocked != null ? isBlocked.hashCode() : 0);
        result = 31 * result + (blockedDay != null ? blockedDay.hashCode() : 0);
        result = 31 * result + credits;
        result = 31 * result + vipGrade;
        return result;
    }
}
