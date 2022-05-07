package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.Models.products.Product;
import gov.iti.jets.Models.products.ProductPostRequest;
import gov.iti.jets.Models.products.ProductPutRequest;

public interface ProductServiceInt {

    List<Product> getProducts();

    Product getProductByID(int id);

    boolean addProduct(ProductPostRequest productPostRequest);

    boolean deleteProduct(int id);

    boolean updateProduct(ProductPutRequest productPutRequest);
}
