package gov.iti.jets.Models.order;

import java.util.Date;
import java.util.Set;
import gov.iti.jets.Models.products.ProductForOrder;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OrderPostRequest {

    private Date createdAt;
    private int customerId;
    private Set<ProductForOrder> products;

    public OrderPostRequest() {
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Set<ProductForOrder> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductForOrder> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderPostRequest [createdAt=" + createdAt + ", customerId=" + customerId + ", products=" + products
                + "]";
    }

}
