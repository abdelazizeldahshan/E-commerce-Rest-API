package gov.iti.jets.Models.category;

import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class categoryGetProducts {
    
    private String productName;
    private String productDesc;
    private int productQuantity;
    private double price;
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    private Link productLink;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Link getProductLink() {
        return productLink;
    }

    public void setProductLink(Link productLink) {
        this.productLink = productLink;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Override
    public String toString() {
        return "categoryGetProducts [price=" + price + ", productDesc=" + productDesc + ", productLink=" + productLink
                + ", productName=" + productName + ", productQuantity=" + productQuantity + "]";
    }

}
