package gov.iti.jets.repo.daos.implemtion;

import java.util.List;
import gov.iti.jets.repo.daos.interfaces.CustomerDaoInt;
import gov.iti.jets.repo.daos.interfaces.OrderdDaoInt;
import gov.iti.jets.repo.daos.interfaces.ProductDaoInt;
import gov.iti.jets.repo.entities.OrderEntity;
import gov.iti.jets.repo.entities.OrderProductsEntity;
import gov.iti.jets.repo.entities.OrderProductsIdEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;

public class OrderDaoImpl implements OrderdDaoInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    ProductDaoInt productDaoInt = new ProductDaoImpl();
    CustomerDaoInt customerDaoInt = new CustomerDaoImpl();

    public List<OrderEntity> getOrders() {
        TypedQuery<OrderEntity> orders = entityManager.createQuery("from OrderEntity", OrderEntity.class);
        return orders.getResultList();
    }

    public OrderEntity getOrderById(int id) {
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, id);
        if (orderEntity == null)
            throw new NotFoundException("No Order Found With This ID");
        return orderEntity;
    }

    public OrderEntity addOrder(OrderEntity orderEntity, int CustomerId, double totalPrice) {
        entityManager.getTransaction().begin();
        orderEntity.setCustomer(customerDaoInt.getCustomerById(CustomerId));
        orderEntity.setIsSubmitted(true);
        orderEntity.setTotalPrice(totalPrice);
        entityManager.persist(orderEntity);
        entityManager.getTransaction().commit();
        OrderEntity oEntity = getOrderById(orderEntity.getId());
        return oEntity;
    }

    public boolean updateOrder(OrderEntity orderEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(orderEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteOrder(int id) {
        OrderEntity orderEntity = getOrderById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(orderEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    public OrderProductsIdEntity makeOrderProductsIdEntities(int productId, OrderEntity orderEntity) {
        OrderProductsIdEntity orderProductsIdEntity = new OrderProductsIdEntity();
        orderProductsIdEntity.setOrderId(orderEntity.getId());
        orderProductsIdEntity.setProductId(productDaoInt.getProductById(productId).getId());
        return orderProductsIdEntity;
    }

    public boolean addProductToOrder(OrderEntity orderEntity, int quantity, int productId) {
        OrderProductsIdEntity orderProductsIdEntity = makeOrderProductsIdEntities(productId, orderEntity);
        OrderProductsEntity orderProductsEntity = new OrderProductsEntity();
        entityManager.getTransaction().begin();
        orderProductsEntity.setId(orderProductsIdEntity);
        orderProductsEntity.setOrder(orderEntity);
        orderProductsEntity.setProducts(productDaoInt.getProductById(orderProductsIdEntity.getProductId()));
        orderProductsEntity.setQuantity(quantity);
        entityManager.persist(orderProductsEntity);
        entityManager.getTransaction().commit();
        return true;
    }
}
