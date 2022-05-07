package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.Models.clerks.Clerk;
import gov.iti.jets.Models.clerks.ClerkPost;

public interface ClerkServiceInt {

    List<Clerk> getClerks();

    Clerk getClerkById(int id);

    Clerk getClerkByName(String name);

    boolean addClerk(ClerkPost clerkPost);

    boolean updateClerk(Clerk clerk);

    boolean deleteClerk(int id);

}
