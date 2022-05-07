package gov.iti.jets.Models.products;

import java.util.Set;

import gov.iti.jets.Models.category.Category;
import gov.iti.jets.Models.clerks.Clerk;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductPutRequest {

    private int id;
    private String productName;
    private String productDesc;
    private int quntity;
    private double price;
    private Clerk clerk;
    private Set<Category> Categories;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getQuntity() {
        return quntity;
    }

    public void setQuntity(int quntity) {
        this.quntity = quntity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Clerk getClerk() {
        return clerk;
    }

    public void setClerk(Clerk clerk) {
        this.clerk = clerk;
    }

    public Set<Category> getCategories() {
        return Categories;
    }

    public void setCategories(Set<Category> categories) {
        Categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductPutRequest [Categories=" + Categories + ", " + ", clerk=" + clerk
                + ", id=" + id + ", price=" + price + ", productDesc=" + productDesc + ", productName=" + productName
                + ", quntity=" + quntity + "]";
    }

}
