package gov.iti.jets.repo.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clerks", catalog = "restapi")
public class clerkEntity extends UserEntity implements Serializable {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clerk")
    private Set<ProductEntity> products = new HashSet<ProductEntity>(0);

    public clerkEntity() {
    }

    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }

}
