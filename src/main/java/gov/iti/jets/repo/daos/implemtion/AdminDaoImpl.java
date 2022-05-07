package gov.iti.jets.repo.daos.implemtion;

import java.util.List;

import gov.iti.jets.repo.daos.interfaces.AdminDaoInt;
import gov.iti.jets.repo.entities.AdminEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import gov.iti.jets.Models.exceptions.addUser.AddUserException;
import gov.iti.jets.Models.exceptions.notfound.NotFoundException;

public class AdminDaoImpl implements AdminDaoInt {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<AdminEntity> getAdmins() {
        TypedQuery<AdminEntity> admins = entityManager.createQuery("from AdminEntity", AdminEntity.class);
        if(admins.getResultList() == null)
            throw new NotFoundException("No Admins Found");
        return admins.getResultList();
    }

    public AdminEntity getAdminById(int id) {
        AdminEntity adminEntity = entityManager.find(AdminEntity.class, id);
        if (adminEntity == null)
            return null;
        return adminEntity;
    }

    public boolean addAdmin(AdminEntity adminEntity) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(adminEntity);
        } catch (PersistenceException e) {
            throw new AddUserException("This Email exist before");
        }
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean updateAdmin(AdminEntity adminEntity) {
        entityManager.getTransaction().begin();
        entityManager.merge(adminEntity);
        entityManager.getTransaction().commit();
        return true;
    }

    public boolean deleteAdmin(int id) {
        AdminEntity adminEntity = getAdminById(id);
        if (adminEntity == null)
            throw new NotFoundException("Not Found admin with this id to delete");
        entityManager.getTransaction().begin();
        entityManager.remove(adminEntity);
        entityManager.getTransaction().commit();
        return true;
    }
}
