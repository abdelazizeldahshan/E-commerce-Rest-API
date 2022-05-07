package gov.iti.jets.repo.daos.interfaces;

import java.util.List;

import gov.iti.jets.repo.entities.clerkEntity;

public interface ClerkDaoInt {

    List<clerkEntity> getAllClerks();

    clerkEntity getClerkById(int id);

    clerkEntity getClerkByName(String name);

    boolean addClerk(clerkEntity clerkEntity);

    boolean updateClerk(clerkEntity clerkEntity);

    boolean deleteClerk(int id);
}
