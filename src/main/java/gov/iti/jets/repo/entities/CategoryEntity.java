package gov.iti.jets.repo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category", catalog = "restapi")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "value", nullable = false, length = 45)
    private String value;

    @Column(name = "description", length = 150)
    private String description;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "product_has_category", catalog = "restapi", joinColumns = {
            @JoinColumn(name = "category_id", nullable = false, updatable = false) }, inverseJoinColumns = {
                    @JoinColumn(name = "product_id", nullable = false, updatable = false) })
    private Set<ProductEntity> products = new HashSet<ProductEntity>(0);

    public CategoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryEntity [description=" + description + ", id=" + id + ", products=" + products + ", value="
                + value + "]";
    }

}
