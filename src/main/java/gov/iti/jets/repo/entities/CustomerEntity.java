package gov.iti.jets.repo.entities;

import jakarta.persistence.*;
import java.util.Set;
import java.io.Serializable;

@Entity
@Table(name = "customers", catalog = "restapi")
public class CustomerEntity extends UserEntity implements Serializable {

    @Column(name = "interests", length = 65535)
    private String interests;

    @Column(name = "is_male")
    private Boolean isMale;

    @Column(name = "job", length = 50)
    private String job;

    @Column(name = "credit_limit", nullable = false)
    private double creditLimit;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.REMOVE)
    private Set<OrderEntity> orders;

    @Column(name = "address", length = 50)
    private String address;

    public CustomerEntity() {
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Boolean getIsMale() {
        return isMale;
    }

    public void setIsMale(Boolean male) {
        isMale = male;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Set<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderEntity> orders) {
        this.orders = orders;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                ", interests='" + interests + '\'' +
                ", isMale=" + isMale +
                ", job='" + job + '\'' +
                ", creditLimit=" + creditLimit +
                ", orders=" + orders +
                '}';
    }
}
