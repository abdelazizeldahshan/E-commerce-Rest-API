// package gov.iti.jets;

// import java.util.Date;
// import java.util.HashSet;
// import java.util.Set;

// import gov.iti.jets.repo.entities.AdminEntity;
// import gov.iti.jets.repo.entities.CustomerEntity;
// import gov.iti.jets.repo.entities.OrderEntity;
// import gov.iti.jets.repo.entities.OrderProductsEntity;
// import gov.iti.jets.repo.entities.OrderProductsIdEntity;
// import gov.iti.jets.repo.entities.CategoryEntity;
// import gov.iti.jets.repo.entities.ProductEntity;
// import gov.iti.jets.repo.entities.clerkEntity;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

// public class Hello {

//     public static void main(String[] args) {

//         EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
// 		EntityManager entityManager = entityManagerFactory.createEntityManager();
//         Set<CategoryEntity> catelist = new HashSet<CategoryEntity>(0);

// //         entityManager.getTransaction().begin();

// //         // clerkEntity clerk = new clerkEntity();
// //         // clerk.setEmail("fawzi@gmail.com");
// //         // clerk.setUsername("fawzi");
// //         // clerk.setPassword("1234");
// //         // entityManager.persist(clerk);

// //         AdminEntity admin = new AdminEntity();
// //         admin.setEmail("fahd@gmail.com");
// //         admin.setPassword("123456789");
// //         admin.setUsername("fahd");
// //         entityManager.persist(admin);

//         CustomerEntity customers = new CustomerEntity();
//         customers.setEmail("soad@gmail.com");
//         customers.setUsername("soad");
//         customers.setJob("iti java developer");
//         customers.setIsMale(true);
//         customers.setCreditLimit(123.87);
//         customers.setPassword("77667");
//         customers.setInterests("discounts");
//         customers.setAddress("cairo");
//         entityManager.persist(customers);


// //         // CategoryEntity categoryEntity = new CategoryEntity();
// //         // categoryEntity.setDescription("description");
// //         // categoryEntity.setValue("value");
// //         // catelist.add(categoryEntity);
// //         // entityManager.persist(categoryEntity);

// //         // ProductEntity product = new ProductEntity();
// //         // product.setCategory(catelist);
// //         // product.setProductName("dell");
// //         // product.setProductDesc("dell laptop");
// //         // product.setPrice(45.33);
// //         // product.setStock(121);
// //         // product.setClerk(clerk);
// //         // entityManager.persist(product);

// //         // OrderEntity order = new OrderEntity();
// //         // order.setCreatedAt(new Date());
// //         // order.setCustomer(customers);
// //         // order.setIsSubmitted(false);
// //         // entityManager.persist(order);

// //         // OrderProductsIdEntity orderProductsId =new OrderProductsIdEntity();
// //         // orderProductsId.setOrderId(order.getId());
// //         // orderProductsId.setProductId(product.getId());

// //         // OrderProductsEntity orderProduct = new OrderProductsEntity();
// //         // orderProduct.setId(orderProductsId);
// //         // orderProduct.setOrder(order);
// //         // orderProduct.setProducts(product);
// //         // orderProduct.setQuantity(50);
// //         // entityManager.persist(orderProduct);

//         entityManager.getTransaction().commit();
//         entityManager.close();
//     }
// }
