package gov.iti.jets.repo.daos.interfaces;

import java.util.List;

import gov.iti.jets.repo.entities.ProductEntity;

public interface ProductDaoInt {

    List<ProductEntity> getProducts();

    ProductEntity getProductById(int id);

    boolean addProduct(ProductEntity productEntity, String clerkName, String categoryName);

    void deleteProduct(int id);

    void updateProduct(ProductEntity productEntity);
}
