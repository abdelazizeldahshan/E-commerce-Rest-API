package gov.iti.jets.service.mappers;

import gov.iti.jets.Models.admin.Admin;
import gov.iti.jets.Models.admin.AdminPost;
import gov.iti.jets.repo.entities.AdminEntity;

public class AdminMapper {

    public Admin AdminEntityToAdmin(AdminEntity adminEntity) {
        Admin admin = new Admin();
        admin.setEmail(adminEntity.getEmail());
        admin.setId(adminEntity.getId());
        admin.setName(adminEntity.getUsername());
        return admin;
    }

    public AdminEntity AdminToAdminEntity(Admin admin) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setId(admin.getId());
        adminEntity.setEmail(admin.getEmail());
        adminEntity.setUsername(admin.getName());
        adminEntity.setPassword(admin.getPassword());
        return adminEntity;
    }

    public AdminEntity AdminPostRequestToAdminEntity(AdminPost adminPost) {
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setEmail(adminPost.getEmail());
        adminEntity.setUsername(adminPost.getName());
        adminEntity.setPassword(adminPost.getPassword());
        return adminEntity;
    }
}
