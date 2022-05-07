package gov.iti.jets.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import gov.iti.jets.Models.exceptions.limitquantity.QuntityException;
import gov.iti.jets.Models.order.OrderPostRequest;
import gov.iti.jets.Models.order.Oredr;
import gov.iti.jets.Models.products.ProductForOrder;
import gov.iti.jets.repo.daos.implemtion.OrderDaoImpl;
import gov.iti.jets.repo.daos.implemtion.ProductDaoImpl;
import gov.iti.jets.repo.daos.interfaces.OrderdDaoInt;
import gov.iti.jets.repo.daos.interfaces.ProductDaoInt;
import gov.iti.jets.repo.entities.OrderEntity;
import gov.iti.jets.repo.entities.ProductEntity;
import gov.iti.jets.service.interfaces.OrderServiceInt;
import gov.iti.jets.service.mappers.OrderMappers;

public class OrderServiceImpl implements OrderServiceInt {

    OrderMappers orderMappers = new OrderMappers();
    OrderdDaoInt orderDao = new OrderDaoImpl();
    ProductDaoInt productDaoInt = new ProductDaoImpl();

    public List<Oredr> getAllOredrs() {
        List<Oredr> oreders = new ArrayList<>();
        for (OrderEntity order : orderDao.getOrders()) {
            oreders.add(orderMappers.oredrEntityTOredr(order));
        }
        return oreders;
    }

    public Oredr getOrderById(int id) {
        return orderMappers.oredrEntityTOredr(orderDao.getOrderById(id));
    }

    public boolean addOrder(OrderPostRequest orderPostRequest) {
        OrderEntity orderEntity = orderDao.addOrder(orderMappers.orderPostRequestToOrderEntity(orderPostRequest),
                orderPostRequest.getCustomerId(), getTotalPrice(orderPostRequest.getProducts()));
        for (ProductForOrder productForOrder : orderPostRequest.getProducts()) {
            ProductEntity productEntity = productDaoInt.getProductById(productForOrder.getId());
            if (productEntity.getStock() < productForOrder.getOrderQuantity()) {
                throw new QuntityException("Not enough quntity for Poduct " + productForOrder.getName());
            } else {
                orderDao.addProductToOrder(orderEntity, productForOrder.getOrderQuantity(), productForOrder.getId());
                productEntity.setStock(productEntity.getStock() - productForOrder.getOrderQuantity());
                productDaoInt.updateProduct(productEntity);
            }
        }
        return true;
    }

    public double getTotalPrice(Set<ProductForOrder> productForOrders) {
        double prices = 0.0;
        for (ProductForOrder productForOrder : productForOrders) {
            prices += productDaoInt.getProductById(productForOrder.getId()).getPrice();
        }
        return prices;
    }
}
