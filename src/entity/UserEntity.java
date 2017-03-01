package entity;

import java.util.Date;

/**
 * Created by Hanz on 2017/2/15.
 * 用户实体
 * @author Hanz
 */
public class UserEntity {

    private String username;
    private String password;
    private Date createdDay;
    private Enum<Role> role;

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

    public Date getCreatedDay() {
        return createdDay;
    }

    public void setCreatedDay(Date createdDay) {
        this.createdDay = createdDay;
    }

    public Enum<Role> getRole() {
        return role;
    }

    public void setRole(Enum<Role> role) {
        this.role = role;
    }
}
