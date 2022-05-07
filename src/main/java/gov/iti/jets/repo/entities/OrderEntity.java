package gov.iti.jets.repo.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders", catalog = "restapi")
public class OrderEntity implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", nullable = false, length = 10)
    private Date createdAt = new Date();

    @Column(name = "is_submitted")
    private Boolean isSubmitted = false;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.REMOVE)
    private Set<OrderProductsEntity> orderProducts = new HashSet<OrderProductsEntity>();

    public OrderEntity() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    public void setIsSubmitted(Boolean submitted) {
        isSubmitted = submitted;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderProductsEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProductsEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", isSubmitted=" + isSubmitted +
                ", totalPrice=" + totalPrice +
                ", orderProducts=" + orderProducts +
                '}';
    }
}
