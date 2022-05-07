package gov.iti.jets.Models.products;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductForOrder {

    private String name;
    private int orderQuantity;
    private int id;

    public ProductForOrder() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        return "ProductForOrder [id=" + id + ", name=" + name + ", orderQuantity=" + orderQuantity + "]";
    }

}
