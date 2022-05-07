package gov.iti.jets.Models.products;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductPostRequest {

    private String productName;
    private String productDesc;
    private int quntity;
    private double price;
    private String clerkName;
    private String categoryname;

    public ProductPostRequest() {
    }

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

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }
    
    

    public String getCategoryname() {
        return this.categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    @Override
    public String toString() {
        return "ProductPostRequest [categoryname=" + categoryname + ", clerkName=" + clerkName + ", price=" + price
                + ", productDesc=" + productDesc + ", productName=" + productName + ", quntity=" + quntity + "]";
    }
}
