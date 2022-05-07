package gov.iti.jets.service.mappers;

import gov.iti.jets.Models.products.Product;
import gov.iti.jets.Models.products.ProductPostRequest;
import gov.iti.jets.Models.products.ProductPutRequest;
import gov.iti.jets.repo.entities.ProductEntity;

public class ProductMapper {

    CategoryMapper categoryMapper = new CategoryMapper();
    ClerkMappers clerkMappers = new ClerkMappers();

    public Product ProductEntityToProduct(ProductEntity productEntity) {

        if (productEntity == null)
            return null;

        Product product = new Product();
        product.setId(productEntity.getId());
        product.setPrice(productEntity.getPrice());
        product.setQuntity(productEntity.getStock());
        product.setProductName(productEntity.getProductName());
        product.setProductDesc(productEntity.getProductDesc());
        product.setClerkName(productEntity.getClerk().getUsername());
        product.setCategories(categoryMapper.categoryEntitySetTCategorySet(productEntity.getCategory()));
        return product;
    }

    public ProductEntity productPostRequestToProductEntity(ProductPostRequest productPostRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setPrice(productPostRequest.getPrice());
        productEntity.setProductDesc(productPostRequest.getProductDesc());
        productEntity.setProductName(productPostRequest.getProductName());
        productEntity.setStock(productPostRequest.getQuntity());
        return productEntity;
    }

    public ProductEntity productToProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(categoryMapper.CategorySetToCategoryEntitySet(product.getCategories()));
        productEntity.setId(product.getId());
        productEntity.setPrice(product.getPrice());
        productEntity.setProductDesc(product.getProductDesc());
        productEntity.setProductName(product.getProductName());
        productEntity.setStock(product.getQuntity());
        return productEntity;
    }

    public ProductEntity productPutRequestToProductEntity(ProductPutRequest productPutRequest) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(categoryMapper.CategorySetToCategoryEntitySet(productPutRequest.getCategories()));
        productEntity.setId(productPutRequest.getId());
        productEntity.setPrice(productPutRequest.getPrice());
        productEntity.setProductDesc(productPutRequest.getProductDesc());
        productEntity.setProductName(productPutRequest.getProductName());
        productEntity.setStock(productPutRequest.getQuntity());
        productEntity.setClerk(clerkMappers.ClerkToClerkEntity(productPutRequest.getClerk()));
        return productEntity;
    }

    // public Set<ProductEntity>
    // setOfProductToSetOfProductEntity(Set<ProductForOrder> productForOrders){
    // Set<ProductEntity> products = new HashSet<>();
    // for(ProductForOrder product : productForOrders){
    // ProductEntity productEntity = new ProductEntity();
    // productEntity.setId(product.getId());
    // productEntity.setProductName(product.getName());
    // products.add(productEntity);
    // }
    // return products;
    // }
}
