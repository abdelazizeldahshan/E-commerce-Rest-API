package gov.iti.jets.service.mappers;

import gov.iti.jets.Models.clerks.Clerk;
import gov.iti.jets.Models.clerks.ClerkPost;
import gov.iti.jets.repo.entities.clerkEntity;

public class ClerkMappers {

    public clerkEntity ClerkToClerkEntity(Clerk clerk) {
        clerkEntity clerkEntity = new clerkEntity();
        clerkEntity.setId(clerk.getId());
        clerkEntity.setEmail(clerk.getEmail());
        clerkEntity.setUsername(clerk.getName());
        return clerkEntity;
    }

    public Clerk ClerkEntityToClerk(clerkEntity clerkEntity) {
        Clerk clerk = new Clerk();
        clerk.setEmail(clerkEntity.getEmail());
        clerk.setId(clerkEntity.getId());
        clerk.setName(clerkEntity.getUsername());
        return clerk;
    }

    public clerkEntity ClerkPostToClerkEntity(ClerkPost clerk) {
        clerkEntity clerkEntity = new clerkEntity();
        clerkEntity.setEmail(clerk.getEmail());
        clerkEntity.setUsername(clerk.getName());
        clerkEntity.setPassword(clerk.getPassword());
        return clerkEntity;
    }
}
