package gov.iti.jets.repo.daos.implemtion;

import java.util.List;

import gov.iti.jets.repo.daos.interfaces.ClerkDaoInt;
import gov.iti.jets.repo.entities.clerkEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.Models.exceptions.addUser.AddUserException;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;

public class ClerkDaoImpl implements ClerkDaoInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<clerkEntity> getAllClerks() {
        TypedQuery<clerkEntity> clerks = entityManager.createQuery("from clerkEntity", clerkEntity.class);
        return clerks.getResultList();
    }

    public clerkEntity getClerkById(int id) {
        clerkEntity clerkEntity = entityManager.find(clerkEntity.class, id);
        if (clerkEntity == null)
            throw new NotFoundException("not clerk with this id");
        return clerkEntity;
    }

    public clerkEntity getClerkByName(String name) {
        clerkEntity clerkEntity;
        TypedQuery<clerkEntity> clerk = entityManager
                .createQuery("from clerkEntity clerk where clerk.username like:name", clerkEntity.class)
                .setParameter("name", name);
        try {
            clerkEntity = clerk.getResultList().get(0);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException("not found Clerk by this name");
        }
        return clerkEntity;
    }

    public boolean addClerk(clerkEntity clerkEntity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(clerkEntity);
        } catch (PersistenceException e) {
            throw new AddUserException("This Email exist before");
        }
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean updateClerk(clerkEntity clerkEntity) {
        entityManager.getTransaction().begin();
        clerkEntity.setPassword(getClerkById(clerkEntity.getId()).getPassword());
        entityManager.merge(clerkEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteClerk(int id) {
        clerkEntity clerkEntity = getClerkById(id);
        entityManager.getTransaction().begin();
        entityManager.remove(clerkEntity);
        entityManager.getTransaction().commit();
        return true;
    }
}
