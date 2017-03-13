package edu.nju.hostelworld.model;

/**
 * Created by Hanz on 2017/3/12.
 *
 * @author Hanz
 */
public class LoginUserEntity {
    private String uid;
    private String pwd;
    private Role role;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
