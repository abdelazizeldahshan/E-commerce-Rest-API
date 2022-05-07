package gov.iti.jets.repo.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products", catalog = "restapi")
public class ProductEntity implements java.io.Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false, length = 65535)
    private String productName;

    @Column(name = "product_desc", nullable = false, length = 65535)
    private String productDesc;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_has_category", catalog = "restapi", joinColumns = {
            @JoinColumn(name = "product_id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "category_id", nullable = false, updatable = false) })
    private Set<CategoryEntity> category;

    @Column(name = "stock", nullable = false)
    private Integer stock;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderProductsEntity> orderProducts = new HashSet<OrderProductsEntity>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clerk_id")
    private clerkEntity clerk;

    public ProductEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<CategoryEntity> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryEntity> category) {
        this.category = category;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        if (stock >= 0)
            this.stock = stock;
    }

    public Set<OrderProductsEntity> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProductsEntity> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public clerkEntity getClerk() {
        return clerk;
    }

    public void setClerk(clerkEntity clerk) {
        this.clerk = clerk;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stock=" + stock + '\'' +
                '}';
    }
}
