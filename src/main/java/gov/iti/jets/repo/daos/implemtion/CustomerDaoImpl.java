package gov.iti.jets.repo.daos.implemtion;

import java.util.List;

import gov.iti.jets.repo.daos.interfaces.CustomerDaoInt;
import gov.iti.jets.repo.entities.CustomerEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.Models.exceptions.addUser.AddUserException;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;

public class CustomerDaoImpl implements CustomerDaoInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<CustomerEntity> getAllCustomers() {
        TypedQuery<CustomerEntity> customers = entityManager.createQuery("from CustomerEntity", CustomerEntity.class);
        return customers.getResultList();
    }

    public CustomerEntity getCustomerById(int id) {
        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, id);
        if (customerEntity == null)
            throw new NotFoundException("No Customer Found With This ID");
        return customerEntity;
    }

    public boolean addCustomer(CustomerEntity customerEntity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(customerEntity);
        } catch (PersistenceException e) {
            throw new AddUserException("This Email exist before");
        }
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean updateCustomer(CustomerEntity customerEntity) {
        entityManager.getTransaction().begin();
        customerEntity.setPassword(getCustomerById(customerEntity.getId()).getPassword());
        entityManager.merge(customerEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteCustomer(int id) {
        CustomerEntity customerEntity = getCustomerById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(customerEntity);
        entityManager.getTransaction().commit();
        return true;
    }
}
