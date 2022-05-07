package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.Models.admin.Admin;
import gov.iti.jets.Models.admin.AdminPost;

public interface AdminServiceInt {

    List<Admin> getAdmins();

    Admin getAdminById(int id);

    boolean addAdmin(AdminPost admin);

    boolean updateAdmin(Admin admin);

    boolean deleteAdmin(int id);
}
