package gov.iti.jets.repo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
@Embeddable
public class OrderProductsIdEntity implements java.io.Serializable {
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "product_id", nullable = false)
    private Integer productId;

    public OrderProductsIdEntity(){}
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrderProductsIdEntity))
            return false;
        OrderProductsIdEntity castOther = (OrderProductsIdEntity) other;

        return (this.getOrderId() == castOther.getOrderId())
                && (this.getProductId() == castOther.getProductId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrderId();
        result = 37 * result + this.getProductId();
        return result;
    }

    @Override
    public String toString() {
        return "OrderProductsIdEntity{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                '}';
    }
}
