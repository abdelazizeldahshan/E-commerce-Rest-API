package gov.iti.jets.service.implementations;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.Models.admin.Admin;
import gov.iti.jets.Models.admin.AdminPost;
import gov.iti.jets.repo.daos.implemtion.AdminDaoImpl;
import gov.iti.jets.repo.daos.interfaces.AdminDaoInt;
import gov.iti.jets.repo.entities.AdminEntity;
import gov.iti.jets.service.interfaces.AdminServiceInt;
import gov.iti.jets.service.mappers.AdminMapper;

public class AdminServiceImpl implements AdminServiceInt {

    AdminMapper adminMapper = new AdminMapper();
    AdminDaoInt adminDao = new AdminDaoImpl();

    public List<Admin> getAdmins() {
        List<Admin> admins = new ArrayList<>();
        for (AdminEntity admin : adminDao.getAdmins()) {
            admins.add(adminMapper.AdminEntityToAdmin(admin));
        }
        return admins;
    }

    public Admin getAdminById(int id) {
        if (adminDao.getAdminById(id) == null)
            return null;
        return adminMapper.AdminEntityToAdmin(adminDao.getAdminById(id));
    }

    public boolean addAdmin(AdminPost admin) {
        return adminDao.addAdmin(adminMapper.AdminPostRequestToAdminEntity(admin));
    }

    public boolean updateAdmin(Admin admin) {
        return adminDao.updateAdmin(adminMapper.AdminToAdminEntity(admin));
    }

    public boolean deleteAdmin(int id) {
        return adminDao.deleteAdmin(id);
    }

}
