package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by Hanz on 2017/3/20.
 *
 * @author Hanz
 */
@Entity
@Table(name = "card", schema = "hostelworld", catalog = "")
public class CardEntity {
    private String id;
    private Integer balance;

    @Id
    @Column(name = "id", nullable = false, length = 19)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "balance", nullable = true)
    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardEntity that = (CardEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        return result;
    }
}
