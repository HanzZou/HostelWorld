package edu.nju.hostelworld.model;

import javax.persistence.*;

/**
 * Created by Hanz on 2017/3/20.
 *
 * @author Hanz
 */
@Entity
@Table(name = "customer_info", schema = "hostelworld", catalog = "")
public class CustomerInfoEntity {
    private String id;
    private String memberId;
    private String name;
    private String telephone;
    private String address;
    private String cardId;
    private Byte isAccepted;

    @Id
    @Column(name = "id", nullable = false, length = 15)
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
    @Column(name = "name", nullable = false, length = 255)
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
    @Column(name = "card_id", nullable = false, length = 19)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "is_accepted", nullable = true)
    public Byte getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Byte isAccepted) {
        this.isAccepted = isAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerInfoEntity that = (CustomerInfoEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (isAccepted != null ? !isAccepted.equals(that.isAccepted) : that.isAccepted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (isAccepted != null ? isAccepted.hashCode() : 0);
        return result;
    }
}
