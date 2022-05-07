package gov.iti.jets.repo.daos.implemtion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import gov.iti.jets.repo.daos.interfaces.CategoryDaoInt;
import gov.iti.jets.repo.daos.interfaces.ClerkDaoInt;
import gov.iti.jets.repo.daos.interfaces.ProductDaoInt;
import gov.iti.jets.repo.entities.CategoryEntity;
import gov.iti.jets.repo.entities.ProductEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;

public class ProductDaoImpl implements ProductDaoInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    static Set<CategoryEntity> catelist = new HashSet<CategoryEntity>(0);
    CategoryDaoInt categoryDao = new CategoryDaoImpl();
    ClerkDaoInt clerkDao = new ClerkDaoImpl();

    public List<ProductEntity> getProducts() {
        TypedQuery<ProductEntity> products = entityManager.createQuery("from ProductEntity", ProductEntity.class);
        return products.getResultList();
    }

    public ProductEntity getProductById(int id) {
        ProductEntity productEntity = entityManager.find(ProductEntity.class, id);
        if (productEntity == null)
            throw new NotFoundException("No Product Found With This ID");
        return productEntity;
    }

    public boolean addProduct(ProductEntity productEntity, String clerkName, String categoryName) {
        entityManager.getTransaction().begin();
        productEntity.setClerk(clerkDao.getClerkByName(clerkName));
        catelist.add(categoryDao.getCateoryByName(categoryName));
        productEntity.setCategory(catelist);
        entityManager.persist(productEntity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return true;
    }

    public void deleteProduct(int id) {
        ProductEntity productEntity = getProductById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(productEntity);
        entityManager.getTransaction().commit();
    }

    public void updateProduct(ProductEntity productEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(productEntity);
        entityManager.getTransaction().commit();
    }
}
