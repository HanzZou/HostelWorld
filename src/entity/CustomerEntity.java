package entity;

import java.sql.Blob;
import java.util.Date;

/**
 * Created by Hanz on 2017/2/15.
 * 用户实体
 * @author Hanz
 */
public class CustomerEntity {

    private String username;
    private String password;
    private String name;
    private String telephone;
    private String address;
    private Blob avatar;
    private String card_id;
    private boolean is_blocked;
    private Date blocked_day;
    private int credits;
    private int vip_grade;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public Date getBlocked_day() {
        return blocked_day;
    }

    public void setBlocked_day(Date blocked_day) {
        this.blocked_day = blocked_day;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getVip_grade() {
        return vip_grade;
    }

    public void setVip_grade(int vip_grade) {
        this.vip_grade = vip_grade;
    }
}
