package gov.iti.jets.Models.order;

import java.util.Date;

import gov.iti.jets.Models.customer.Customer;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Oredr {

    private int id;
    private double totalPrice;
    private Date createdAt;
    private Customer customer;
    private boolean isSubmitted;

    public Oredr() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    @Override
    public String toString() {
        return "Oredr [createdAt=" + createdAt + ", customer=" + customer + ", id=" + id + ", isSubmitted="
                + isSubmitted + ", totalPrice=" + totalPrice + "]";
    }

}
